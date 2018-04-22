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
public class PhoneDTO implements Serializable {

    private String phoneId, phoneName;
    private float price;
    private int quantity;

    public PhoneDTO(String phoneId, String phoneName, float price, int quantity) {
        this.phoneId = phoneId;
        this.phoneName = phoneName;
        this.price = price;
        this.quantity = quantity;
    }

    public PhoneDTO() {
    }

    /**
     * @return the phoneId
     */
    public String getPhoneId() {
        return phoneId;
    }

    /**
     * @param phoneId the phoneId to set
     */
    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }

    /**
     * @return the phoneName
     */
    public String getPhoneName() {
        return phoneName;
    }

    /**
     * @param phoneName the phoneName to set
     */
    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
