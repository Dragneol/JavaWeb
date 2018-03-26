/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabean;

import daos.UserDAO;
import java.io.Serializable;

/**
 *
 * @author Dragneol
 */
public class LoginBean implements Serializable {

    private String username, fullname, password, role;

    public LoginBean() {
    }

    public LoginBean(String username, String fullname, String role) {
        this.username = username;
        this.fullname = fullname;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String checkLogin() throws Exception {
        String role = "failed";
        UserDAO dao = new UserDAO();
        role = dao.checkLogin(getUsername(), getPassword());
        return role;
    }

}
