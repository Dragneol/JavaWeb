/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbl_order;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import tbl_book.tbl_bookDTO;
import utils.DBUtil;

/**
 *
 * @author dragneol
 */
public class tbl_orderDAO implements Serializable {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private List<tbl_orderDTO> result = null;

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

    public void searchOrder(Date from, Date to, boolean isDeliver) throws SQLException, NamingException {
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "SELECT * FROM tbl_Order WHERE [isDeliver] = ? AND [orderDate] >= ? AND [orderDate] <= ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setBoolean(1, isDeliver);
                preparedStatement.setDate(2, from);
                preparedStatement.setDate(3, to);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    if (result == null) {
                        result = new ArrayList<>();
                    }
                    String orderID = resultSet.getString("orderID");
                    Date orderDate = resultSet.getDate("orderDate");
                    String custID = resultSet.getString("custID");
                    float price = resultSet.getFloat("total");
                    String Reason = resultSet.getString("Reason");
                    result.add(new tbl_orderDTO(orderID, orderDate, custID, price, isDeliver, Reason));
                }
            }
        } finally {
            closeConnection();
        }
    }

    /**
     * @return the result
     */
    public List<tbl_orderDTO> getResult() {
        return result;
    }

    public boolean changeStatus(boolean isDeliver, String orderID) throws SQLException, NamingException {
        boolean updated = false;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "UPDATE tbl_order SET isDeliver=? WHERE orderID = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setBoolean(1, isDeliver);
                preparedStatement.setString(2, orderID);
                updated = preparedStatement.executeUpdate() > 0 ? true : false;
            }

        } finally {
            closeConnection();
            return updated;
        }
    }
}
