/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tbl_order.tbl_orderDAO;
import utils.FormatUtil;

/**
 *
 * @author dragneol
 */
public class SearchOrderServlet extends HttpServlet {

    private final String done = "orderList.jsp";
    private final String failed = "errorPage.jsp";

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
        String path = done;
        try {

            Date dateFrom = Date.valueOf(request.getParameter("dateFrom"));
            Date dateTo = Date.valueOf(request.getParameter("dateTo"));
            String delivered = request.getParameter("isDeliver");
//            System.out.println(delivered);
            boolean isDeliver = false;
            if (delivered != null) {
                if (!delivered.equals("Undelivered")) {
                    isDeliver = true;
                }
            }

            tbl_orderDAO dao = new tbl_orderDAO();
            dao.searchOrder(dateFrom, dateTo, isDeliver);
            if (dao.getResult() != null) {
                request.setAttribute("ORDERLIST", dao.getResult());
            }

        } catch (NumberFormatException ex) {
            log("SearchOrderServlet _ NumberFormatException" + ex.getCause());
        } catch (PatternSyntaxException ex) {
            log("SearchOrderServlet _ PatternSyntaxException" + ex.getCause());
        } catch (SQLException ex) {
            log("SearchOrderServlet _ SQLException" + ex.getCause());
        } catch (NamingException ex) {
            log("SearchOrderServlet _ NamingException" + ex.getCause());
        } catch (Exception ex) {
            log("SearchOrderServlet _ General" + ex.getCause());
            path = failed;
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
