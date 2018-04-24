/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongpth.controllers;

import duongpth.beans.ProcessBean;
import duongpth.dtos.RegistrationDTO;
import duongpth.dtos.RegistrationErr;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DuongPTHSE62871
 */
@WebServlet(name = "InsertController", urlPatterns = {"/InsertController"})
public class InsertController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String INVALID = "register.jsp";
    private static final String SUCCESS = "index.jsp";

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
        String path = ERROR;
        RegistrationErr err = new RegistrationErr();
        boolean valid = true;
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");
            String fullname = request.getParameter("fullname");
            String role = request.getParameter("role");

            if (username.isEmpty()) {
                err.setUsername("Username is required");
                valid = false;
            }
            if (password.isEmpty()) {
                err.setPassword("Password is required");
                valid = false;
            }
            if (confirm.isEmpty()) {
                err.setConfirm("Confirm password is required");
                valid = false;
            } else if (!confirm.equals(password)) {
                err.setConfirm("Confirm not same as Password");
                valid = false;
            }
            if (fullname.isEmpty()) {
                err.setFullname("Fullname is required");
                valid = false;
            }
            if (role.isEmpty()) {
                err.setRole("Role is reuiqred");
                valid = false;
            }
            if (valid) {
                RegistrationDTO dto = new RegistrationDTO(username, fullname, role);
                dto.setPassword(password);
                ProcessBean bean = new ProcessBean(dto);
                boolean inserted = bean.insertRecord();
                if (inserted) {
                    path = SUCCESS;
                }
            } else {
                path = INVALID;
                request.setAttribute("INVALID", err);
            }
        } catch (Exception e) {
            if (e.getMessage().contains("duplicate")) {
                err.setUsername("User already existed");
                request.setAttribute("INVALID", err);
                path = INVALID;
            } else {
                log("Insert Controller :" + e.getMessage());
            }
        } finally {
            request.getRequestDispatcher(path).forward(request, response);
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
