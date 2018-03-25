/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author dragneol
 */
public class DBUtils implements Serializable {

//    public static Connection getConnection() throws ClassNotFoundException, SQLException {
//        Connection connection = null;
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String url = "jdbc:sqlserver://localhost:1433;databaseName=SE1264MVC2";
//            connection = DriverManager.getConnection(url, "sa", "Dragneol1");
//        } finally {
//            return connection;
//        }        
//    }
    
    public static Connection getConnection() throws NamingException, SQLException {
        Context context = new InitialContext();
        Context webAppContext = (Context)context.lookup("java:comp/env");
        
        DataSource database = (DataSource)webAppContext.lookup("SE1264MVC2");
        
        Connection connection = database.getConnection();
        
        return connection;
    }
}
