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
public class InsertMobileServlet extends HttpServlet {
    private final String staffPage = "StaffPage.jsp";
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
        boolean errorFound = false;
        MobileErr err = new MobileErr();
        
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                UserDTO user = (UserDTO) session.getAttribute("USER");
                
                if (user != null && user.getRole() == 1) {
                    String mobileID = request.getParameter("txtMobileID").trim();
                    if (mobileID.isEmpty()) {
                        err.setMobileIDIsEmpty("Mobile ID must not be empty");
                        errorFound = true;
                    }

                    String mobileName = request.getParameter("txtMobileName").trim();
                    if (mobileName.isEmpty()) {
                        err.setNameIsEmpty("Name must not be empty");
                        errorFound = true;
                    }

                    String description = request.getParameter("txtDescription").trim();
                    if (description.isEmpty()) {
                        err.setDescriptionIsEmpty("Description must not be empty");
                        errorFound = true;
                    }

                    Float price = null;
                    try {
                        String tmp = request.getParameter("txtPrice").trim();
                        if (!tmp.isEmpty()) {
                            price = Float.parseFloat(tmp);
                            if (price <= 0) throw new NumberFormatException();
                        }
                    } catch (NumberFormatException ex) {
                        err.setInvalidPrice("Price must be a possitive number");
                        errorFound = true;
                    }

                    Integer quantity = null;
                    try {
                        String tmp = request.getParameter("txtQuantity").trim();
                        if (!tmp.isEmpty()) {
                            quantity = Integer.parseInt(tmp);
                            if (quantity < 0) throw new NumberFormatException();
                        }
                    } catch (NumberFormatException ex) {
                        err.setInvalidQuantity("Quantity must be a nonnegative integer");
                        errorFound = true;
                    }

                    Integer yearOfProduction = null;
                    try {
                        String tmp = request.getParameter("txtYearOfProduction").trim();
                        if (!tmp.isEmpty()) {
                            yearOfProduction = Integer.parseInt(tmp);
                            if (yearOfProduction < 0) throw new NumberFormatException();
                        }
                    } catch (NumberFormatException ex) {
                        err.setInvalidYearOfProduction("Year of production must be a nonnegative integer");
                        errorFound = true;
                    }

                    boolean notSale;
                    notSale = request.getParameter("chkNotSale") != null;

                    if (errorFound) {
                        request.setAttribute("INSERTERROR", err);
                    } else {
                        MobileDAO dao = new MobileDAO();
                        dao.insert(mobileID, mobileName, description, price, yearOfProduction, quantity, notSale);
                    }
                }
            }
        } catch (NamingException ex) {
            log("InsertMobileServlet _ Naming" + ex.getMessage());
        } catch (SQLException ex) {
            err.setMobileIDIsExisted("Cannot use this ID");
            request.setAttribute("INSERTERROR", err);
            log("InsertMobileServlet _ SQL" + ex.getMessage());
        } finally {
            request.getRequestDispatcher(staffPage).forward(request, response);
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
