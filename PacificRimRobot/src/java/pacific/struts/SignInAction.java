/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacific.struts;

/**
 *
 * @author DuongPTHSE62871
 */
public class SignInAction {
    
    private String soldierCode;
    private String password;
    private static final String SUCCESS_AS_GENERAL = "general";
    private static final String SUCCESS_AS_PILOT = "pilot";
    private static final String FAIL = "fail";
    public SignInAction() {
    }
    
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @return the soldierCode
     */
    public String getSoldierCode() {
        return soldierCode;
    }

    /**
     * @param soldierCode the soldierCode to set
     */
    public void setSoldierCode(String soldierCode) {
        this.soldierCode = soldierCode;
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
    
}
