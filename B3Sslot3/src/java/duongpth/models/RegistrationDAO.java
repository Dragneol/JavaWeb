/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongpth.models;

import duongpth.dtos.RegistrationDTO;
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

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public RegistrationDAO() {
    }

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

    public String checkLogin(String username, String password) throws SQLException {
        String role = "failed";
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "Select Role from Registration where Username = ? AND Password = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    role = resultSet.getString("Role");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return role;
    }

    public List<RegistrationDTO> searchByLikeFullName(String name) throws SQLException {
        List<RegistrationDTO> result = null;
        RegistrationDTO dto = null;
        String username, fullname, role;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "Select Username, Fullname, Role from Registration where Fullname like ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + name + "%");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    if (result == null) {
                        result = new ArrayList<>();
                    }
                    username = resultSet.getString("Username");
                    fullname = resultSet.getString("Fullrname");
                    role = resultSet.getString("Role");
                    dto = new RegistrationDTO(username, fullname, role);
                    result.add(dto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }
}
