/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongpth.struts;

import com.opensymphony.xwork2.ActionSupport;
import duongpth.daos.RegistrationDAO;
import duongpth.dtos.RegistrationDTO;
import java.util.List;

/**
 *
 * @author DuongPTHSE62871
 */
public class SearchAction extends ActionSupport {

    private String searchField;
    private List<RegistrationDTO> list;

    public SearchAction() {
    }

    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        list = dao.findByLikeFullName(searchField);
        return SUCCESS;
    }

    /**
     * @return the list
     */
    public List<RegistrationDTO> getList() {
        return list;
    }

    /**
     * @return the searchField
     */
    public String getSearchField() {
        return searchField;
    }

    /**
     * @param searchField the searchField to set
     */
    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

}
