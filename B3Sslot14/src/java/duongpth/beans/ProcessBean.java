/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongpth.beans;

import duongpth.daos.RegistrationDAO;
import duongpth.dtos.RegistrationDTO;
import java.beans.*;
import java.io.Serializable;
import java.sql.SQLException;

/**
 *
 * @author DuongPTHSE62871
 */
public class ProcessBean implements Serializable {

    private String username, password;
    private RegistrationDTO dto;

    public ProcessBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public ProcessBean(String username) {
        this.username = username;
    }

    public ProcessBean(RegistrationDTO dto) {
        this.dto = dto;
    }

    public String checkLogin() throws ClassNotFoundException, SQLException {
        RegistrationDAO dao = new RegistrationDAO();
        return dao.checkLogin(getUsername(), getPassword());
    }

    public boolean deleteRecord() throws SQLException, ClassNotFoundException {
        RegistrationDAO dao = new RegistrationDAO();
        return dao.removeByPrimaryKey(username);
    }

    public boolean insertRecord() throws SQLException, ClassNotFoundException {
        RegistrationDAO dao = new RegistrationDAO();
        return dao.insertRecord(dto);
    }

    public boolean updateByPrimary() throws ClassNotFoundException, SQLException {
        RegistrationDAO dao = new RegistrationDAO();
        return dao.updateRecord(dto);
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

}
