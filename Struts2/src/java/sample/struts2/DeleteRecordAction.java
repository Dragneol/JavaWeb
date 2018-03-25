/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2;

import sample.users.UsersDAO;

/**
 *
 * @author Nguyen Duy Dat
 */
public class DeleteRecordAction {
    private String pk;
    private String lastSearchValue;
    private final String SUCCESS="success";
    private final String FAIL="fail";
    public DeleteRecordAction() {
    }
    
    public String execute() throws Exception {
        UsersDAO dao= new UsersDAO();
        boolean result=dao.deletePk(pk);
        String url=FAIL;
        if(result){
            url=SUCCESS;
        }
        return url;
    }

    /**
     * @return the pk
     */
    public String getPk() {
        return pk;
    }

    /**
     * @param pk the pk to set
     */
    public void setPk(String pk) {
        this.pk = pk;
    }

    /**
     * @return the lastSearchValue
     */
    public String getLastSearchValue() {
        return lastSearchValue;
    }

    /**
     * @param lastSearchValue the lastSearchValue to set
     */
    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }
    
}
