/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.users;

import java.io.Serializable;

/**
 *
 * @author Nguyen Duy Dat
 */
public class UsersInsertError implements Serializable{
    
    private String usernameLengthError;
    private String passwordLengthError;
    private String fullnameLengthError;
    private String confirmNotMatchedError;
    private String usernamrIsExisted;

    public UsersInsertError() {
    }

    /**
     * @return the usernameLengthError
     */
    public String getUsernameLengthError() {
        return usernameLengthError;
    }

    /**
     * @param usernameLengthError the usernameLengthError to set
     */
    public void setUsernameLengthError(String usernameLengthError) {
        this.usernameLengthError = usernameLengthError;
    }

    /**
     * @return the passwordLengthError
     */
    public String getPasswordLengthError() {
        return passwordLengthError;
    }

    /**
     * @param passwordLengthError the passwordLengthError to set
     */
    public void setPasswordLengthError(String passwordLengthError) {
        this.passwordLengthError = passwordLengthError;
    }

    /**
     * @return the fullnameLengthError
     */
    public String getFullnameLengthError() {
        return fullnameLengthError;
    }

    /**
     * @param fullnameLengthError the fullnameLengthError to set
     */
    public void setFullnameLengthError(String fullnameLengthError) {
        this.fullnameLengthError = fullnameLengthError;
    }

    /**
     * @return the confirmNotMatchedError
     */
    public String getConfirmNotMatchedError() {
        return confirmNotMatchedError;
    }

    /**
     * @param confirmNotMatchedError the confirmNotMatchedError to set
     */
    public void setConfirmNotMatchedError(String confirmNotMatchedError) {
        this.confirmNotMatchedError = confirmNotMatchedError;
    }

    /**
     * @return the usernamrIsExisted
     */
    public String getUsernamrIsExisted() {
        return usernamrIsExisted;
    }

    /**
     * @param usernamrIsExisted the usernamrIsExisted to set
     */
    public void setUsernamrIsExisted(String usernamrIsExisted) {
        this.usernamrIsExisted = usernamrIsExisted;
    }
    
    
}
