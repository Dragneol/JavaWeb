/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacific.struts;

import com.opensymphony.xwork2.ActionSupport;
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
@Results(
        @Result(name = "success", location = "roboUpdater.jsp", params = {"searchField", "${searchField}", "jeager", "${jeager}"})
)
public class RobotInfoAction extends ActionSupport {

    private String searchField;
    private String name;
    private RobotDTO jeager;

    public RobotInfoAction() {
    }

    public String execute() throws Exception {
        RobotDAO dao = new RobotDAO();
        jeager = dao.findByPrimaryKey(getName());
        return SUCCESS;
    }

    /**
     * @return the jeager
     */
    public RobotDTO getJeager() {
        return jeager;
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
