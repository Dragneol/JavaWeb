/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.cart;

import java.io.Serializable;

/**
 *
 * @author dragneol
 */
public class CartDTO implements Serializable{
    private String mobileID;
    private String mobileName;
    private float price;
    private int quantity;
    private String status;

    public CartDTO() {
    }

    public CartDTO(String mobileID, String mobileName, float price, int quantity, String status) {
        this.mobileID = mobileID;
        this.mobileName = mobileName;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }
    
    public String getMobileID() {
        return mobileID;
    }

    public void setMobileID(String mobileID) {
        this.mobileID = mobileID;
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
