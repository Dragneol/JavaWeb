/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbl_book;

import java.io.Serializable;

/**
 *
 * @author dragneol
 */
public class tbl_bookDTO implements Serializable {

    private String booktID;
    private String title;
    private float price;
    private int quantity;

    public tbl_bookDTO(String booktID, String title, float price, int quantity) {
        this.booktID = booktID;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public tbl_bookDTO() {
    }

    /**
     * @return the booktID
     */
    public String getBooktID() {
        return booktID;
    }

    /**
     * @param booktID the booktID to set
     */
    public void setBooktID(String booktID) {
        this.booktID = booktID;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
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
