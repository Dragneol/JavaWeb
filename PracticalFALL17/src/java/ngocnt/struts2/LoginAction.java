package ngocnt.struts2;


import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import ngocnt.tbluser.Tbl_userDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ngocnt
 */
public class LoginAction {
    
    private String username;
    private String password;

    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public LoginAction() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    public String execute() throws Exception {
        Tbl_userDAO dao = new Tbl_userDAO();
        boolean result = dao.checkLogin(username, password);
        if (result) {
            Map session = ActionContext.getContext().getSession();
            session.put("FULLNAME", dao.getFullName(username));
            session.put("USERNAME", username);
       
            return SUCCESS;
        }
        
        return FAIL;
        
    }
    
}
