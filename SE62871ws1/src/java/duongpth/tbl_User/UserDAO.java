/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongpth.tbl_User;

import duongpth.utils.DatabaseUtil;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author dragneol
 */
public class UserDAO implements Serializable {

    private List<UserDTO> listUser;
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

    public UserDTO checkLogin(String userId, int password) throws NamingException, SQLException {
        UserDTO dto = null;
        connection = DatabaseUtil.getConnection();
        try {
            if (connection != null) {
                String sql = "Select * From tbl_User where userId=? And password=?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, userId);
                preparedStatement.setInt(2, password);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String fullName = resultSet.getString("fullName");
                    int role = resultSet.getInt("role");
                    dto = new UserDTO(userId, password, fullName, role);
                }
            }
        } finally {
            closeConnection();
            return dto;
        }
    }
}
