/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical.struts2;

import com.opensymphony.xwork2.ActionContext;
import java.util.List;
import java.util.Map;
import practical.tbl_Book.tbl_BookDAO;

/**
 *
 * @author Dragneol
 */
public class SearchAction {

    private final String SUCCESS = "success";
    private String searchValue;

    public SearchAction() {
    }

    public String execute() throws Exception {
        tbl_BookDAO dao = new tbl_BookDAO();
        List result = dao.searchTitle(searchValue);
        if (result != null) {
            Map session = ActionContext.getContext().getSession();
            session.put("LISTSEARCH", result);
//            System.out.println("Have result");
        }
        return SUCCESS;
    }

    /**
     * @return the searchValue
     */
    public String getSearchValue() {
        return searchValue;
    }

    /**
     * @param searchValue the searchValue to set
     */
    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

}
