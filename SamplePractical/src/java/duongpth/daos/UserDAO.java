/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongpth.daos;

import duongpth.dtos.UserDTO;
import duongpth.utils.DBUtil;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DuongPTHSE62871
 */
public class UserDAO implements Serializable {

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

    public UserDTO checkLogin(String username, String password) throws SQLException, ClassNotFoundException {
        UserDTO dto = null;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "Select Name, IsAvailable from TBL_Users where UserID = ? And Password = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String name = resultSet.getString("Name");
                    boolean available = resultSet.getBoolean("IsAvailable");
                    dto = new UserDTO(username, name, available);
                }
            }
        } finally {
        }
        return dto;
    }
}
