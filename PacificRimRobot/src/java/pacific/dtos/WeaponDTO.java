/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacific.dtos;

import java.io.Serializable;

/**
 *
 * @author DuongPTHSE62871
 */
public class WeaponDTO implements Serializable {

    private String weaponCode, battleTypeId, weaponName;
    private boolean available, carriable;

    public WeaponDTO() {
    }

    public WeaponDTO(String weaponCode, String weaponName, boolean available, boolean carriable) {
        this.weaponCode = weaponCode;
        this.weaponName = weaponName;
        this.available = available;
        this.carriable = carriable;
    }

    public WeaponDTO(String weaponCode, String weaponName) {
        this.weaponCode = weaponCode;
        this.weaponName = weaponName;
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
     * @return the battleTypeId
     */
    public String getBattleTypeId() {
        return battleTypeId;
    }

    /**
     * @param battleTypeId the battleTypeId to set
     */
    public void setBattleTypeId(String battleTypeId) {
        this.battleTypeId = battleTypeId;
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
     * @return the available
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * @param available the available to set
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * @return the carriable
     */
    public boolean isCarriable() {
        return carriable;
    }

    /**
     * @param carriable the carriable to set
     */
    public void setCarriable(boolean carriable) {
        this.carriable = carriable;
    }
}
