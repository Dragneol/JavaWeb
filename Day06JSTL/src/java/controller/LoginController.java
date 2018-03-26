/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dtos.ErrorDTO;
import dtos.loginBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dragneol
 */
public class LoginController extends HttpServlet {

    private static final String error = "error.jsp";
    private static final String admin = "admin.jsp";
    private static final String user = "user.jsp";
    private static final String invalid = "index.jsp";

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
        String url = error;
        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");

            ErrorDTO errorObj = new ErrorDTO();
            boolean valid = true;
            if (username.length() == 0) {
                errorObj.setUsernameError("Username cann't be blank");
                valid = false;
            }
            if (password.length() == 0) {
                errorObj.setPasswordError("Password cann't be blank");
                valid = false;
            }
            if (valid) {
                //call Model
                loginBean model = new loginBean(username, password);
                String role = model.checkLogin();
                if (model.equals("failed")) {
                    request.setAttribute("ERROR", "Invalid Username or Password");
                } else {
                    HttpSession session = request.getSession();
                    if (role.equals("admin")) {
                        url = admin;
                    } else if (role.equals("username")) {
                        url = user;
                    } else {
                        request.setAttribute("ERROR", "Your role is not support");
                    }
                }
            } else {
                url = invalid;
                request.setAttribute("Invalid", errorObj);
            }
        } catch (Exception e) {
            log("ERROR at LoginController : " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
