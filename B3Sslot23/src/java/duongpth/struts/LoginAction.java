/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongpth.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import duongpth.daos.RegistrationDAO;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author DuongPTHSE62871
 */
public class LoginAction extends ActionSupport {

    private static final String ADMIN = "admin";
    private static final String USER = "user";
    private static final String FAIL = "fail";
    private static final String INPUT = "input";
    private String username, password;

    public LoginAction() {
    }

    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        String role = dao.checkLogin(username, password);
        String label = FAIL;
        HttpServletRequest request = ServletActionContext.getRequest();
        Map session = ActionContext.getContext().getSession();
        switch (role) {
            case "admin":
                session.put("ROLE", "ADMIN");
                session.put("AUTHORIZED", username);
                label = ADMIN;
                break;
            case "user":
                session.put("ROLE", "USER");
                session.put("AUTHORIZED", username);
                label = USER;
                break;
            case "failed":
                request.setAttribute("ERROR", "Invalid Username or Password");
                break;
            default:
                request.setAttribute("ERROR", "Role is not supported");
        }
        return label;
    }

    @Override
    public void validate() {
        if (getUsername() == null || getUsername().isEmpty()) {
            addFieldError("username", "Username is Required");
        }
        if (getPassword() == null || getPassword().isEmpty()) {
            addFieldError("password", "Password is Required");
        }
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

}
