/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.user;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import sample.utils.DBUtilities;

/**
 *
 * @author dragneol
 */
public class UserDAO implements Serializable{
    private Connection con;
    private PreparedStatement stm;
    private ResultSet rs;
    public UserDTO checkSignIn (String username, int password) throws NamingException, SQLException {
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                stm = con.prepareStatement("SELECT * FROM Users WHERE userID = ? AND password = ?");
                stm.setString(1, username);
                stm.setInt(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String userID = rs.getString("userID");
                    String fullName = rs.getString("fullName");
                    int role = rs.getInt("role");
                    return new UserDTO(userID, fullName, role);
                }
            }
        } finally {
            if (rs != null) rs.close();
            if (stm != null) stm.close();
            if (con != null) con.close();
        }
        return null;
    }
    
    public UserDTO register (String username, int password, String fullname)
            throws NamingException, SQLException {
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                stm = con.prepareStatement("INSERT INTO Users(userID, password, fullName, role) "
                        + "VALUES(?, ?, ?, ?)");
                stm.setString(1, username);
                stm.setInt(2, password);
                stm.setString(3, fullname);
                stm.setInt(4, 0);
                if (stm.executeUpdate() > 0) {
                    UserDTO dto = new UserDTO(username, fullname, 0);
                    return dto;
                }
            }
        } finally {
            if (stm != null) stm.close();
            if (con != null) con.close();
        }
        return null;
    }
}