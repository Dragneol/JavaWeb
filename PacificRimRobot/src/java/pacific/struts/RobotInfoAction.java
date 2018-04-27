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
@Result(name = "success", location = "roboUpdater.jsp")
)
public class RobotInfoAction extends ActionSupport {

    private String name;
    private RobotDTO dto;
    public RobotInfoAction() {
    }

    public String execute() throws Exception {
        RobotDAO dao = new RobotDAO();
        dto = dao.findByPrimaryKey(name);
        return SUCCESS;
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
     * @return the dto
     */
    public RobotDTO getDto() {
        return dto;
    }

}
