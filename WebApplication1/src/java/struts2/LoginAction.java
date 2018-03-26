/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struts2;

import User.UserDAO;
import com.opensymphony.xwork2.ActionContext;
import java.util.Map;

/**
 *
 * @author Dragneol
 */
public class LoginAction {

    private String username;
    private String password;

    public LoginAction() {
    }

    public String execute() throws Exception {
        UserDAO dao = new UserDAO();
        Boolean signed = dao.checkLogin(username, password);
        if (signed) {
            System.out.println("foo");
            Map session = ActionContext.getContext().getSession();
            session.put("USERNAME", username);
        }
        return signed.toString();
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
