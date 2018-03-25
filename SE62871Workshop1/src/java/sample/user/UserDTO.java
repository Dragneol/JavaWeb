/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.user;

import java.io.Serializable;

/**
 *
 * @author dragneol
 */
public class UserDTO implements Serializable{
    private String userID;
    private String password;
    private String fullname;
    private int role;

    public UserDTO() {
    }

    public UserDTO(String userID, String password, String fullname, int role) {
        this.userID = userID;
        this.password = password;
        this.fullname = fullname;
        this.role = role;
    }

    public UserDTO(String userID, String fullname, int role) {
        this.userID = userID;
        this.fullname = fullname;
        this.role = role;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
}
