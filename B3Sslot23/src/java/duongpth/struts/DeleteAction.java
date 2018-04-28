/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongpth.struts;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author DuongPTHSE62871
 */
public class DeleteAction extends ActionSupport {

    private String searchField, id;

    public DeleteAction() {
    }

    public String execute() throws Exception {
        System.out.println(searchField + " " + id);
        return SUCCESS;
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

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

}
