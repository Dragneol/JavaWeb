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
import pacific.daos.PilotDAO;
import pacific.dtos.PilotDTO;

/**
 *
 * @author DuongPTHSE62871
 */
@ResultPath("/")
@Results({
    @Result(name = "true", location = "pilot/index.jsp")
    ,
    @Result(name = "false", location = "pilot/login.jsp", params = {"ERROR", "${message}"})
    ,
    @Result(name = "input", location = "pilot/login.jsp")
})
public class PilotSignInAction extends ActionSupport {

    private String username, password, message;

    public PilotSignInAction() {
    }

    public String execute() throws Exception {
        PilotDAO dao = new PilotDAO();
        PilotDTO dto = dao.signIn(getUsername(), getPassword());
        Boolean result = false;
        if (dto != null) {
            result = true;
            Map session = ActionContext.getContext().getSession();
            session.put("AUTHORIZED", dto);
            session.put("ROLE", "PILOT");
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
