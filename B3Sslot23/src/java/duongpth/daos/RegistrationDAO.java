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

    public String checkLogin(String username, String password) throws SQLException, ClassNotFoundException {
        String role = "failed";
        try {
            connection = DBUtils.getConnection();
            if (connection != null) {
                String sql = "select Role from Registration where Username = ? and Password  =?";
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

    public List<RegistrationDTO> findByLikeFullName(String name) throws SQLException, ClassNotFoundException {
        List<RegistrationDTO> list = null;
        String fullname, username, role;
        try {
            connection = DBUtils.getConnection();
            if (connection != null) {
                String sql = "select Username, Fullname, Role from Registration where Fullname like ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + name + "%");
                resultSet = preparedStatement.executeQuery();
                list = new ArrayList<>();
                while (resultSet.next()) {
                    username = resultSet.getString("Username");
                    fullname = resultSet.getString("Fullname");
                    role = resultSet.getString("Role");
                    list.add(new RegistrationDTO(username, role, fullname));
                }
            }
        } finally {
            closeConnection();
        }
        return list;
    }
}
