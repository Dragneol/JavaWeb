/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongpth.tbl_Mobile;

import duongpth.utils.DatabaseUtil;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dragneol
 */
public class MobileDAO implements Serializable {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
//    private List<MobileDTO> listMobile;

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

//    /**
//     * @return the listMobile ResultSet DAO after query database
//     */
//    
//    public List<MobileDTO> getListMobile() {
//        return listMobile;
//    }
    
    public MobileDTO searchById(String mobileId) throws SQLException {
        MobileDTO dto = null;
        try {
            connection = DatabaseUtil.getConnection();

            if (connection != null) {
                String sql = "Select * From tbl_Mobile Where mobileId=?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, mobileId);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String description = resultSet.getString("description");
                    float price = resultSet.getFloat("price");
                    String mobileName = resultSet.getString("mobileName");
                    int yearOfProduction = resultSet.getInt("yearOfProduction");
                    int quantity = resultSet.getInt("quantity");
                    boolean notSale = resultSet.getBoolean("notSale");
                    dto = new MobileDTO(mobileId, description, price, mobileName, yearOfProduction, quantity, notSale);
                }
            }

        } finally {
            closeConnection();
            return dto;
        }
    }
}
