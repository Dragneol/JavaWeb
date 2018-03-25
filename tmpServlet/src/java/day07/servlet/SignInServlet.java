/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day07.servlet;

import day07.registration.RegistrationDAO;
import day07.registration.RegistrationInsertError;
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
public class SignInServlet extends HttpServlet {

    private final String errorPage = "createNewAccount.jsp";
    private final String successPage = "login.html";

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

        String user = request.getParameter("txtUsername");
        String pass = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirm");
        String lastname = request.getParameter("txtLastname");

        boolean error = false;
        RegistrationInsertError errors = new RegistrationInsertError();

        String path = errorPage;
        try {
            //1. Kiem tra cac loi
            if (user.trim().length() < 6 || user.trim().length() > 30) {
                error = true;
                errors.setUsernameLengthErr("Username length requires 6 ~ 30 characters");
            }

            if (pass.trim().length() < 6 || pass.trim().length() > 20) {
                error = true;
                errors.setUsernameLengthErr("Username length requires 6 ~ 20 characters");
            } else if (!pass.trim().equals(confirm.trim())) {
                error = true;
                errors.setConfirmNotMatchErr("Confirm must be matched Password");
            }

            if (lastname.trim().length() < 6 || lastname.trim().length() > 50) {
                error = true;
                errors.setUsernameLengthErr("Username length requires 6 ~ 50 characters");
            }

            if (error) {
                request.setAttribute("INSERTERROR", error);
            } else {
                RegistrationDAO dao = new RegistrationDAO();
                boolean signed = dao.signUp(user, pass, lastname, false);
                
                if (signed) {
                    path = successPage;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
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
