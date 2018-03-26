/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongpth.tbl_User;

import java.io.Serializable;

/**
 *
 * @author dragneol
 */
public class UserErr implements Serializable{
    private String invalidUsernameOrPassword;

    private String usernameIsEmpty;
    private String usernameExisted;
    private String passwordIsEmpty;
    private String passwordMustBeNumber;
    private String passwordNotMatch;
    private String fullnameIsEmpty;
    
    public String getInvalidUsernameOrPassword() {
        return invalidUsernameOrPassword;
    }

    public void setInvalidUsernameOrPassword(String invalidUsernameOrPassword) {
        this.invalidUsernameOrPassword = invalidUsernameOrPassword;
    }

    public String getUsernameIsEmpty() {
        return usernameIsEmpty;
    }

    public void setUsernameIsEmpty(String usernameIsEmpty) {
        this.usernameIsEmpty = usernameIsEmpty;
    }

    public String getUsernameExisted() {
        return usernameExisted;
    }

    public void setUsernameExisted(String usernameExisted) {
        this.usernameExisted = usernameExisted;
    }

    public String getPasswordIsEmpty() {
        return passwordIsEmpty;
    }

    public void setPasswordIsEmpty(String passwordIsEmpty) {
        this.passwordIsEmpty = passwordIsEmpty;
    }

    public String getPasswordMustBeNumber() {
        return passwordMustBeNumber;
    }

    public void setPasswordMustBeNumber(String passwordMustBeNumber) {
        this.passwordMustBeNumber = passwordMustBeNumber;
    }
    
    public String getPasswordNotMatch() {
        return passwordNotMatch;
    }

    public void setPasswordNotMatch(String passwordNotMatch) {
        this.passwordNotMatch = passwordNotMatch;
    }

    public String getFullnameIsEmpty() {
        return fullnameIsEmpty;
    }

    public void setFullnameIsEmpty(String fullnameIsEmpty) {
        this.fullnameIsEmpty = fullnameIsEmpty;
    }
    
}
