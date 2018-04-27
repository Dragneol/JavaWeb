/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacific.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import pacific.dtos.RobotDTO;
import pacific.utils.DBUtil;

/**
 *
 * @author DuongPTHSE62871
 */
public class RobotDAO implements Serializable {

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

    public List<RobotDTO> findByLikeName(String name) throws SQLException, NamingException {
        List<RobotDTO> list = null;
        RobotDTO dto = null;
        String robot, imglink;
        boolean available;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "Select Robot, ImgLink, Available from Robot where Robot like ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + name + "%");
                resultSet = preparedStatement.executeQuery();
                list = new ArrayList<>();
                while (resultSet.next()) {
                    robot = resultSet.getString("Robot");
                    imglink = resultSet.getString("ImgLink");
                    available = resultSet.getBoolean("Available");
                    dto = new RobotDTO(robot, imglink, available);
                    list.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public RobotDTO findByPrimaryKey(String name) throws SQLException, NamingException {
        RobotDTO dto = null;
        String origin, imglink, classified;
        Date dateLauched;
        boolean available;
        int kajiuKilled;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "Select Robot, ImgLink, Available from Robot where Robot = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + name + "%");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    classified = resultSet.getString("Classified");
                    origin = resultSet.getString("Origin");
                    imglink = resultSet.getString("ImgLink");
                    available = resultSet.getBoolean("Available");
                    dateLauched = resultSet.getDate("DateLauched");
                    kajiuKilled = resultSet.getInt("KaijuKilled");
                    dto = new RobotDTO(name, origin, classified, imglink, available, dateLauched, kajiuKilled);
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
}
