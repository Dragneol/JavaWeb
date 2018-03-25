/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import sample.user.UserDAO;
import sample.user.UserDTO;

/**
 *
 * @author dragneol
 */
public class SigninAction extends ActionSupport{
    private String username;
    private int password;
    private String message;
    private final String SUCCESS_AS_STAFF = "successAsStaff";
    private final String SUCCESS_AS_USER = "successAsUser";
    private final String FAIL = "fail";
    
    public SigninAction() {
    }
    
    public String execute() throws Exception {
        UserDAO dao = new UserDAO();
        UserDTO user = dao.checkSignIn(username, password);
        if (user == null) {
            message = "Invalid username or password";
            return FAIL;
        }
        Map session = ActionContext.getContext().getSession();
        session.put("USER", user);
        if (user.getRole() == 0) return SUCCESS_AS_USER;
        return SUCCESS_AS_STAFF;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }
    
}
