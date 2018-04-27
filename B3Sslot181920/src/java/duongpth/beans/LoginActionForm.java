/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongpth.beans;

import duongpth.daos.RegistrationDAO;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author DuongPTHSE62871
 */
public class LoginActionForm extends org.apache.struts.action.ActionForm {

    private String username, password;

    public LoginActionForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String checkLogin() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        return dao.checkLogin(username, password);
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getUsername() == null || getUsername().length() < 1) {
            errors.add("username", new ActionMessage("error.username.required"));
            // TODO: add 'error.username.required' key to your resources
        }
        if (getPassword() == null || getPassword().length() < 1) {
            errors.add("password", new ActionMessage("error.password.required"));
            // TODO: add 'error.password.required' key to your resources
        }
        return errors;
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
