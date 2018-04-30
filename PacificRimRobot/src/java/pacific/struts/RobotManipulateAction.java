/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacific.struts;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import java.util.List;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import pacific.daos.RobotDAO;
import pacific.dtos.RobotDTO;

/**
 *
 * @author DuongPTHSE62871
 */
@ResultPath("/general/")
@Results({
    @Result(name = "success", location = "robotManaged.jsp", params = {"searchField", "${searchField}"})
    ,@Result(name = "input", location = "robotManaged.jsp", params = {"searchField", "${searchField}"})

}
)
public class RobotManipulateAction extends ActionSupport {

    private String searchField;
    private String message = "";
    private List<RobotDTO> list;

    public RobotManipulateAction() {
    }

    public String execute() throws Exception {
        System.out.println(searchField);
        RobotDAO dao = new RobotDAO();
        list = dao.findByLikeName(getSearchField());
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
    @RequiredStringValidator(message = "Please type something")
    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

    /**
     * @return the list
     */
    public List<RobotDTO> getList() {
        return list;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

}
