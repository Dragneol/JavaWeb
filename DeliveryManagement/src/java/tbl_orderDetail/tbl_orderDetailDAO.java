/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbl_orderDetail;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import utils.DBUtil;

/**
 *
 * @author dragneol
 */
public class tbl_orderDetailDAO implements Serializable {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    List<tbl_orderDetailDTO> listResult = null;

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

    public List<tbl_orderDetailDTO> getListResult() {
        return listResult;
    }

    public void getOrderDetail(String orderId) throws NamingException, SQLException {
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "select * from tbl_orderDetail where orderID=?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, orderId);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    if (listResult == null) {
                        listResult = new ArrayList<>();
                    }
                    String productID = resultSet.getString("productID");
                    int quantity = resultSet.getInt("quantity");
                    float unitPrice = resultSet.getFloat("unitPrice");
                    float total = resultSet.getFloat("total");
                    listResult.add(new tbl_orderDetailDTO(productID, quantity, unitPrice, total));
                }
            }
        } finally {
            closeConnection();
        }
    }
}
