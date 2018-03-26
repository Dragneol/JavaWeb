/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongpth.tbl_User;

import java.io.Serializable;

/**
 *
 * @author dragneol
 */
public class UserDTO implements Serializable{
    private String userId;
    private int password;
    private String fullName;
    private int role;

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the password
     */
    public int getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(int password) {
        this.password = password;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the role code
     * 0: user
     * 1: manager
     * 2: staff
     */
    public int getRole() {
        return role;
    }

    /**
     * @param role the role code to set
     * 0: user
     * 1: manager
     * 2: staff
     */
    public void setRole(int role) {
        this.role = role;
    }

    public UserDTO(String userId, int password, String fullName, int role) {
        this.userId = userId;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
    }

    public UserDTO() {
    }
    
    
}
