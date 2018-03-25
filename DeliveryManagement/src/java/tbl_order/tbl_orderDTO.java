/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbl_order;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author dragneol
 */
public class tbl_orderDTO implements Serializable {

    private String orderID;
    private Date orderDate;
    private String custID;
    private float total;
    private boolean isDeliver;
    private String reason;

    public tbl_orderDTO(String orderID, Date orderDate, String custID, float total, boolean isDeliver, String reason) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.custID = custID;
        this.total = total;
        this.isDeliver = isDeliver;
        this.reason = reason;
    }

    public tbl_orderDTO(String orderID, String custID, boolean isDeliver) {
        this.orderID = orderID;
        this.custID = custID;
        this.isDeliver = isDeliver;
    }

    public tbl_orderDTO() {
    }

    /**
     * @return the orderID
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * @param orderID the orderID to set
     */
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    /**
     * @return the orderDate
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return the custID
     */
    public String getCustID() {
        return custID;
    }

    /**
     * @param custID the custID to set
     */
    public void setCustID(String custID) {
        this.custID = custID;
    }

    /**
     * @return the total
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(float total) {
        this.total = total;
    }

    /**
     * @return the isDeliver
     */
    public boolean isIsDeliver() {
        return isDeliver;
    }

    /**
     * @param isDeliver the isDeliver to set
     */
    public void setIsDeliver(boolean isDeliver) {
        this.isDeliver = isDeliver;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

}
