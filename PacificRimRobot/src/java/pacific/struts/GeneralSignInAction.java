/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacific.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import java.util.Map;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import pacific.daos.GeneralDAO;
import pacific.dtos.GeneralDTO;

/**
 *
 * @author DuongPTHSE62871
 */
@ResultPath("/general/")
@Results({
    @Result(name = "true", location = "index.jsp")
    ,
    @Result(name = "false", location = "login.jsp", params = {"ERROR", "${message}"})
    ,
    @Result(name = "input", location = "login.jsp")
})
public class GeneralSignInAction extends ActionSupport {

    private String username;
    private String password;
    private String message;

    public GeneralSignInAction() {
    }

    public String execute() throws Exception {
        Boolean result = false;
        GeneralDAO dao = new GeneralDAO();
        GeneralDTO dto = dao.signIn(username, password);
        if (dto != null) {
            result = true;
            Map session = ActionContext.getContext().getSession();
            session.put("AUTHORIZED", dto);
            session.put("ROLE", "GENERAL");
        } else {
            setMessage("Invalid Username or Password");
        }
        return result.toString();
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
