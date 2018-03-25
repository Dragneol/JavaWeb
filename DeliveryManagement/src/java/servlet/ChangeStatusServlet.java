/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tbl_order.tbl_orderDAO;

/**
 *
 * @author dragneol
 */
public class ChangeStatusServlet extends HttpServlet {

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
        String urlWriting = "SearchOrder" + "?"
                + "isDeliver=" + request.getParameter("isDeliver") + "&"
                + "dateFrom=" + request.getParameter("dateFrom") + "&"
                + "dateTo=" + request.getParameter("dateTo");
        
//        System.out.println("button : " + request.getParameter("btnAction"));
//        System.out.println("status : " + request.getParameter("isDeliver"));
        try {
            String ordersID[] = request.getParameterValues("orders");
            if (ordersID != null) {
                String delivered = request.getParameter("btnAction");
                boolean isDeliver = false;
                if (delivered != null) {
                    if (delivered.equals("Delivered")) {
                        isDeliver = true;
                    }
                }

                tbl_orderDAO dao = new tbl_orderDAO();
                for (String orderID : ordersID) {
                    dao.changeStatus(isDeliver, orderID);
                }
            }

        } catch (SQLException ex) {
            log("ChangeStatusServlet _ SQL " + ex.getCause());
        } catch (NamingException ex) {
            log("ChangeStatusServlet _ Naming " + ex.getCause());
        } finally {
            response.sendRedirect(urlWriting);
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
