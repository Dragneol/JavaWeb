/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import database.DBUtil;
import dtos.UserDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dragneol
 */
public class UserDAO implements Serializable {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public UserDAO() {
    }

    public void closeConnection() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String checkLogin(String username, String password) {
        String role = "failed";
        try {
            String sql = "SELECT Role from tblUser WHERE Username = ? AND Password = ?";
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                role = resultSet.getString("Role");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return role;
    }

    public List<UserDTO> findByLikeFullName(String search) {
        List<UserDTO> result = null;
        try {
            String sql = "select Username, Fullname, Role from tblUser where Fullname LIKE ?";
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + search + "%");
            resultSet = preparedStatement.executeQuery();
            String username = "";
            String fullname = "";
            String role = "";
            result = new ArrayList<>();
            while (resultSet.next()) {
                username = resultSet.getString("Username");
                fullname = resultSet.getString("Fullname");
                role = resultSet.getString("Role");
                UserDTO dto = new UserDTO(username, fullname, role);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean delete(String id) {
        boolean isDel = false;
        try {
            String sql = "Delete from tblUser where Username = ?";
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            isDel = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return isDel;
    }

    public boolean insert(UserDTO dto) {
        boolean isInserted = false;
        try {
            String sql = "Insert into tblUser (Username, Password, Fullname, Role) values (?,?,?,?)";
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dto.getUsername());
            preparedStatement.setString(2, dto.getPassword());
            preparedStatement.setString(3, dto.getFullname());
            preparedStatement.setString(4, dto.getRole());

            isInserted = preparedStatement.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return isInserted;
    }

    public UserDTO findByPrimaryKey(String pk) {
        UserDTO dto = null;
        try {
            String sql = "Select Fullname, Role from tblUser where Username = ?";
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pk);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String fullname = resultSet.getString("Fullname");
                String role = resultSet.getString("Role");
                dto = new UserDTO(pk, fullname, role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean update(UserDTO dto) {
        boolean check = false;
        try {
            String sql = "update tblUser set Password = ?, Fullname = ?, Role = ? where Username = ?";
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dto.getPassword());
            preparedStatement.setString(2, dto.getFullname());
            preparedStatement.setString(3, dto.getRole());
            preparedStatement.setString(4, dto.getUsername());
            check = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
}
