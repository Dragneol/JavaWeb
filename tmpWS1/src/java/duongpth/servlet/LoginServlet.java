/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongpth.servlet;

import duongpth.tbl_User.UserDAO;
import duongpth.tbl_User.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dragneol
 */
public class LoginServlet extends HttpServlet {

    private final String invalidPage = "errorPage.jsp";
    private final String staffPage = "staffPage.jsp";
    private final String userPage = "userPage.jsp";
    private final String managerPage = "managerPage.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private int getPassword(String pass) throws NumberFormatException {
        return Integer.parseInt(pass);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String path = invalidPage;
        HttpSession session = session = request.getSession();;
        try {
            String userId = request.getParameter("userId");
            String password = request.getParameter("password");
            int pass = getPassword(password);
            UserDAO dao = new UserDAO();
            UserDTO dto = dao.checkLogin(userId, pass);
            if (dto != null) { // login success

                session.setAttribute("ACCOUNT", dto);

                if (dto.getRole() == 0) { //role user
                    path = userPage;
                } else if (dto.getRole() == 1) {//role manager
                    path = managerPage;
                } else { //role staff
                    path = staffPage;
                }
            } else { //login failed
                session.setAttribute("ERRORS", "Invalid Username or Password");
            }
        } catch (NumberFormatException e) {
            session.setAttribute("ERRORS", "Password are number only");
        } catch (NamingException e) {
            log("LoginServlet _ Naming" + e.getMessage());
        } catch (SQLException e) {
            log("LoginServlet _ SQL" + e.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(path);
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
