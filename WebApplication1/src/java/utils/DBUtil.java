/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Dragneol
 */
public class DBUtil implements Serializable {

    public static Connection getConnection() throws NamingException, SQLException {
        Context context = new InitialContext();
        Context webApp = (Context) context.lookup("java:comp/env");
        DataSource database = (DataSource) webApp.lookup("SE62871");
        return database.getConnection();
    }
}
