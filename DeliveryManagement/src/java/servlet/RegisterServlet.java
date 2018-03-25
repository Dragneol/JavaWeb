/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import customer.customerDAO;
import customer.customerDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dragneol
 */
public class RegisterServlet extends HttpServlet {

    private final String fail = "register.jsp";
    private final String success = "login.html";

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
        String location = fail;
        try {
            String custID = request.getParameter("custID");
            String password = request.getParameter("password");
            String passwordConfrimed = request.getParameter("passwordConfrimed");
            String custName = request.getParameter("custName");
            String lastName = request.getParameter("lastName");
            String middleName = request.getParameter("middleName");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            if (custID == null) {
                request.setAttribute("ERROR", "Username Required");
            } else {
                if (password == null) {
                    request.setAttribute("ERROR", "Password Required");
                } else {
                    if (passwordConfrimed == null) {
                        request.setAttribute("ERROR", "Password Confirmed Required");
                    } else {
                        if (!password.equals(passwordConfrimed)) {
                            request.setAttribute("ERROR", "Conirm not correct");
                        } else {
                            if (custName == null) {
                                request.setAttribute("ERROR", "Customer Name Required");
                            } else {
                                customerDTO dto = new customerDTO(custID, password, custName, lastName, middleName, address, phone, 0);
                                customerDAO dao = new customerDAO();
                                boolean signed = dao.signup(dto);
                                if (signed) {
                                    location = success;
//                                    response.sendRedirect(success);
                                } else {
                                    request.setAttribute("ERROR", "Username already existed");
                                }
                            }
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            log("RegisterServlet _ SQL" + ex.getCause());
        } catch (NamingException ex) {
            log("RegisterServlet _ Naming" + ex.getCause());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(location);
            rd.forward(request, response);
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
