/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongpth.controllers;

import duongpth.beans.ProcessBean;
import duongpth.dtos.RegistrationDTO;
import duongpth.dtos.RegistrationErrorObj;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DuongPTHSE62871
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {

    private final String ERROR = "error.jsp";
    private final String SUCCESS = "index.jsp";
    private final String FAIL = "insert.jsp";

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
        String path = FAIL;
        try {
            boolean valid = true;
            RegistrationErrorObj error = new RegistrationErrorObj();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String fullname = request.getParameter("fullname");
            String confirm = request.getParameter("confirm");
            String role = request.getParameter("role");

            if (username.isEmpty()) {
                error.setUsernameError("Username required");
                valid = false;
            }
            if (password.isEmpty()) {
                error.setPasswordError("Password required");
                valid = false;
            }
            if (confirm.isEmpty()) {
                error.setConfirmError("Confirm Pass required");
                valid = false;
            }
            if (!confirm.equals(password)) {
                error.setConfirmError("Confirm Pass required");
                valid = false;
            }

            if (fullname.isEmpty()) {
                error.setFullnameError("Fullname required");
                valid = false;
            }
            if (role.isEmpty()) {
                error.setRoleError("Role required");
                valid = false;
            }
            if (valid) {
                ProcessBean bean = new ProcessBean();
                RegistrationDTO dto = new RegistrationDTO(username, fullname, role);
                dto.setPassword(password);
                bean.setDto(dto);
                boolean inserted = bean.registration();
                if (inserted) {
                    path = SUCCESS;
                }
            } else {
                path = FAIL;
                request.setAttribute("INVALID", error);
            }
        } catch (Exception e) {
            if (e.getMessage().contains("duplicate")) {
                RegistrationErrorObj error = new RegistrationErrorObj();
                error.setUsernameError("Existed Username");
                request.setAttribute("INVALID", error);
            }
            log("Insert Controller : " + e.getMessage());
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
