/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dragneol
 */
public class MiddleServlet extends HttpServlet {
    private final String checkSignInServlet = "CheckSignInServlet";
    private final String signInServlet = "SignInServlet";
    private final String signInPage = "SignInPage.jsp";
    private final String logOutServlet = "LogOutServlet";
    private final String registerServlet = "RegisterServlet";
    private final String searchServlet = "SearchServlet";
    private final String updateMobileServlet = "UpdateMobileServlet";
    private final String deleteMobileServlet = "DeleteMobileServlet";
    private final String insertMobileServlet = "InsertMobileServlet";
    private final String addToCartServlet = "AddToCartServlet";
    private final String viewCartServlet = "ViewCartServlet";
    private final String deleteFromCartServlet = "DeleteFromCartServlet";
    private final String updateCartServlet = "UpdateCartServlet";
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
        String button = request.getParameter("btnAction");
        String url = signInPage;
        
        try {
            if (button == null) {
                url = checkSignInServlet;
            } else if (button.equals("Sign In")) {
                url = signInServlet;
            } else if (button.equals("Log out")) {
                url = logOutServlet;
            } else if (button.equals("Register")) {
                url = registerServlet;
            } else if (button.equals("Search")) {
                url = searchServlet;
            } else if (button.equals("Update")) {
                url = updateMobileServlet;
            } else if (button.equals("Delete")) {
                url = deleteMobileServlet;
            } else if (button.equals("Insert")) {
                url = insertMobileServlet;
            } else if (button.equals("Add to cart")) {
                url = addToCartServlet;
            } else if (button.equals("View cart")) {
                url = viewCartServlet;
            } else if (button.equals("DeleteFromCart")) {
                url = deleteFromCartServlet;
            } else if (button.equals("Update cart")) {
                url = updateCartServlet;
            }
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
