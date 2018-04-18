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
public class RegistrationDTO implements Serializable {

    private String username;
    private String passwork;
    private String fullname;
    private String role;

    public RegistrationDTO(String username, String passwork) {
        this.username = username;
        this.passwork = passwork;
    }

    public RegistrationDTO(String username, String fullname, String role) {
        this.username = username;
        this.fullname = fullname;
        this.role = role;
    }

    

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the passwork
     */
    public String getPasswork() {
        return passwork;
    }

    /**
     * @param passwork the passwork to set
     */
    public void setPasswork(String passwork) {
        this.passwork = passwork;
    }

    /**
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

}
