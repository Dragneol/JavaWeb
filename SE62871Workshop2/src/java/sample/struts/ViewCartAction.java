/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts;

import com.opensymphony.xwork2.ActionContext;
import java.util.List;
import java.util.Map;
import sample.cart.CartDAO;
import sample.cart.CartDTO;
import sample.user.UserDTO;
/**
 *
 * @author dragneol
 */
public class ViewCartAction {
    private List<CartDTO> cart;
    private float total = 0;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public ViewCartAction() {
    }
    
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        UserDTO user = (UserDTO) session.get("USER");
        if (user == null) return FAIL;
        CartDAO dao = new CartDAO();
        cart = dao.getCart(user.getUserID());
        if (cart != null)
            for (CartDTO x : cart) {
                total += x.getPrice() * x.getQuantity();
            }
        return SUCCESS;
    }

    public List<CartDTO> getCart() {
        return cart;
    }

    public float getTotal() {
        return total;
    }
    
}
