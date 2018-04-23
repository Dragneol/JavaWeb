/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongpth.beans;

import duongpth.daos.RegistrationDAO;
import duongpth.dtos.RegistrationDTO;
import java.io.Serializable;

/**
 *
 * @author DuongPTHSE62871
 */
public class ProcessBean implements Serializable {

    private String username, password;
    private RegistrationDTO dto;

    public ProcessBean() {
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

    public String signIn() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        return dao.signIn(username, password);
    }

    /**
     * @return the dto
     */
    public RegistrationDTO getDto() {
        return dto;
    }

    /**
     * @param dto the dto to set
     */
    public void setDto(RegistrationDTO dto) {
        this.dto = dto;
    }

    public boolean registration() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        return dao.inserṭ̣(dto);
    }
}
