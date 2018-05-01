/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacific.struts;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author DuongPTHSE62871
 */
public class WeaponUpdateAction extends ActionSupport {

    private String weaponCode, weaponName, robotEquired, available;

    public WeaponUpdateAction() {
    }

    @Action(
            value = "/weapon-update",
            results = {
                @Result(name = "success", type = "chain")
            })
    public String execute() throws Exception {
        return SUCCESS;
    }

    /**
     * @return the weaponCode
     */
    public String getWeaponCode() {
        return weaponCode;
    }

    /**
     * @param weaponCode the weaponCode to set
     */
    public void setWeaponCode(String weaponCode) {
        this.weaponCode = weaponCode;
    }

    /**
     * @return the weaponName
     */
    public String getWeaponName() {
        return weaponName;
    }

    /**
     * @param weaponName the weaponName to set
     */
    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
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

    /**
     * @return the available
     */
    public String getAvailable() {
        return available;
    }

    /**
     * @param available the available to set
     */
    public void setAvailable(String available) {
        this.available = available;
    }

}
