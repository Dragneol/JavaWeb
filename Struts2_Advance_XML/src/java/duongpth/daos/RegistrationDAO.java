/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongpth.daos;

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

    public boolean insertRecord(String username, String password, String fullname) throws SQLException, ClassNotFoundException {
        boolean inserted = false;
        try {
            connection = DBUtils.getConnection();
            if (connection != null) {
                String sql = "insert into Registration("
                        + "Username, Password, Fullname, Role) values "
                        + "(?,?,?,?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, fullname);
                preparedStatement.setString(4, "user");
                inserted = preparedStatement.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return inserted;
    }
}
