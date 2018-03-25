/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import utils.DBUtil;

/**
 *
 * @author dragneol
 */
public class customerDAO implements Serializable {

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

    public customerDTO login(String custID, String password) throws SQLException, NamingException {
        customerDTO customer = null;
        try {
//            System.out.println("loginDAO");
            connection = DBUtil.getConnection();
//            System.out.println("get connected");
            if (connection != null) {
                String sql = "Select * From customer where custId=? And password=?";
//                String sql = "Select * From customer where custId='duong' And password='duong'";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, custID);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String name = resultSet.getString("custName");
                    customer = new customerDTO(custID, password, name);
                }
            } else {
//                System.out.println("null connection");
            }
        } finally {
            closeConnection();
            return customer;
        }
    }

    public customerDTO getCustInfo(String custID) throws SQLException {
        customerDTO customer = null;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "Select * from customer Where custID = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, custID);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    customer = new customerDTO();
                    customer.setCustName(resultSet.getString("custName"));
                    customer.setAddress(resultSet.getString("address"));
                    customer.setPhone(resultSet.getString("phone"));
                }
            }
        } finally {
            closeConnection();
            return customer;
        }
    }

    public boolean signup(customerDTO dto) throws SQLException, NamingException {
        boolean signed = false;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "INSERT INTO customer\n"
                        + "(custID, password, custName, lastName, middleName, address, phone, custLevel)\n"
                        + "VALUES(?, ?, ?, ?, ?, ?, ?, 0)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, dto.getCustID());
                preparedStatement.setString(2, dto.getPassword());
                preparedStatement.setString(3, dto.getCustName());
                preparedStatement.setString(4, dto.getLastName());
                preparedStatement.setString(5, dto.getMiddleName());
                preparedStatement.setString(6, dto.getAddress());
                preparedStatement.setString(7, dto.getPhone());
                int rowEffected = preparedStatement.executeUpdate();
                if (rowEffected > 0) {
                    signed = true;
                }
            }

        } finally {
            closeConnection();
            return signed;
        }
    }
}
