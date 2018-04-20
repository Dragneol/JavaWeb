/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongpth.models;

import duongpth.objects.RegistrationDTO;
import duongpth.utils.DBUtil;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DuongPTHSE62871
 */
public class RegistrationDAO implements Serializable {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private void closeConnection() throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public String checkLogin(String username, String password) throws SQLException, ClassNotFoundException {
        String role = "failed";
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "Select Role From Registration Where Username = ? AND Password = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    role = resultSet.getString("Role");
                }
            }
        } finally {
            closeConnection();
        }
        return role;
    }

    public List<RegistrationDTO> searchLikeFullName(String search) throws ClassNotFoundException, SQLException {
        List<RegistrationDTO> result = null;
        String username, fullname, role;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "Select Username, FullName, Role from Registration where Fullname like ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + search + "%");
                resultSet = preparedStatement.executeQuery();
                result = new ArrayList<>();
                while (resultSet.next()) {
                    username = resultSet.getString("Username");
                    fullname = resultSet.getString("Fullname");
                    role = resultSet.getString("Role");
                    result.add(new RegistrationDTO(username, role, fullname));
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean delete(String username) throws ClassNotFoundException, SQLException {
        boolean deleted = false;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "Delete From Registration Where Username = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                deleted = preparedStatement.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return deleted;
    }

    public boolean insert(RegistrationDTO dto) throws SQLException, ClassNotFoundException {
        boolean inserted = false;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "INSERT INTO dbo.Registration (Username, Password, Fullname, \"Role\") \n VALUES (?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, dto.getUsername());
                preparedStatement.setString(2, dto.getPassword());
                preparedStatement.setString(3, dto.getFullname());
                preparedStatement.setString(4, dto.getRole());
                inserted = preparedStatement.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return inserted;
    }

    public RegistrationDTO findByPrimaryKey(String pk) throws SQLException, ClassNotFoundException {
        RegistrationDTO dto = null;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "Select Fullname, Role, Password From Registration where Username = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, pk);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String fullname = resultSet.getString("Fullname");
                    String role = resultSet.getString("Role");
                    String password = resultSet.getString("Password");
                    dto = new RegistrationDTO(pk, role, fullname);
                    dto.setPassword(password);
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean update(RegistrationDTO dto) throws SQLException, ClassNotFoundException {
        boolean updated = false;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "Update Registration set Password = ?, Fullname = ?, Role =? Where Username = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, dto.getPassword());
                preparedStatement.setString(2, dto.getFullname());
                preparedStatement.setString(3, dto.getRole());
                preparedStatement.setString(4, dto.getUsername());
                updated = preparedStatement.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return updated;
    }
}
