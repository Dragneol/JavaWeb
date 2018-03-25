/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import java.util.Map;
import sample.cart.CartDAO;
import sample.user.UserDTO;

/**
 *
 * @author dragneol
 */
public class UpdateCartAction extends ActionSupport{
    private String mobileID;
    private int quantity;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public UpdateCartAction() {
    }
    
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        UserDTO user = (UserDTO) session.get("USER");
        if (user == null) return FAIL;
        CartDAO dao = new CartDAO();
        boolean result;
        if (quantity == 0) result = dao.removeItemInCart(user.getUserID(), mobileID);
        else result = dao.editCart(user.getUserID(), mobileID, quantity);
        return result ? SUCCESS : FAIL;
    }

    public String getMobileID() {
        return mobileID;
    }

    public void setMobileID(String mobileID) {
        this.mobileID = mobileID;
    }

    @IntRangeFieldValidator(
            min = "0"
    )
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
