/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import daos.UserDAO;
import java.io.Serializable;

/**
 *
 * @author Dragneol
 */
public class loginBean implements Serializable {

    private String username, password, role, fullname;

    public loginBean(String username, String role, String fullname) {
        this.username = username;
        this.role = role;
        this.fullname = fullname;
    }

    public loginBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String checkLogin() throws Exception {
        UserDAO dao = new UserDAO();
        String role = dao.checkLogin(username, password);
        return role;
    }
}
