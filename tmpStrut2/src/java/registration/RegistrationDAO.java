/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;

import utils.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author dragneol
 */
public class RegistrationDAO implements Serializable {

    private Connection con = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;
    private List<RegistrationDTO> list;

    public List<RegistrationDTO> getList() {
        return list;
    }

    private void closeConnection() throws SQLException {
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

    public boolean checkLogin(String user, String pass) throws SQLException, NamingException {
        boolean success = false;
        try {
            con = DBUtils.getConnection();

            if (con != null) {
                String sql = "select * from Registration where Username = ? and Password = ?";

                stm = con.prepareStatement(sql);
                stm.setString(1, user);
                stm.setString(2, pass);

//                System.out.println("\n\n\n" + sql + "\n\n\n");
                rs = stm.executeQuery();

                if (rs.next()) {
                    success = true;
                }
            } else {
//                System.out.println("Stupid Duong"); 
            }

        } finally {
            closeConnection();
        }
        return success;
    }

    public void searchLikeLastName(String name) throws NamingException, SQLException {
        try {
            String username;
            String lastname;
            String password;
            boolean isAdmin;
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "select * from Registration where Lastname like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + name + "%");

                rs = stm.executeQuery();

                while (rs.next()) {
                    username = rs.getString("Username");
                    lastname = rs.getString("Lastname");
                    password = rs.getString("Password");
                    isAdmin = rs.getBoolean("isAdmin");

                    RegistrationDTO dto = new RegistrationDTO(username, lastname, password, isAdmin);
                    if (list == null) {
                        list = new ArrayList<RegistrationDTO>();
                    }
                    list.add(dto);
                }

            }
        } finally {
            closeConnection();
        }
    }

    public boolean deletePk(String username) throws NamingException, SQLException {
        boolean deleted = false;
        try {

            con = DBUtils.getConnection();

            if (con != null) {

                String sql = "delete from Registration where Username = ?";

                stm = con.prepareStatement(sql);

                stm.setString(1, username);

                int row = stm.executeUpdate();

                if (row > 0) {
                    deleted = true;
                }

            }
        } finally {
            closeConnection();
        }
        return deleted;
    }

    public boolean updatePassRole(String username, String password, boolean admin) throws NamingException, SQLException {
        boolean updated = false;
        try {

            con = DBUtils.getConnection();

            if (con != null) {

                String sql = "update Registration set Password = ?, isAdmin = ? where Username = ?";

                stm = con.prepareStatement(sql);

                stm.setString(1, password);
                stm.setBoolean(2, admin);
                stm.setString(3, username);

                int row = stm.executeUpdate();

                if (row > 0) {
                    updated = true;
                }

            }
        } finally {
            closeConnection();
        }
        return updated;
    }

    public boolean signUp(String user, String pass, String lastname, boolean admin) throws SQLException, NamingException {
        boolean signed = false;
        try {
            con = DBUtils.getConnection();

            if (con != null) {
                String sql = "insert into Registration (Username, Password, Lastname, isAdmin) "
                        + "Values (?,?,?,?)";

                stm = con.prepareStatement(sql);
                stm.setString(1, user);
                stm.setString(2, pass);
                stm.setString(3, lastname);
                stm.setBoolean(4, admin);

                int row = stm.executeUpdate();

                if (row > 0) {
                    signed = true;
                }
            }
        } finally {
            closeConnection();
        }
        return signed;
    }
}
