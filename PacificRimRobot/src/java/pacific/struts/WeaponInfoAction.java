/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacific.struts;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import pacific.daos.RobotDAO;
import pacific.daos.WeaponDAO;
import pacific.dtos.WeaponDTO;

/**
 *
 * @author DuongPTHSE62871
 */
public class WeaponInfoAction extends ActionSupport {

    private String id;
    private String searchField;
    private WeaponDTO weapon;
    private List<String> robot;
    private String robotEquired;

    public WeaponInfoAction() {
    }

    @Action(
            value = "/weapon-info",
            results = {
                @Result(name = "success", location = "/general/weaponInfo.jsp",
                        params = {
                            "searchField", "${searchField}",
                            "weapon", "${weapon}"})
            }
    )
    public String execute() throws Exception {
        RobotDAO jeager = new RobotDAO();
        robot = jeager.getAllRobot();
        WeaponDAO dao = new WeaponDAO();
        weapon = dao.findByPrimaryKey(id);
        setRobotEquired(dao.getRoboByEquiment(id));
        return SUCCESS;
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
     * @return the weapon
     */
    public WeaponDTO getWeapon() {
        return weapon;
    }

    /**
     * @return the robot
     */
    public List<String> getRobot() {
        return robot;
    }

    /**
     * @return the robotEquired
     */
    public String getRobotEquired() {
        return robotEquired;
    }

    /**
     * @param robotEquired the robotEquired to set
     */
    public void setRobotEquired(String robotEquired) {
        this.robotEquired = robotEquired;
    }

}
