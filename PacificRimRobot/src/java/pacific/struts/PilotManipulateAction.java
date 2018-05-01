/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacific.struts;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import java.util.List;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import pacific.daos.PilotDAO;
import pacific.dtos.PilotDTO;

/**
 *
 * @author DuongPTHSE62871
 */
public class PilotManipulateAction extends ActionSupport {

    private String searchField, message = "";
    private List<PilotDTO> list;

    public PilotManipulateAction() {
    }

    @Action(
            value = "pilot-manipulate",
            results = {
                @Result(name = "success", location = "/general/pilotManaged.jsp", params = {"searchField", "${searchField}"})
                ,
                @Result(name = "input", location = "/general/pilotManaged.jsp", params = {"searchField", "${searchField}"})
            }
    )
    public String execute() throws Exception {
        PilotDAO dao = new PilotDAO();
        list = dao.findByName(searchField);
        if (list.isEmpty()) {
            message = "No record found";
        }
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
    @RequiredStringValidator(fieldName = "searchField", type = ValidatorType.FIELD, message = "Please type something")
    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

    /**
     * @return the list
     */
    public List<PilotDTO> getList() {
        return list;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

}
