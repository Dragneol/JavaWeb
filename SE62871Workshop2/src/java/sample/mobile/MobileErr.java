/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.mobile;

import java.io.Serializable;

/**
 *
 * @author dragneol
 */
public class MobileErr implements Serializable{
    private String descriptionIsEmpty;
    private String invalidQuantity;
    private String invalidPrice;
    
    private String mobileIDIsEmpty;
    private String nameIsEmpty;
    private String invalidYearOfProduction;
    private String mobileIDIsExisted;

    private String invalidMinPrice;
    private String invalidMaxPrice;
    
    public String getDescriptionIsEmpty() {
        return descriptionIsEmpty;
    }

    public void setDescriptionIsEmpty(String descriptionIsEmpty) {
        this.descriptionIsEmpty = descriptionIsEmpty;
    }

    public String getInvalidQuantity() {
        return invalidQuantity;
    }

    public void setInvalidQuantity(String invalidQuantity) {
        this.invalidQuantity = invalidQuantity;
    }

    public String getInvalidPrice() {
        return invalidPrice;
    }

    public void setInvalidPrice(String invalidPrice) {
        this.invalidPrice = invalidPrice;
    }

    public String getMobileIDIsEmpty() {
        return mobileIDIsEmpty;
    }

    public void setMobileIDIsEmpty(String mobileIDIsEmpty) {
        this.mobileIDIsEmpty = mobileIDIsEmpty;
    }

    public String getNameIsEmpty() {
        return nameIsEmpty;
    }

    public void setNameIsEmpty(String nameIsEmpty) {
        this.nameIsEmpty = nameIsEmpty;
    }

    public String getInvalidYearOfProduction() {
        return invalidYearOfProduction;
    }

    public void setInvalidYearOfProduction(String invalidYearOfProduction) {
        this.invalidYearOfProduction = invalidYearOfProduction;
    }

    public String getMobileIDIsExisted() {
        return mobileIDIsExisted;
    }

    public void setMobileIDIsExisted(String mobileIDIsExisted) {
        this.mobileIDIsExisted = mobileIDIsExisted;
    }

    public String getInvalidMinPrice() {
        return invalidMinPrice;
    }

    public void setInvalidMinPrice(String invalidMinPrice) {
        this.invalidMinPrice = invalidMinPrice;
    }

    public String getInvalidMaxPrice() {
        return invalidMaxPrice;
    }

    public void setInvalidMaxPrice(String invalidMaxPrice) {
        this.invalidMaxPrice = invalidMaxPrice;
    }
    
}
