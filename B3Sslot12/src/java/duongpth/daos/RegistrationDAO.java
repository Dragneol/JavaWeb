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

    public String signIn(String username, String password) throws SQLException, Exception {
        String role = "failed";
        try {
            connection = DBUtils.getConnection();
            if (connection != null) {
                String sql = "select Role from Registration where Username = ? and Password = ?";
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

    public boolean inserṭ̣(RegistrationDTO dto) throws SQLException, Exception {
        boolean inserted = false;
        try {
            connection = DBUtils.getConnection();
            if (connection != null) {
                String sql = "insert into Registration(Username, Password, Fullname, Role) values (?,?,?,?)";
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
