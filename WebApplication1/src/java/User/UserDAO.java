/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBUtil;

/**
 *
 * @author Dragneol
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

    public boolean checkLogin(String username, String password) throws SQLException {
        boolean signed = false;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "select * from [User] where [Username]=? And [Password]=?";
                System.out.println(sql);
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    signed = true;
                }
                System.out.println(signed);
            } else {
                System.out.println("Null Connection");
            }
        } finally {
            closeConnection();
            return signed;
        }
    }
}
