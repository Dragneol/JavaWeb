/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngocnt.struts2;

import com.opensymphony.xwork2.ActionContext;
import java.util.List;
import java.util.Map;
import ngocnt.tblpet.Tbl_petDAO;
import ngocnt.tblpet.Tbl_petDTO;

/**
 *
 * @author ngocnt
 */
public class SearchAction {

    private String searchValue;
    private List<Tbl_petDTO> listPet;

    private final String SUCCESS = "success";

    public SearchAction() {
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public List<Tbl_petDTO> getListPet() {
        return listPet;
    }

    public void setListPet(List<Tbl_petDTO> listPet) {
        this.listPet = listPet;
    }

    public String execute() throws Exception {

        Tbl_petDAO dao = new Tbl_petDAO();
        Map session = ActionContext.getContext().getSession();
        String username = (String) session.get("USERNAME");

        dao.searchByRegOrUser(searchValue, username);

        listPet = dao.getListPet();

        return SUCCESS;
    }

}
