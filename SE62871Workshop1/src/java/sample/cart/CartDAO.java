/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.cart;

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
public class CartDAO implements Serializable{
    private Connection con;
    private PreparedStatement stm;
    private ResultSet rs;
    
    public List<CartDTO> getCart(String userID)
            throws NamingException, SQLException {
        List<CartDTO> lists = null;
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                stm = con.prepareStatement("SELECT Mobile.*, CartDetails.quantity AS cartquantity"
                        + " FROM Mobile, CartDetails"
                        + " WHERE userID = ? AND Mobile.mobileID = CartDetails.mobileID");
                stm.setString(1, userID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String mobileID = rs.getString("mobileID");
                    String mobileName = rs.getString("mobileName");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("cartquantity");
                    int stockQuantity = rs.getInt("quantity");
                    boolean available = !rs.getBoolean("notSale") && rs.getBoolean("isActive");
                    
                    String status = !available ? "Not available"
                            : quantity > stockQuantity ? "Out of stock (" + stockQuantity + " lefts)"
                            : "Available";
                    
                    CartDTO dto = new CartDTO(mobileID, mobileName, price, quantity, status);
                    if (lists == null) lists = new ArrayList();
                    lists.add(dto);
                }
            }
        } finally {
            if (rs != null) rs.close();
            if (stm != null) stm.close();
            if (con != null) con.close();
        }
        return lists;
    }
    
    public boolean addToCart(String userID, String mobileID, int quantity)
            throws NamingException, SQLException {
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                stm = con.prepareStatement("SELECT * FROM CartDetails WHERE userID = ? AND mobileID = ?");
                stm.setString(1, userID);
                stm.setString(2, mobileID);
                rs = stm.executeQuery();
                int oldQuantity = rs.next() ? rs.getInt("quantity") : 0;
                if (oldQuantity == 0) {
                    stm = con.prepareStatement("INSERT INTO CartDetails(userID, mobileID, quantity)"
                            + " VALUES (?,?,?)");
                    stm.setString(1, userID);
                    stm.setString(2, mobileID);
                    stm.setInt(3, quantity);
                    if (stm.executeUpdate() > 0) return true;
                
                } else {
                    stm = con.prepareStatement("UPDATE CartDetails SET quantity = ? "
                            + "WHERE userID = ? AND mobileID = ?");
                    stm.setInt(1, quantity + oldQuantity);
                    stm.setString(2, userID);
                    stm.setString(3, mobileID);
                    if (stm.executeUpdate() > 0) return true;
                }
            }
        } finally {
            if (rs != null) rs.close();
            if (stm != null) stm.close();
            if (con != null) con.close();
        }
        return false;
    }
    
    public boolean editCart(String userID, String mobileID, int quantity)
            throws NamingException, SQLException {
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                stm = con.prepareStatement("UPDATE CartDetails SET quantity = ? "
                            + "WHERE userID = ? AND mobileID = ?");
                stm.setInt(1, quantity);
                stm.setString(2, userID);
                stm.setString(3, mobileID);
                if (stm.executeUpdate() > 0) return true;
            }
        } finally {
            if (rs != null) rs.close();
            if (stm != null) stm.close();
            if (con != null) con.close();
        }
        return false;
    }
    
    public boolean removeItemInCart(String userID, String mobileID)
            throws NamingException, SQLException {
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                stm = con.prepareStatement("DELETE FROM CartDetails "
                            + "WHERE userID = ? AND mobileID = ?");
                stm.setString(1, userID);
                stm.setString(2, mobileID);
                if (stm.executeUpdate() > 0) return true;
            }
        } finally {
            if (rs != null) rs.close();
            if (stm != null) stm.close();
            if (con != null) con.close();
        }
        return false;
    }
}
