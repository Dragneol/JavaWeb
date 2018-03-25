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
public class UpdateDeleteAction extends ActionSupport{
    private String mobileID;
    private String description;
    private Integer quantity;
    private float price;
    private boolean notSale;
    private String searchValue;
    private String update;
    private String delete;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public UpdateDeleteAction() {
    }
    
    public String execute() throws Exception {
        MobileDAO dao = new MobileDAO();
        boolean result = false;
        if (update != null) result = dao.update(mobileID, description, quantity, price, notSale);
        if (delete != null) result = dao.delete(mobileID);
        return result ? SUCCESS : FAIL;
    }

    public String getMobileID() {
        return mobileID;
    }

    public void setMobileID(String mobileID) {
        this.mobileID = mobileID;
    }

    public String getDescription() {
        return description;
    }

    @RequiredStringValidator(
            trim = true
    )
    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @IntRangeFieldValidator(
            minExpression = "0"
    )
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    @DoubleRangeFieldValidator(
            minExclusive = "0"
    )
    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isNotSale() {
        return notSale;
    }

    public void setNotSale(boolean notSale) {
        this.notSale = notSale;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }
    
}
