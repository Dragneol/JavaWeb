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
import sample.user.UserDAO;
import sample.user.UserDTO;
import sample.user.UserErr;

/**
 *
 * @author dragneol
 */
public class RegisterServlet extends HttpServlet {
    private final String registerPage = "Register.jsp";
    private final String userPage = "UserPage.jsp";
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
        String url = registerPage;
        boolean errorFound = false;
        UserErr err = new UserErr();
        
        try {
            
            String username = request.getParameter("txtUsername").trim();
            if (username.isEmpty()) {
                err.setUsernameIsEmpty("Username required!");
                errorFound = true;
            }
            
            String password = request.getParameter("txtPassword").trim();
            String confirmPassword = request.getParameter("txtConfirmPassword").trim();
            int passwordNumber = 0;
            if (password.isEmpty()) {
                err.setPasswordIsEmpty("Password required!");
                errorFound = true;
            } else {
                try {
                    passwordNumber = Integer.parseInt(password);
                    
                    if (!confirmPassword.equals(password)) {
                        err.setPasswordNotMatch("Confirm password not match!");
                        errorFound = true;
                    }
                    
                } catch (NumberFormatException ex) {
                    err.setPasswordMustBeNumber("Password must be a number!");
                    errorFound = true;
                }
            }
            
            String fullname = request.getParameter("txtFullname").trim();
            if (fullname.isEmpty()) {
                err.setFullnameIsEmpty("Fullname required!");
                errorFound = true;
            }
            
            if (errorFound) {
                request.setAttribute("REGISTERERROR", err);
            } else {
                UserDTO dto = new UserDAO().register(username, passwordNumber, fullname);
                HttpSession session = request.getSession();
                session.setAttribute("USER", dto);
                url = userPage;
            }
        } catch (NamingException ex) {
            log("RegisterServlet _ Naming" + ex.getMessage());
        } catch (SQLException ex) {
            log("RegisterServlet _ Naming" + ex.getMessage());
            err.setUsernameExisted("Username existed!");
            request.setAttribute("REGISTERERROR", err);
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
