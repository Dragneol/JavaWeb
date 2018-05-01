/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacific.struts;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import pacific.daos.RobotDAO;
import pacific.dtos.RobotDTO;
import pacific.dtos.Skill;

/**
 *
 * @author DuongPTHSE62871
 */
@ResultPath("/")
@Results(
        @Result(name = "success", location = "general/roboUpdater.jsp", params = {"searchField", "${searchField}", "jeager", "${jeager}"})
)
public class RobotInfoAction extends ActionSupport {

    private String searchField;
    private String name;
    private RobotDTO jeager;
    private List<Skill> skills;

    public RobotInfoAction() {
    }

    public String execute() throws Exception {
        RobotDAO dao = new RobotDAO();
        jeager = dao.findByPrimaryKey(getName());
        skills = dao.getAllSkillName();
        return SUCCESS;
    }

    @Actions(
            @Action(
                    value = "view-detail",
                    results = {
                        @Result(location = "pilot/robotDetail.jsp", name = "success")
                    }
            )
    )
    public String viewDetail() throws Exception {
        RobotDAO dao = new RobotDAO();
        jeager = dao.findByPrimaryKey(name);
        skills = dao.getAllSkillName();
        skills = dao.getSkillOf(jeager.getName(), getSkills());
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

    /**
     * @return the skills
     */
    public List<Skill> getSkills() {
        return skills;
    }

    /**
     * @param skills the skills to set
     */
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

}
