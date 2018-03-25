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
public class SignInServlet extends HttpServlet {

    private final String signInPage = "SignInPage.jsp";
    private final String userPage = "UserPage.jsp";
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
        String url = signInPage;
        UserErr err = new UserErr();
        try {
            String username = request.getParameter("txtUsername").trim();
            String password = request.getParameter("txtPassword").trim();
            UserDAO dao = new UserDAO();
            UserDTO dto = dao.checkSignIn(username, password);

            if (dto == null) {
                err.setLoginFailed("Invalid username or password!");
                request.setAttribute("SIGNINERROR", err);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("USER", dto);
                switch (dto.getRole()) {
                    case 0:
                        url = userPage;
                        break;
                    case 2:
                        url = staffPage;
                        break;
                    default:
                        err.setLoginFailed("This role is not supported!");
                        request.setAttribute("SIGNINERROR", err);
                }
            }

        } catch (NumberFormatException ex) {
            err.setPasswordMustBeNumber("Password must be numbers");
            request.setAttribute("SIGNINERROR", err);
        } catch (NamingException ex) {
            log("SignInServlet _ Naming " + ex.getMessage());
        } catch (SQLException ex) {
            log("SignInServlet _ sql " + ex.getMessage());
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