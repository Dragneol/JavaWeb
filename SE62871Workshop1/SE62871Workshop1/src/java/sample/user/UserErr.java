/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.user;

import java.io.Serializable;

/**
 *
 * @author dragneol
 */
public class UserErr implements Serializable{
    private String loginFailed;
    private String usernameIsEmpty;
    private String usernameExisted;
    private String passwordIsEmpty;
    private String passwordMustBeNumber;
    private String passwordNotMatch;
    private String fullnameIsEmpty;

    /**
     * @return the loginFailed
     */
    public String getLoginFailed() {
        return loginFailed;
    }

    /**
     * @param loginFailed the loginFailed to set
     */
    public void setLoginFailed(String loginFailed) {
        this.loginFailed = loginFailed;
    }

    /**
     * @return the usernameIsEmpty
     */
    public String getUsernameIsEmpty() {
        return usernameIsEmpty;
    }

    /**
     * @param usernameIsEmpty the usernameIsEmpty to set
     */
    public void setUsernameIsEmpty(String usernameIsEmpty) {
        this.usernameIsEmpty = usernameIsEmpty;
    }

    /**
     * @return the usernameExisted
     */
    public String getUsernameExisted() {
        return usernameExisted;
    }

    /**
     * @param usernameExisted the usernameExisted to set
     */
    public void setUsernameExisted(String usernameExisted) {
        this.usernameExisted = usernameExisted;
    }

    /**
     * @return the passwordIsEmpty
     */
    public String getPasswordIsEmpty() {
        return passwordIsEmpty;
    }

    /**
     * @param passwordIsEmpty the passwordIsEmpty to set
     */
    public void setPasswordIsEmpty(String passwordIsEmpty) {
        this.passwordIsEmpty = passwordIsEmpty;
    }

    /**
     * @return the passwordMustBeNumber
     */
    public String getPasswordMustBeNumber() {
        return passwordMustBeNumber;
    }

    /**
     * @param passwordMustBeNumber the passwordMustBeNumber to set
     */
    public void setPasswordMustBeNumber(String passwordMustBeNumber) {
        this.passwordMustBeNumber = passwordMustBeNumber;
    }

    /**
     * @return the passwordNotMatch
     */
    public String getPasswordNotMatch() {
        return passwordNotMatch;
    }

    /**
     * @param passwordNotMatch the passwordNotMatch to set
     */
    public void setPasswordNotMatch(String passwordNotMatch) {
        this.passwordNotMatch = passwordNotMatch;
    }

    /**
     * @return the fullnameIsEmpty
     */
    public String getFullnameIsEmpty() {
        return fullnameIsEmpty;
    }

    /**
     * @param fullnameIsEmpty the fullnameIsEmpty to set
     */
    public void setFullnameIsEmpty(String fullnameIsEmpty) {
        this.fullnameIsEmpty = fullnameIsEmpty;
    }
    
    
}
