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
import javax.naming.NamingException;
import pacific.dtos.PilotDTO;
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
        String firstname, groupCode;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "Select FirstName, GroupCode from Pilot Where Username = ? And Password = ? And Available = 1";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    firstname = resultSet.getString("FirstName");
                    groupCode = resultSet.getString("GroupCode");
                    dto = new PilotDTO(username, firstname, groupCode);
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public PilotDTO findByUsername(String username) throws NamingException, SQLException {
        PilotDTO dto = null;
        String firstname, lastname, middlename, groupCode;
        float weight, height;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "Select FirstName, LastName, MiddleName, Weight, Height, GroupCode from Pilot Where Username = ? And Available = 1";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    firstname = resultSet.getString("FirstName");
                    lastname = resultSet.getString("LastName");
                    middlename = resultSet.getString("MiddleName");
                    groupCode = resultSet.getString("GroupCode");
                    weight = resultSet.getFloat("Weight");
                    height = resultSet.getFloat("Height");
                    dto = new PilotDTO(username, firstname, lastname, middlename, groupCode, weight, height);
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
}
