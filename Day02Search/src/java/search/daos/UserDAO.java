/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import search.db.DBUtil;
import search.dtos.UserDTO;

/**
 *
 * @author Dragneol
 */
public class UserDAO implements Serializable {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

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

    public List<UserDTO> findByFullname(String search) {
        List<UserDTO> result = null;
        try {
            String sql = "Select Username, Fullname, Role from tblUser Where Fullname LIKE ?";
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + search + "%");
            resultSet = preparedStatement.executeQuery();
            String username = "";
            String role = "";
            String fullname = "";
            result = new ArrayList<>();
            while (resultSet.next()) {
                username = resultSet.getString("Username");
                role = resultSet.getString("Role");
                fullname = resultSet.getString("Fullname");
//                UserDTO dto = new UserDTO(username, role);
                UserDTO dto = new UserDTO(username, role, fullname);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }
}
