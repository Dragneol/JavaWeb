/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.DoubleRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import sample.mobile.MobileDAO;

/**
 *
 * @author dragneol
 */
public class AddAction extends ActionSupport{
    private String mobileID;
    private String name;
    private String description;
    private float price;
    private int yearOfProduction;
    private int quantity;
    private boolean notSale;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public AddAction() {
    }
    
    public String execute() throws Exception {
        MobileDAO dao = new MobileDAO();
        boolean result = dao.insert(mobileID, name, description, price, yearOfProduction, quantity, notSale);
        return result ? SUCCESS : FAIL;
    }

    public String getMobileID() {
        return mobileID;
    }

    @RequiredStringValidator(
            trim = true,
            message = "ID required"
    )
    public void setMobileID(String mobileID) {
        this.mobileID = mobileID;
    }

    public String getName() {
        return name;
    }

    @RequiredStringValidator(
            trim = true,
            message = "Name required"
    )
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    @RequiredStringValidator(
            trim = true,
            message = "Description required"
    )
    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    @DoubleRangeFieldValidator(
            minExclusive = "0",
            message = "Price must be a positive number"
    )
    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    @IntRangeFieldValidator(
            min = "2000",
            message = "Year of production must not be less than 2000"
    )
    public void setYearOfProduction(Integer yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @IntRangeFieldValidator(
            min = "0",
            message = "Quantity must be a nonnegative number"
    )
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean isNotSale() {
        return notSale;
    }

    public void setNotSale(boolean notSale) {
        this.notSale = notSale;
    }
    
}
