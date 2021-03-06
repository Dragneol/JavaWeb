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
import pacific.dtos.Skill;
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

    public List<String> getAllRobot() throws SQLException, NamingException {
        List<String> list = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                preparedStatement = connection.prepareStatement("select Robot from Robot");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    list.add(resultSet.getString("Robot"));
                }
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<Skill> getAllSkillName() throws SQLException, NamingException {
        List<Skill> list = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                preparedStatement = connection.prepareStatement("select BattleTypeId, BattleSkill from Skill");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    list.add(new Skill(resultSet.getString("BattleTypeId"), resultSet.getString("BattleSkill")));
                }
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<Skill> getSkillOf(String robot, List<Skill> fullList) throws SQLException, NamingException {
        List<Skill> list = fullList;
        String id;
        int length = list.size();
        Skill skill;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "select BattleTypeId from BattleSkill where Robot = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, robot);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    id = resultSet.getString("BattleTypeId");
                    for (int i = 0; i < length; i++) {
                        skill = list.get(i);
                        if (skill.getId().equals(id)) {
//                            skill.setChecked(true);
                            list.get(i).setChecked(true);
                        }
                    }
                }
            }
        } finally {
            closeConnection();
        }
        return list;
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
                String sql = "Select ImgLink, Available, DateLauched, Classified, Origin, KaijuKilled from Robot where Robot = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, name);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
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

    public boolean updateByPrimaryKey(RobotDTO dto) throws NamingException, SQLException {
        boolean updated = false;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "UPDATE Robot SET Available = ?, DateLauched = ?, Classified = ?, Origin = ?, KaijuKilled = ?, ImgLink = ? WHERE Robot = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setBoolean(1, dto.isAvailable());
                preparedStatement.setDate(2, dto.getDateLauched());
                preparedStatement.setString(3, dto.getClassified());
                preparedStatement.setString(4, dto.getOrigin());
                preparedStatement.setInt(5, dto.getKaijuKilled());
                preparedStatement.setString(6, dto.getImgLink());
                preparedStatement.setString(7, dto.getName());

                updated = preparedStatement.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return updated;
    }
}
