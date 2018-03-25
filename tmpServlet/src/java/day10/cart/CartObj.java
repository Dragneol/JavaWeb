/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day10.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dragneol
 */
public class CartObj implements Serializable {

    private Map<String, Integer> items;
    private String customerId;

    public CartObj(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CartObj() {
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void addItemToCart(String tile) {
        if (this.items == null) {
            this.items = new HashMap<>();
        }

        int quantity = 1;
        if (this.items.containsKey(tile)) {
            quantity = this.items.get(tile) + 1;
        }

        this.items.put(tile, quantity);
    }

    public void removeItemFromCart(String tile) {
        if (this.items == null) {
            return;
        }

        if (this.items.containsKey(tile)) {
            this.items.remove(tile);
            if (this.items.isEmpty()) {
                this.items = null;
            }
        }

    }

}
