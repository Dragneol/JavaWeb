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
public class UpdateAction {
    private String username;
    private String password;
    private boolean role;
    private String lastSearchValue;
    
    private final String SUCCESS="success";
    private final String FAIL="fail";
    public UpdateAction() {
    }
    
    public String execute() throws Exception {
        UsersDAO dao= new UsersDAO();
        boolean result=dao.update(username, password, role);
        String url=FAIL;
        if(result){
            url=SUCCESS;
        }
        return url;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * @return the role
     */
    public boolean isRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(boolean role) {
        this.role = role;
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
