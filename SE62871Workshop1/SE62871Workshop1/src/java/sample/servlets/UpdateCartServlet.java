/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.cart.CartDAO;
import sample.cart.CartErr;
import sample.user.UserDTO;

/**
 *
 * @author dragneol
 */
public class UpdateCartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = "MiddleServlet?btnAction=View cart";
        
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                UserDTO user = (UserDTO) session.getAttribute("USER");
                
                if (user != null && user.getRole() == 0) {
                    CartErr err = new CartErr();
                    boolean errorFound = false;

                    String mobileID = request.getParameter("txtMobileID").trim();

                    int quantity = 0;
                    try {
                        String tmp = request.getParameter("txtQuantity").trim();
                        quantity = Integer.parseInt(tmp);
                        if (quantity < 0) throw new NumberFormatException();
                    } catch (NumberFormatException ex) {
                        err.setInvalidQuantity("Quantity must be a nonnegative integer");
                        errorFound = true;
                    }

                    if (!errorFound) {
                        CartDAO dao = new CartDAO();
                        if (quantity != 0)
                            dao.editCart(user.getUserID(), mobileID, quantity);
                        else dao.removeItemInCart(user.getUserID(), mobileID);
                    } else request.setAttribute("UPDATECARTERROR", err);
                }
            }
        } catch (NamingException ex) {
            log("UpdateCartServlet _ Naming" + ex.getMessage());
        } catch (SQLException ex) {
            log("UpdateCartServlet _ sql" + ex.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
