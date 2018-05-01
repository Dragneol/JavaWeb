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
import pacific.dtos.PilotDTO;
import pacific.dtos.Skill;
import pacific.utils.DBUtil;

/**
 *
 * @author DuongPTHSE62871
 */
public class PilotDAO implements Serializable {

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

    public PilotDTO signIn(String username, String password) throws SQLException, NamingException {
        PilotDTO dto = null;
        String firstname, lastname, group, imgLink;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "Select FirstName, LastName, GroupCode, ImgLink from Pilot Where Username = ? And Password = ? And Available = 1";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    firstname = resultSet.getString("FirstName");
                    lastname = resultSet.getString("LastName");
                    group = resultSet.getString("GroupCode");
                    imgLink = resultSet.getString("ImgLink");
                    dto = new PilotDTO(username, firstname, lastname, group);
                    dto.setImgLink(imgLink);
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public PilotDTO findByUsername(String username) throws NamingException, SQLException {
        PilotDTO dto = null;
        String firstname, lastname, citizenship, groupCode, ranker, imglink;
        float weight, height;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "Select FirstName, LastName, Weight, Height, GroupCode, Citizenship, Ranker, ImgLink from Pilot Where Username = ? And Available = 1";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    firstname = resultSet.getString("FirstName");
                    lastname = resultSet.getString("LastName");
                    groupCode = resultSet.getString("GroupCode");
                    weight = resultSet.getFloat("Weight");
                    height = resultSet.getFloat("Height");
                    citizenship = resultSet.getString("Citizenship");
                    ranker = resultSet.getString("Ranker");
                    imglink = resultSet.getString("ImgLink");
                    dto = new PilotDTO(username, firstname, lastname, citizenship, groupCode, ranker, imglink, weight, height);
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    public PilotDTO findByPrimaryKey(String username) throws NamingException, SQLException {
        PilotDTO dto = null;
        String firstname, lastname, citizenship, groupCode, ranker, imglink;
        float weight, height;
        boolean avaliable;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "Select FirstName, LastName, Weight, Height, GroupCode, Citizenship, Ranker, ImgLink, Available from Pilot Where Username = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    firstname = resultSet.getString("FirstName");
                    lastname = resultSet.getString("LastName");
                    groupCode = resultSet.getString("GroupCode");
                    weight = resultSet.getFloat("Weight");
                    height = resultSet.getFloat("Height");
                    citizenship = resultSet.getString("Citizenship");
                    ranker = resultSet.getString("Ranker");
                    imglink = resultSet.getString("ImgLink");
                    avaliable = resultSet.getBoolean("Available");
                    dto = new PilotDTO(username, firstname, lastname, citizenship, groupCode, ranker, imglink, weight, height);
                    dto.setAvailable(avaliable);
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public List<PilotDTO> findByTeam(String groupCode, String username) throws NamingException, SQLException {
        List<PilotDTO> list = null;
        PilotDTO dto = null;
        String user, firstname, lastname, imglink;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "Select Username, FirstName, LastName, ImgLink from Pilot where Username = "
                        + "(Select Pilot From Rider where GroupCode = ? and Pilot != ?) and Available = 1";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, groupCode);
                preparedStatement.setString(2, username);
                resultSet = preparedStatement.executeQuery();
                list = new ArrayList<>();
                while (resultSet.next()) {
                    user = resultSet.getString("Username");
                    firstname = resultSet.getString("FirstName");
                    lastname = resultSet.getString("LastName");
                    imglink = resultSet.getString("ImgLink");
                    dto = new PilotDTO(user, firstname, lastname, groupCode);
                    dto.setImgLink(imglink);
                    list.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return list;
    }

    public String getRiderTeam(String username, String groupCode) throws SQLException, NamingException {
        String name = "none";
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "Select Robot From Rider where GroupCode = ? and Pilot != ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, groupCode);
                preparedStatement.setString(2, username);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    name = resultSet.getString("Robot");
                }
            }
        } finally {
            closeConnection();
        }
        return name;
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

    public List<Skill> getSkillOf(String pilot, List<Skill> fullList) throws SQLException, NamingException {
        List<Skill> list = fullList;
        String id;
        int length = list.size();
        Skill skill;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "select BattleTypeId from Ability where Pilot = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, pilot);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    id = resultSet.getString("BattleTypeId");
                    for (int i = 0; i < length; i++) {
                        skill = list.get(i);
                        if (skill.getId().equals(id)) {
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

    public List<PilotDTO> findByName(String name) throws SQLException, NamingException {
        List<PilotDTO> list = null;
        PilotDTO dto = null;
        String username, firstname, lastname, imglink, groupcode;
        boolean available;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "Select Username, FirstName, LastName, ImgLink, GroupCode, Available from Pilot Where FirstName like ? Or LastName like ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + name + "%");
                preparedStatement.setString(2, "%" + name + "%");
                resultSet = preparedStatement.executeQuery();
                list = new ArrayList<>();
                while (resultSet.next()) {
                    username = resultSet.getString("Username");
                    firstname = resultSet.getString("FirstName");
                    lastname = resultSet.getString("LastName");
                    imglink = resultSet.getString("ImgLink");
                    available = resultSet.getBoolean("Available");
                    groupcode = resultSet.getString("GroupCode");
                    dto = new PilotDTO(username, firstname, lastname, groupcode);
                    dto.setImgLink(imglink);
                    dto.setAvailable(available);
                    list.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return list;
    }
}
