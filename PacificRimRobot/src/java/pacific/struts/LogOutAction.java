/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacific.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author DuongPTHSE62871
 */
@ResultPath("/")
@Results(
        @Result(name = "success", location = "index.jsp", type = "redirect")
)
public class LogOutAction extends ActionSupport {

    public LogOutAction() {
    }

    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        session.remove("AUTHORIZED");
        return SUCCESS;
    }

}
