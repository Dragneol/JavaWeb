/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacific.struts;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import java.util.List;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import pacific.daos.WeaponDAO;
import pacific.dtos.WeaponDTO;

/**
 *
 * @author DuongPTHSE62871
 */
@Namespace("/")
public class WeaponManipulateAction extends ActionSupport {

    private String searchField;
    private List<WeaponDTO> list;
    private String message = "";
    public WeaponManipulateAction() {
    }

    
    @Action(
            value = "weapon-manipulate",
            results = {            
                @Result(name = "input", location = "/general/weaponManaged.jsp", params = {"searchField", "${searchField}"}),
                @Result(name = "success", location = "/general/weaponManaged.jsp", params = {"searchField", "${searchField}"})
            }
    )
    public String execute() throws Exception {
        WeaponDAO dao = new WeaponDAO();
        setList(dao.findByLikeName(getSearchField()));
        if (list.isEmpty()) {
           message = "No record found";
           return INPUT;
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
    @Validations(
            requiredStrings = {
                @RequiredStringValidator(type = ValidatorType.FIELD, fieldName = "searchField", trim = true, message = "Please type something")
            })
    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

    /**
     * @return the list
     */
    public List<WeaponDTO> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<WeaponDTO> list) {
        this.list = list;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

}
