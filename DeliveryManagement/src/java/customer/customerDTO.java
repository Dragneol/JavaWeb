/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import java.io.Serializable;

/**
 *
 * @author dragneol
 */
public class customerDTO implements Serializable {

    private String custID;
    private String password;
    private String custName;
    private String lastName;
    private String middleName;
    private String address;
    private String phone;
    private int custLevel;

    public customerDTO(String custID, String password, String custName, String lastName, String middleName, String address, String phone, int custLevel) {
        this.custID = custID;
        this.password = password;
        this.custName = custName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.address = address;
        this.phone = phone;
        this.custLevel = custLevel;
    }

    public customerDTO() {
    }

    public customerDTO(String custID, String password, String custName) {
        this.custID = custID;
        this.password = password;
        this.custName = custName;
    }

    /**
     * @return the custID
     */
    public String getCustID() {
        return custID;
    }

    /**
     * @param custID the custID to set
     */
    public void setCustID(String custID) {
        this.custID = custID;
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
     * @return the custName
     */
    public String getCustName() {
        return custName;
    }

    /**
     * @param custName the custName to set
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName the middleName to set
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the custLevel
     */
    public int getCustLevel() {
        return custLevel;
    }

    /**
     * @param custLevel the custLevel to set
     */
    public void setCustLevel(int custLevel) {
        this.custLevel = custLevel;
    }

}
