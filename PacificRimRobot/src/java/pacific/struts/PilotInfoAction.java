/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacific.struts;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Result;
import pacific.daos.PilotDAO;
import pacific.dtos.PilotDTO;
import pacific.dtos.Skill;

/**
 *
 * @author DuongPTHSE62871
 */
public class PilotInfoAction extends ActionSupport {

    private String username, searchField;
    private List<Skill> skills;
    private PilotDTO pilot;

    public PilotInfoAction() {
    }

    @Action(
            value = "pilot-info",
            exceptionMappings = {
                @ExceptionMapping(
                        exception = "java.lang.Exception",
                        result = "error")
            },
            results = {
                @Result(name = "success", location = "/general/pilotUpdapter.jsp",
                        params = {
                            "pilot", "${pilot}",
                            "searchField", "${searchField}"
                        })
                ,
                @Result(name = "error", location = "/error.jsp")
            }
    )
    public String execute() throws Exception {
        PilotDAO dao = new PilotDAO();
        setPilot(dao.findByPrimaryKey(username));
        setSkills(dao.getAllSkillName());
        setSkills(dao.getSkillOf(username, skills));
        return SUCCESS;
    }

    @Action(
            value = "pilot-detail",
            exceptionMappings = {
                @ExceptionMapping(
                        exception = "java.lang.Exception",
                        result = "error")
            },
            results = {
                @Result(name = "success", location = "/pilot/pilotInfo.jsp", params = {"pilot", "${pilot}"})
                ,
                @Result(name = "error", location = "/error.jsp")
            }
    )
    public String view() throws Exception {
        PilotDAO dao = new PilotDAO();
        setPilot(dao.findByUsername(username));
        setSkills(dao.getAllSkillName());
        setSkills(dao.getSkillOf(username, skills));
        return SUCCESS;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the pilot
     */
    public PilotDTO getPilot() {
        return pilot;
    }

    /**
     * @param pilot the pilot to set
     */
    public void setPilot(PilotDTO pilot) {
        this.pilot = pilot;
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
