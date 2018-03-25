/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import customer.customerDAO;
import customer.customerDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tbl_orderDetail.tbl_orderDetailDAO;
import tbl_orderDetail.tbl_orderDetailDTO;

/**
 *
 * @author dragneol
 */
public class OrderDetailServlet extends HttpServlet {

    private final String success = "orderDetail.jsp";
    private final String fail = "errorPage.jsp";

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
        String path = fail;
        try {
            String orderID = request.getParameter("orderID");
            String custID = request.getParameter("custID");
            tbl_orderDetailDAO dao = new tbl_orderDetailDAO();
            dao.getOrderDetail(orderID);
            if (dao.getListResult() != null) {
                request.setAttribute("DETAILLIST", dao.getListResult());
            }
            customerDAO custDAO = new customerDAO();
            customerDTO dto = custDAO.getCustInfo(custID);
            if (dto != null) {
                request.setAttribute("DETAILCUST", dto);
            }
            path = success;
        } catch (NamingException ex) {
            log("OrderDetailServlet _ Naming" + ex.getCause());
        } catch (SQLException ex) {
            log("OrderDetailServlet _ SQL" + ex.getCause());
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
