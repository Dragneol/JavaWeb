/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import sample.cart.CartDAO;
import sample.user.UserDTO;
/**
 *
 * @author dragneol
 */
public class DeleteFromCartAction {
    private String mobileID;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public DeleteFromCartAction() {
    }
    
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        UserDTO user = (UserDTO) session.get("USER");
        if (user == null) return FAIL;
        CartDAO dao = new CartDAO();
        boolean result = dao.removeItemInCart(user.getUserID(), mobileID);
        return result ? SUCCESS : FAIL;
    }

    public String getMobileID() {
        return mobileID;
    }

    public void setMobileID(String mobileID) {
        this.mobileID = mobileID;
    }
    
}
