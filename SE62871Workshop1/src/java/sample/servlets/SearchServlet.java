/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.mobile.MobileDAO;
import sample.mobile.MobileDTO;
import sample.mobile.MobileErr;

/**
 *
 * @author dragneol
 */
public class SearchServlet extends HttpServlet {
    private final String staffPage = "StaffPage.jsp";
    private final String userPage = "UserPage.jsp";
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
        String url = userPage;
        
        try {
            String searchType = request.getParameter("txtSearchType").trim();
            
            if (searchType.equals("IDorName")) {
                String searchValue = request.getParameter("txtSearch").trim();
                
                if (!searchValue.isEmpty()) {
                    MobileDAO dao = new MobileDAO();
                    List<MobileDTO> mobiles = dao.searchByIdOrName(searchValue);
                    request.setAttribute("SEARCHRESULT", mobiles);
                }
                url = staffPage;
                
            } else if (searchType.equals("PriceInRange")) {
                MobileErr err = new MobileErr();
                boolean errorFound = false;
                
                Float minPrice = null;
                try {
                    String tmp = request.getParameter("txtSearchMinPrice").trim();
                    if (!tmp.isEmpty()) {
                        minPrice = Float.parseFloat(tmp);
                        if (minPrice < 0) throw new NumberFormatException();
                    }
                } catch (NumberFormatException ex) {
                    err.setInvalidMinPrice("Min price must be a nonnegative number");
                    errorFound = true;
                }
                
                Float maxPrice = null;
                try {
                    String tmp = request.getParameter("txtSearchMaxPrice").trim();
                    if (!tmp.isEmpty()) {
                        maxPrice = Float.parseFloat(tmp);
                        if (maxPrice < 0) throw new NumberFormatException();
                    }
                } catch (NumberFormatException ex) {
                    err.setInvalidMaxPrice("Max price must be a nonnegative number");
                    errorFound = true;
                }
                
                if (!errorFound) {
                    MobileDAO dao = new MobileDAO();
                    List<MobileDTO> mobiles = dao.searchByPriceInRange(minPrice, maxPrice);
                    request.setAttribute("SEARCHRESULT", mobiles);
                } else {
                    request.setAttribute("SEARCHERROR", err);
                }
                
            }
        } catch (NamingException ex) {
            log("SearchServlet _ Naming" + ex.getMessage());
        } catch (SQLException ex) {
            log("SearchServlet _ sql" + ex.getMessage());
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
