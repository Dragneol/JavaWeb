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
public class CartErr implements Serializable{
    private String invalidQuantity;
    private String notEnoughDevice;

    public String getInvalidQuantity() {
        return invalidQuantity;
    }

    public void setInvalidQuantity(String invalidQuantity) {
        this.invalidQuantity = invalidQuantity;
    }

    public String getNotEnoughDevice() {
        return notEnoughDevice;
    }

    public void setNotEnoughDevice(String notEnoughDevice) {
        this.notEnoughDevice = notEnoughDevice;
    }
        
}
