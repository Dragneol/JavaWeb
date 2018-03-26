/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical.tbl_Book;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import practical.utils.DBUtil;

/**
 *
 * @author Dragneol
 */
public class tbl_BookDAO implements Serializable {

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

    public List<tbl_BookDTO> searchTitle(String tile) throws SQLException {
        List<tbl_BookDTO> list = null;
        try {
            connection = DBUtil.getConnection();
            if (connection != null) {
                String sql = "select * from tbl_Book where bookTitle LIKE ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "%" + tile + "%");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    String bookId = resultSet.getString("bookId");
                    String bookTitle = resultSet.getString("bookTitle");
                    String author = resultSet.getString("author");
                    String publisher = resultSet.getString("publisher");
                    String description = resultSet.getString("description");
                    float price = resultSet.getFloat("price");
                    list.add(new tbl_BookDTO(bookId, bookTitle, description, author, publisher));
                }
            }
        } finally {
            closeConnection();
            return list;
        }
    }
}
