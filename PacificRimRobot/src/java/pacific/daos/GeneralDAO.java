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
import pacific.dtos.GeneralDTO;
import pacific.utils.DBUtil;

/**
 *
 * @author DuongPTHSE62871
 */
public class GeneralDAO implements Serializable {

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
    
    public GeneralDTO signIn(String username, String password) throws NamingException, SQLException {
        GeneralDTO dto = null;
        String firstname, lastname, middlename;
        try {
            connection = DBUtil.getConnection();
            if (connection!=null) {
                String sql = "Select Firstname, LastName, MiddleName from General where Username = ? and Password =? and Available = 1";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){
                    firstname = resultSet.getString("FirstName");
                    lastname = resultSet.getString("LastName");
                    middlename = resultSet.getString("MiddleName");
                    dto = new GeneralDTO(firstname, lastname, middlename);
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
}
