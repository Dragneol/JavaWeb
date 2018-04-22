/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongpth.dtos;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author DuongPTHSE62871
 */
public class CartObj implements Serializable {

    private String custName;
    private HashMap<String, PhoneDTO> cart;

    public CartObj() {
        this.custName = "guest";
        this.cart = new HashMap<>();
    }

    public CartObj(String custName) {
        this.custName = custName;
        this.cart = new HashMap<>();
    }

    /**
     * @return the custName
     */
    public String getCustName() {
        return custName;
    }

    /**
     * @return the cart
     */
    public HashMap<String, PhoneDTO> getCart() {
        return cart;
    }

    /**
     * @param custName the custName to set
     * @used when guest has been loged in
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void addToCart(PhoneDTO phone) throws Exception {
        PhoneDTO dto = cart.get(phone.getPhoneId());
        if (dto != null) {
            dto.setQuantity(dto.getQuantity() + 1);
        }
        cart.put(dto.getPhoneId(), dto);
    }

    public void removeCart(PhoneDTO phone) throws Exception {
        cart.remove(phone);
    }

    public void removeCart(String phoneId) throws Exception {
        cart.remove(phoneId);
    }

    public float getTotal() {
        float result = 0;
        for (PhoneDTO dto : cart.values()) {
            result += dto.getPrice() * dto.getQuantity();
        }
        return result;
    }

    public void updateCart(String phoneId, int quantity) throws Exception {
        PhoneDTO dto = cart.get(phoneId);
        if (dto != null) {
            dto.setQuantity(quantity);
        }
    }
}
