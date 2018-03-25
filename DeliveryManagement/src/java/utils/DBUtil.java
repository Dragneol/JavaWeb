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
public class DBUtil implements Serializable {

    public static Connection getConnection() throws NamingException, SQLException {

        Context context = new InitialContext();
        Context tomcatcontext = (Context) context.lookup("java:comp/env");
        DataSource ds = (DataSource) tomcatcontext.lookup("DBSource");
        return ds.getConnection();

//        Connection con = null;
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=DeliveryManagement", "sa", "Dragneol1");
//        } catch (Exception e) {
//            System.out.println(e.getCause());
//        }
//        return con;
    }
}
