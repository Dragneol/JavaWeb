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
import sample.mobile.MobileDAO;
import sample.mobile.MobileErr;
import sample.user.UserDTO;

/**
 *
 * @author dragneol
 */
public class UpdateMobileServlet extends HttpServlet {

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
        MobileErr err = new MobileErr();
        boolean errorFound = false;
        String urlRewriting = "MiddleServlet" + "?" +
                                "btnAction=Search" + "&" +
                                "txtSearchType=IDorName" + "&" +
                                "txtSearch=" + request.getParameter("txtLastSearchValue").trim();
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                UserDTO user = (UserDTO) session.getAttribute("USER");
                
                if (user != null && user.getRole() == 1) {
            
                    String mobileID = request.getParameter("txtMobileID").trim();
                    String description = request.getParameter("txtMobileDescription").trim();

                    if (description.isEmpty()) {
                        err.setDescriptionIsEmpty("Description must not be empty");
                        errorFound = true;
                    }

                    Integer quantity = null;
                    try {
                        String tmp = request.getParameter("txtMobileQuantity").trim();
                        if (!tmp.isEmpty()) {
                            quantity = Integer.parseInt(tmp);
                            if (quantity < 0) throw new NumberFormatException();
                        }
                    } catch (NumberFormatException ex) {
                        err.setInvalidQuantity("Quantity must be a nonnegative integer");
                        errorFound = true;
                    }

                    Float price = null;
                    try {
                        String tmp = request.getParameter("txtMobilePrice").trim();
                        if (!tmp.isEmpty()) {
                            price = Float.parseFloat(tmp);
                            if (price <= 0) throw new NumberFormatException();
                        }
                    } catch (NumberFormatException ex) {
                        err.setInvalidPrice("Price must be a possitive number");
                        errorFound = true;
                    }

                    boolean notSale;
                    notSale = request.getParameter("chkNotSale") != null;

                    if (!errorFound) {
                        MobileDAO dao = new MobileDAO();
                        dao.update(mobileID, description, quantity, price, notSale);
                    } else {
                        request.setAttribute("UPDATEERROR", err);
                    }
                }
            }
        } catch (NamingException ex) {
            log("UpdateMobileServlet _ Naming" + ex.getMessage());
        } catch (SQLException ex) {
            log("UpdateMobileServlet _ sql" + ex.getMessage());
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
