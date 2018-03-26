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
public class AddToCartServlet extends HttpServlet {
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
        String urlRewriting = "MiddleServlet" + "?" +
                                "btnAction=Search" + "&" +
                                "txtSearchType=PriceInRange" + "&" +
                                "txtSearchMinPrice=" + request.getParameter("txtLastMinPrice").trim() + "&" +
                                "txtSearchMaxPrice=" + request.getParameter("txtLastMaxPrice").trim();
        
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                UserDTO user = (UserDTO) session.getAttribute("USER");
                
                if (user != null && user.getRole() == 0) {
                    String mobileID = request.getParameter("txtMobileID").trim();

                    boolean errorFound = false;
                    CartErr err = new CartErr();

                    int quantity = 1;
                    try {
                        String tmp = request.getParameter("txtMobileQuantity").trim();
                        if (!tmp.isEmpty()) {
                            quantity = Integer.parseInt(tmp);
                            if (quantity <= 0) throw new NumberFormatException();
                        }
                    } catch (NumberFormatException ex) {
                        err.setInvalidQuantity("Quantity must be a positive integer");
                        errorFound = true;
                    }

                    CartDAO dao = new CartDAO();
                    if (!errorFound) dao.addToCart(user.getUserID(), mobileID, quantity);
                    else request.setAttribute("ADDCARTERROR", err);
                }
            }
        } catch (NamingException ex) {
            log("AddToCartServlet _ Naming" + ex.getMessage());
        } catch (SQLException ex) {
            log("AddToCartServlet _ sql" + ex.getMessage());
        } finally {
            request.getRequestDispatcher(urlRewriting).forward(request, response);
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
