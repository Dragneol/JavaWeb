/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day07.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dragneol
 */
public class ControllerServlet extends HttpServlet {

    public static final String loginPage = "login.html";
//    public static final String searchNamePage = "searchName.html";
    public static final String searchNamePage = "search.jsp";
//    public static final String searchResultPage = "searchResultServlet";
    public static final String searchResultPage = "search.jsp";
    public static final String loginServlet = "LoginServlet";
    public static final String searchServlet = "SearchNameServlet";
    public static final String deleteServlet = "DeleteServlet";
    public static final String updateServlet = "UpdatePassRoleServlet";
    public static final String nullServlet = "ProcessCookiesServlet";
//    public static final String viewCartSevlet = "ViewCartSevlet";
    public static final String viewCartPage = "viewCart.jsp";
    public static final String addToCartSevlet = "AddToCartSevlet";
    public static final String RemoveSelectedServlet = "RemoveSelectedServlet";
    public static final String SignInServlet = "SignInServlet";

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

        String path = loginPage;
        String button = request.getParameter("btnAction");

        try {
            if (button == null) {
                path = nullServlet;
            } else if (button.equals("LogIn")) {
                path = loginServlet;
            } else if (button.equals("Search")) {
                path = searchServlet;
            } else if (button.equals("Delete")) {
                path = deleteServlet;
            } else if (button.equals("Update")) {
                path = updateServlet;
            } else if (button.equals("AddToCart")) {
                path = addToCartSevlet;
            } else if (button.equals("ViewCart")) {
                path = viewCartPage;
            } else if (button.equals("RemoveSelected")) {
                path = RemoveSelectedServlet;
            } else if (button.equals("CreateAccount")) {
                path = SignInServlet;
            }
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
