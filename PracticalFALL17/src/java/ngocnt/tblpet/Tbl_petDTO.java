/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngocnt.tblpet;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author ngocnt
 */
public class Tbl_petDTO implements Serializable{
    
    private String petId;
    private String petName;
    private String description;
    private Timestamp dob;
    private String vaccineDesp;
    private float price;
    private Timestamp registerDate;
    private int approveReg;
    private String userId;

    public Tbl_petDTO() {
    }

    
    
    public Tbl_petDTO(String petId, String petName, String description, Timestamp dob, String vaccineDesp, float price, Timestamp registerDate, int approveReg, String userId) {
        this.petId = petId;
        this.petName = petName;
        this.description = description;
        this.dob = dob;
        this.vaccineDesp = vaccineDesp;
        this.price = price;
        this.registerDate = registerDate;
        this.approveReg = approveReg;
        this.userId = userId;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDob() {
        return dob;
    }

    public void setDob(Timestamp dob) {
        this.dob = dob;
    }

    public String getVaccineDesp() {
        return vaccineDesp;
    }

    public void setVaccineDesp(String vaccineDesp) {
        this.vaccineDesp = vaccineDesp;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    public int getApproveReg() {
        return approveReg;
    }

    public void setApproveReg(int approveReg) {
        this.approveReg = approveReg;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    
    
}
