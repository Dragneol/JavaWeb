/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacific.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpSession;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author DuongPTHSE62871
 */
public class BackToRoleAction extends ActionSupport {

    public BackToRoleAction() {
    }

    @Action(
            value = "main-page",
            results = {
                @Result(name = "general", location = "/general/index.jsp")
                ,
                @Result(name = "pilot", location = "/pilot/index.jsp")
                ,
                @Result(name = "login", location = "index.jsp")
            })
    public String execute() throws Exception {
        String role = (String) ActionContext.getContext().getSession().get("ROLE");
        if (role != null) {
            role = role.toLowerCase();
            return role;
        }
        return LOGIN;
    }

}
