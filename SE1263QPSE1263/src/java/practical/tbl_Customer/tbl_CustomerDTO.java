/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical.tbl_Customer;

import java.io.Serializable;

/**
 *
 * @author Dragneol
 */
public class tbl_CustomerDTO implements Serializable {

    private String username;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String address;
    private int customerLevel;

    public tbl_CustomerDTO(String username, String password, String fullName, String phoneNumber, String address) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public tbl_CustomerDTO() {
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
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the customerLevel
     */
    public int getCustomerLevel() {
        return customerLevel;
    }

    /**
     * @param customerLevel the customerLevel to set
     */
    public void setCustomerLevel(int customerLevel) {
        this.customerLevel = customerLevel;
    }

}
