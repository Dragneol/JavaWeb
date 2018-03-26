/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical.struts2;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;

/**
 *
 * @author Dragneol
 */
public class LogoutAction {

    private final String SUCCESS = "success";

    public LogoutAction() {
    }

    public String execute() throws Exception {
        ActionContext.getContext().setSession(null);
        return SUCCESS;
    }

}
