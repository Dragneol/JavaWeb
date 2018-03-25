/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngocnt.tbluser;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import ngocnt.utils.DBUtils;

/**
 *
 * @author ngocnt
 */
public class Tbl_userDAO implements Serializable{
    
    public boolean checkLogin(String username, String password) throws SQLException, NamingException{
        
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            
            con = DBUtils.makeConnection();
            String sql = "Select * From tbl_User Where userId=? AND password=? AND role=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setInt(3, 0);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
            
        }finally{
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
        
    }
    
    public String getFullName(String username) throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            
            con = DBUtils.makeConnection();
            String sql = "Select * From tbl_User Where userId=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("fullName");
            }
            
            
        }finally{
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }
}
