/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2;

import java.util.List;
import sample.users.UsersDAO;
import sample.users.UsersDTO;

/**
 *
 * @author Nguyen Duy Dat
 */
public class SearchLastNameAction {
    private String searchValue;
    private final String SUCCESS="success";
    private List<UsersDTO> listAccount;
    
    public SearchLastNameAction() {
    }
    
    public String execute() throws Exception {
        UsersDAO dao= new UsersDAO();
        dao.searchLastName(getSearchValue());
        this.listAccount=dao.getListAccounts();
        return SUCCESS;
    }

    /**
     * @return the searchValue
     */
    public String getSearchValue() {
        return searchValue;
    }

    /**
     * @param searchValue the searchValue to set
     */
    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    /**
     * @return the listAccount
     */
    public List<UsersDTO> getListAccount() {
        return listAccount;
    }

    /**
     * @param listAccount the listAccount to set
     */
    public void setListAccount(List<UsersDTO> listAccount) {
        this.listAccount = listAccount;
    }
    
}
