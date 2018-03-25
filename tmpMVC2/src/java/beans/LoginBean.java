/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import day07.registration.RegistrationDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author dragneol
 */
public class LoginBean implements Serializable{
    private String user;
    private String pass;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public LoginBean() {
    }

    public LoginBean(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }
    
    public boolean checkLogin() {
        RegistrationDAO dao = new RegistrationDAO();
        boolean result = false;
        try {
            result = dao.checkLogin(user, pass);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
