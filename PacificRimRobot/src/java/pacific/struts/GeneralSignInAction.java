/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacific.struts;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author DuongPTHSE62871
 */
@ResultPath("/")
@Results({
    @Result(name = "true", location = "general.jsp")
    ,
    @Result(name = "false", location = "generalLogin.jsp", params = {"ERROR", "${message}"})
    ,
    @Result(name = "input", location = "generalLogin.jsp")
})
public class GeneralSignInAction extends ActionSupport {

    private String username;
    private String password;
    private String message;

    public GeneralSignInAction() {
    }

    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
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
    @RequiredStringValidator(message = "Username is required")
    @StringLengthFieldValidator(maxLength = "50", message = "Acceptable length is 50 character")
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
    @RequiredStringValidator(message = "Password is required")
    @StringLengthFieldValidator(maxLength = "50", message = "Acceptable length is 50 character")
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
