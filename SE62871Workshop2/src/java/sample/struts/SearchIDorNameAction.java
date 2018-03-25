/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts;

import java.util.List;
import sample.mobile.MobileDAO;
import sample.mobile.MobileDTO;

/**
 *
 * @author dragneol
 */
public class SearchIDorNameAction {
    private String searchValue;
    private final String SUCCESS = "success";
    private List<MobileDTO> listMobiles;
    
    public SearchIDorNameAction() {
    }
    
    public String execute() throws Exception {
        MobileDAO dao = new MobileDAO();
        listMobiles = dao.searchByIdOrName(searchValue);
        return SUCCESS;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public List<MobileDTO> getListMobiles() {
        return listMobiles;
    }
    
}
