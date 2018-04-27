/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongpth.dtos;

import java.io.Serializable;

/**
 *
 * @author DuongPTHSE62871
 */
public class UserDTO implements Serializable {

    private String userIs;
    private String name;
    private String password;
    private boolean available;

    public UserDTO() {
    }

    public UserDTO(String userIs, String name, String password, boolean available) {
        this.userIs = userIs;
        this.name = name;
        this.password = password;
        this.available = available;
    }

    public UserDTO(String userIs, String name, boolean available) {
        this.userIs = userIs;
        this.name = name;
        this.available = available;
    }

    /**
     * @return the userIs
     */
    public String getUserIs() {
        return userIs;
    }

    /**
     * @param userIs the userIs to set
     */
    public void setUserIs(String userIs) {
        this.userIs = userIs;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the available
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * @param available the available to set
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }
}
