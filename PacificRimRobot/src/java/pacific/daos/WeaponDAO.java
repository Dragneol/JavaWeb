/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacific.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import pacific.dtos.WeaponDTO;
import pacific.utils.DBUtil;

/**
 *
 * @author DuongPTHSE62871
 */
public class WeaponDAO implements Serializable {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

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

    public String getRoboByEquiment(String id) throws SQLException, NamingException {
        String robot = "None";
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "select Robot from Equiment where WeaponId = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, id);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    robot = resultSet.getString("Robot");
                }
            }
        } finally {
            closeConnection();
        }
        return robot;
    }

    public WeaponDTO findByPrimaryKey(String id) throws NamingException, SQLException {
        WeaponDTO dto = null;
        String name;
        boolean available, carriable;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "Select WeaponName, Available, Carriable from Weapon where WeaponCode = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, id);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    name = resultSet.getString("WeaponName");
                    available = resultSet.getBoolean("Available");
                    carriable = resultSet.getBoolean("Carriable");
                    dto = new WeaponDTO(id, name, available, carriable);
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public List<WeaponDTO> findByLikeName(String name) throws SQLException, NamingException {
        List<WeaponDTO> list = null;
        WeaponDTO dto = null;
        String id, weapon;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "Select WeaponCode, WeaponName from Weapon where WeaponName like ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + name + "%");
                resultSet = preparedStatement.executeQuery();
                list = new ArrayList<>();
                while (resultSet.next()) {
                    id = resultSet.getString("WeaponCode");
                    weapon = resultSet.getString("WeaponName");
                    dto = new WeaponDTO(id, weapon);
                    list.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return list;
    }
}
