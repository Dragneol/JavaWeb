/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search.dtos;

import java.io.Serializable;

/**
 *
 * @author Dragneol
 */
public class UserDTO implements Serializable {

    public UserDTO() {
    }

    private String username, password, role, fulname;

    public UserDTO(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public UserDTO(String username, String role, String fulname) {
        this.username = username;
        this.role = role;
        this.fulname = fulname;
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

    public String getFulname() {
        return fulname;
    }

    public void setFulname(String fulname) {
        this.fulname = fulname;
    }

}
