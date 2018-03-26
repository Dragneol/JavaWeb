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
import sample.utils.DBUtil;

/**
 *
 * @author Dragneol
 */
public class UserDAO implements Serializable {

    public boolean checkLogin(String username, String password) throws SQLException, ClassNotFoundException {
        //1.Open Connection
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.makeConnection();
            if (con != null) {
                //2. Create Query Statement
                String sql = "Select * from [User] Where Username = ? And Password = ?";
                //3. Create statement
                stm = con.prepareStatement(sql);
                //4.set Variable
                stm.setString(1, username);
                stm.setString(2, password);
                //5.execute query
                rs = stm.executeQuery();

                if (rs.next()) {
                    return true;
                }
            } //end if con != null

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
}
