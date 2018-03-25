/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.users;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import sample.utils.DBUtils;

/**
 *
 * @author Nguyen Duy Dat
 */
public class UsersDAO implements Serializable {

    public boolean checkLogin(String username, String password)
            throws SQLException, NamingException {
        //1. Mo connection

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                //2. Tao cau lenh truy van
                String sql = "Select * From Registration Where Username=? AND Password=?";

                //3. Tao statement
                stm = con.prepareStatement(sql);

                //4. Truyen tham so
                stm.setString(1, username);
                stm.setString(2, password);

                //5. Thuc thi cau lenh truy van
                rs = stm.executeQuery();

                if (rs.next()) {
                    return true;
                }
            }//end if con==null
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

    private List<UsersDTO> listAccounts;

    public List<UsersDTO> getListAccounts() {
        return listAccounts;
    }

    public void searchLastName(String searchValue) throws SQLException, NamingException {
        //1. Mo connection
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                //2. Tao cau lenh truy van
                String sql = "Select * From Registration Where Lastname LIKE ?";

                //3. Tao statement
                stm = con.prepareStatement(sql);

                //4. Truyen tham so
                stm.setString(1, "%" + searchValue + "%");

                //5. Thuc thi cau lenh truy van
                rs = stm.executeQuery();

                while (rs.next()) {
                    String username = rs.getString("Username");
                    String password = rs.getString("Password");
                    String lastname = rs.getString("Lastname");
                    boolean role = rs.getBoolean("isAdmin");
                    UsersDTO dto = new UsersDTO(username, password, lastname, role);
                    if (this.listAccounts == null) {
                        this.listAccounts = new ArrayList<>();
                    }
                    this.listAccounts.add(dto);
                }//end while
            }//end if con==null
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
    }

    public boolean deletePk(String username) throws NamingException, SQLException {
        //1. Mo connection

        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                //2. Tao cau lenh truy van
                String sql = "Delete from Registration where Username=?";

                //3. Tao statement
                stm = con.prepareStatement(sql);

                //4. Truyen tham so
                stm.setString(1, username);

                //5. Thuc thi cau lenh truy van
                int row = stm.executeUpdate();

                if (row > 0) {
                    return true;
                }
            }//end if con==null
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean update(String username, String password, boolean role) throws NamingException, SQLException {
        //1. Mo connection

        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                //2. Tao cau lenh truy van
                String sql = "Update Registration Set Password= ?, isAdmin= ? where Username=?";

                //3. Tao statement
                stm = con.prepareStatement(sql);

                //4. Truyen tham so
                stm.setString(1, password);
                stm.setBoolean(2, role);
                stm.setString(3, username);

                //5. Thuc thi cau lenh truy van
                int row = stm.executeUpdate();

                if (row > 0) {
                    return true;
                }
            }//end if con==null
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean createNewAccount(String username, String password, String lastname, boolean role) throws NamingException, SQLException {
        //1. Mo connection

        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                //2. Tao cau lenh truy van
                String sql = "Insert Into Registration(Username,Password,Lastname,isAdmin) "
                        + "Values(?,?,?,?)";

                //3. Tao statement
                stm = con.prepareStatement(sql);

                //4. Truyen tham so
                stm.setString(1, username);
                stm.setString(2, password);
                stm.setString(3, lastname);
                stm.setBoolean(4, role);

                //5. Thuc thi cau lenh truy van
                int row = stm.executeUpdate();

                if (row > 0) {
                    return true;
                }
            }//end if con==null
        } finally {
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
