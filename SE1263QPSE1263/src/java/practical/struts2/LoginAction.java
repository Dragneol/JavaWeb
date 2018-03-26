/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical.struts2;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import practical.tbl_Customer.tbl_CustomerDAO;

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
        tbl_CustomerDAO dao = new tbl_CustomerDAO();
        Boolean isSigned = dao.checkLogin(username, password);
        if (isSigned) {
            Map session = ActionContext.getContext().getSession();
            session.put("ACCOUNT", username);
        }
        return isSigned.toString();
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
