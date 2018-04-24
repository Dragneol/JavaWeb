/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongpth.daos;

import duongpth.dtos.RegistrationDTO;
import duongpth.utils.DBUtils;
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

    public String checkLogin(String username, String password) throws ClassNotFoundException, SQLException {
        String role = "failed";
        try {
            connection = DBUtils.getConnection();
            if (connection != null) {
                String sql = "select Role from Registration where Username = ? And Password = ?";
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

    public List<RegistrationDTO> findByLikeFullName(String name) throws ClassNotFoundException, SQLException {
        List<RegistrationDTO> result = new ArrayList<>();
        String username, fullname, role;
        try {
            connection = DBUtils.getConnection();
            if (connection != null) {
                String sql = "Select Username, Fullname, Role from Registration Where Fullname Like ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + name + "%");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    username = resultSet.getString("Username");
                    fullname = resultSet.getString("Fullname");
                    role = resultSet.getString("Role");
                    result.add(new RegistrationDTO(username, fullname, role));
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public RegistrationDTO findByPrimaryKey(String pk) throws SQLException, ClassNotFoundException {
        RegistrationDTO dto = null;
        String fullname, role;
        try {
            connection = DBUtils.getConnection();
            if (connection != null) {
                String sql = "Select Fullname, Role from Registration where Username = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, pk);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    fullname = resultSet.getString("Fullname");
                    role = resultSet.getString("Role");
                    dto = new RegistrationDTO(pk, fullname, role);
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean removeByPrimaryKey(String pk) throws SQLException, ClassNotFoundException {
        boolean deleted = false;
        try {
            connection = DBUtils.getConnection();
            if (connection != null) {
                String sql = "Delete from Registration where Username = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, pk);
                deleted = preparedStatement.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return deleted;
    }

    public boolean updateRecord(RegistrationDTO dto) throws SQLException, ClassNotFoundException {
        boolean updated = false;
        try {
            connection = DBUtils.getConnection();
            if (connection != null) {
                String sql = "Update Registration Set Password = ?, Fullname = ?, Role = ? where Username = ?";
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

    public boolean insertRecord(RegistrationDTO dto) throws SQLException, ClassNotFoundException {
        boolean inserted = false;
        try {
            connection = DBUtils.getConnection();
            if (connection != null) {
                String sql = "Insert into Registration (Username, Password, Fullname, Role) values (?,?,?,?)";
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
}
