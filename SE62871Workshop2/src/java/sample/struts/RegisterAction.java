/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.FieldExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import java.util.Map;
import sample.user.UserDAO;
import sample.user.UserDTO;
/**
 *
 * @author dragneol
 */
public class RegisterAction extends ActionSupport {
    private String username;
    private int password;
    private int confirm;
    private String fullname;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public RegisterAction() {
    }
    
    public String execute() throws Exception {
        UserDAO dao = new UserDAO();
        UserDTO user = dao.register(username, password, fullname);
        if (user == null) return FAIL;
        Map session = ActionContext.getContext().getSession();
        session.put("USER", user);
        return SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    @RequiredStringValidator(
            trim = true,
            message = "Username required"
    )
    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    @IntRangeFieldValidator(
            min = "100",
            message = "Password must have at least 3 numbers"
    )
    public void setPassword(int password) {
        this.password = password;
    }

    public int getConfirm() {
        return confirm;
    }

    @FieldExpressionValidator(
            expression = "confirm == password",
            message = "Confirm not matched"
    )
    public void setConfirm(int confirm) {
        this.confirm = confirm;
    }

    public String getFullname() {
        return fullname;
    }

    @RequiredStringValidator(
            trim = true,
            message = "Fullname required"
    )
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
}
