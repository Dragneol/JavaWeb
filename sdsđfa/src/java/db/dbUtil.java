/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ngocnt
 */
public class dbUtil implements Serializable {

    public static Connection connection;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        connection = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=LoginDB;instanceName=SQLEXPRESS";
        String user = "sa";
        String pass = "123";
        connection = DriverManager.getConnection(url, user, pass);
        return connection;
    }
}
