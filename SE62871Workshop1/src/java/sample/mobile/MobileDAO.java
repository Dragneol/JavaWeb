/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.mobile;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import sample.utils.DBUtilities;

/**
 *
 * @author dragneol
 */
public class MobileDAO implements Serializable{
    private Connection con;
    private PreparedStatement stm;
    private ResultSet rs;
    
    public List<MobileDTO> searchByIdOrName(String searchValue) throws NamingException, SQLException {
        List<MobileDTO> mobiles = null;
        
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                stm = con.prepareStatement("SELECT * FROM Mobile WHERE mobileID LIKE ? OR mobileName LIKE ?");
                stm.setString(1, "%" + searchValue + "%");
                stm.setString(2, "%" + searchValue + "%");
                rs = stm.executeQuery();
                
                while (rs.next() && rs.getBoolean("isActive")) {
                    String mobileID = rs.getString("mobileID");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity");
                    boolean notSale = rs.getBoolean("notSale");

                    if (mobiles == null) mobiles = new ArrayList();
                    mobiles.add(new MobileDTO(mobileID, description, price, mobileName, yearOfProduction, quantity, notSale));
                }
            }
        } finally {
            if (rs != null) rs.close();
            if (stm != null) stm.close();
            if (con != null) con.close();
        }
        return mobiles;
    }
    
    public List<MobileDTO> searchByPriceInRange(Float minPrice, Float maxPrice)
            throws NamingException, SQLException {
        List<MobileDTO> mobiles = null;
        
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                if (minPrice == null && maxPrice != null) {
                    stm = con.prepareStatement("SELECT * FROM Mobile WHERE price <= ?");
                    stm.setFloat(1, maxPrice);
                } else if (minPrice != null && maxPrice == null) {
                    stm = con.prepareStatement("SELECT * FROM Mobile WHERE price >= ?");
                    stm.setFloat(1, minPrice);
                } else if (minPrice != null && maxPrice != null) {
                    stm = con.prepareStatement("SELECT * FROM Mobile WHERE price >= ? AND price <= ?");
                    if (minPrice > maxPrice) {
                        Float tmp = minPrice;
                        minPrice = maxPrice;
                        maxPrice = tmp;
                    }
                    stm.setFloat(1, minPrice);
                    stm.setFloat(2, maxPrice);
                } else return mobiles;
                
                rs = stm.executeQuery();
                
                while (rs.next() && rs.getBoolean("isActive")) {
                    String mobileID = rs.getString("mobileID");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity");
                    boolean notSale = rs.getBoolean("notSale");

                    if (mobiles == null) mobiles = new ArrayList();
                    mobiles.add(new MobileDTO(mobileID, description, price, mobileName, yearOfProduction, quantity, notSale));
                }
            }
        } finally {
            if (rs != null) rs.close();
            if (stm != null) stm.close();
            if (con != null) con.close();
        }
        return mobiles;
    }
    
    public boolean update(String mobileID, String description, Integer quantity, Float price, boolean notSale)
            throws NamingException, SQLException {
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                stm = con.prepareStatement("UPDATE Mobile SET description = ?, quantity = ?, price = ?, notSale = ? "
                                            + "WHERE mobileID = ?");
                stm.setString(1, description);
                if (quantity == null) stm.setNull(2, java.sql.Types.INTEGER);
                else stm.setInt(2, quantity);
                if (price == null) stm.setNull(3, java.sql.Types.FLOAT);
                else stm.setFloat(3, price);
                stm.setBoolean(4, notSale);
                stm.setString(5, mobileID);
                if (stm.executeUpdate() > 0) return true;
            }
        } finally {
            if (stm != null) stm.close();
            if (con != null) con.close();
        }
        return false;
    }
    
    public boolean delete(String mobileID)
            throws NamingException, SQLException {
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                stm = con.prepareStatement("UPDATE Mobile SET isActive = ? "
                                            + "WHERE mobileID = ?");
                stm.setBoolean(1, false);
                stm.setString(2, mobileID);
                if (stm.executeUpdate() > 0) return true;
            }
        } finally {
            if (stm != null) stm.close();
            if (con != null) con.close();
        }
        return false;
    }
    
    public boolean insert(String mobileID, String mobileName, String description,
            Float price, Integer yearOfProduction, Integer quantity, boolean notSale)
            throws NamingException, SQLException {
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                stm = con.prepareStatement("INSERT INTO Mobile(mobileID, mobileName, "
                        + "description, price, yearOfProduction, quantity, notSale, isActive) "
                        + "VALUES (?,?,?,?,?,?,?,?)");
                stm.setString(1, mobileID);
                stm.setString(2, mobileName);
                stm.setString(3, description);
                if (price == null) stm.setNull(4, java.sql.Types.FLOAT);
                else stm.setFloat(4, price);
                if (yearOfProduction == null) stm.setNull(5, java.sql.Types.INTEGER);
                else stm.setInt(5, yearOfProduction);
                if (quantity == null) stm.setNull(6, java.sql.Types.INTEGER);
                else stm.setInt(6, quantity);
                stm.setBoolean(7, notSale);
                stm.setBoolean(8, true);
                if (stm.executeUpdate() > 0) return true;
            }
        } finally {
            if (stm != null) stm.close();
            if (con != null) con.close();
        }
        return false;
    }
}
