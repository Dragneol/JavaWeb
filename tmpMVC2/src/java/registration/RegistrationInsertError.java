/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day07.registration;

import java.io.Serializable;

/**
 *
 * @author dragneol
 */
public class RegistrationInsertError implements Serializable{
    private String usernameLengthErr;
    private String lastnameLengthErr;
    private String passwordLengthErr;
    private String confirmNotMatchErr;
    private String usernameExistedErr;

    public String getUsernameLengthErr() {
        return usernameLengthErr;
    }

    public String getLastnameLengthErr() {
        return lastnameLengthErr;
    }

    public String getPasswordLengthErr() {
        return passwordLengthErr;
    }

    public String getConfirmNotMatchErr() {
        return confirmNotMatchErr;
    }

    public String getUsernameExistedErr() {
        return usernameExistedErr;
    }

    public RegistrationInsertError() {
    }

    public void setUsernameLengthErr(String usernameLengthErr) {
        this.usernameLengthErr = usernameLengthErr;
    }

    public void setLastnameLengthErr(String lastnameLengthErr) {
        this.lastnameLengthErr = lastnameLengthErr;
    }

    public void setPasswordLengthErr(String passwordLengthErr) {
        this.passwordLengthErr = passwordLengthErr;
    }

    public void setConfirmNotMatchErr(String confirmNotMatchErr) {
        this.confirmNotMatchErr = confirmNotMatchErr;
    }

    public void setUsernameExistedErr(String usernameExistedErr) {
        this.usernameExistedErr = usernameExistedErr;
    }
    
}
