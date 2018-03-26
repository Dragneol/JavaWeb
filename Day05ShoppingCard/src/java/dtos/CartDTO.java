/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Dragneol
 */
public class CartDTO implements Serializable {

    private String customerName;
    private HashMap<String, BookDTO> cart;

    public CartDTO(String customerName) {
        this.customerName = customerName;
        this.cart = new HashMap<>();
    }

    public CartDTO() {
        this.customerName = "guest";
        this.cart = new HashMap<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public HashMap<String, BookDTO> getCart() {
        return cart;
    }

    public void addToCart(BookDTO dto) throws Exception {
        if (cart.containsKey(dto.getBookID())) {
            int quantity = cart.get(dto.getBookID()).getQuantity() + 1;
            dto.setQuantity(quantity);
        }
        cart.put(dto.getBookID(), dto);
    }

    public void removeFromCart(String id) throws Exception {
        if (cart.containsKey(id)) {
            cart.remove(id);
        } else {
            //kieemr tra neu remove item k nawm trong list truowc            
        }
    }

    public void update(String id, int quantity) throws Exception {
        for (BookDTO dto : cart.values()) {
            if (dto.getBookID().equals(id)) {
                dto.setQuantity(quantity);
            }
        }
    }

    public double total() {
        double result = 0.0;
        for (BookDTO dto : cart.values()) { // cart.values : loi ra toan bo item trong hashmap
            result += dto.getPrice() * dto.getQuantity();
        }
        return result;
    }
}
