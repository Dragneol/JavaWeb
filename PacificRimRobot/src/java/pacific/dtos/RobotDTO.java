/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacific.dtos;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author DuongPTHSE62871
 */
public class RobotDTO implements Serializable {

    private String name, origin, classified, imgLink;
    private boolean available;
    private Date dateLauched;
    private int kaijuKilled;

    public RobotDTO(String name, String origin, String classified, String imgLink, boolean available, Date dateLauched, int kaijuKilled) {
        this.name = name;
        this.origin = origin;
        this.classified = classified;
        this.imgLink = imgLink;
        this.available = available;
        this.dateLauched = dateLauched;
        this.kaijuKilled = kaijuKilled;
    }

    public RobotDTO(String name, String imgLink, boolean available) {
        this.name = name;
        this.imgLink = imgLink;
        this.available = available;
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
     * @return the origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * @param origin the origin to set
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * @return the classified
     */
    public String getClassified() {
        return classified;
    }

    /**
     * @param classified the classified to set
     */
    public void setClassified(String classified) {
        this.classified = classified;
    }

    /**
     * @return the imgLink
     */
    public String getImgLink() {
        return imgLink;
    }

    /**
     * @param imgLink the imgLink to set
     */
    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
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
     * @return the dateLauched
     */
    public Date getDateLauched() {
        return dateLauched;
    }

    /**
     * @param dateLauched the dateLauched to set
     */
    public void setDateLauched(Date dateLauched) {
        this.dateLauched = dateLauched;
    }

    /**
     * @return the kaijuKilled
     */
    public int getKaijuKilled() {
        return kaijuKilled;
    }

    /**
     * @param kaijuKilled the kaijuKilled to set
     */
    public void setKaijuKilled(int kaijuKilled) {
        this.kaijuKilled = kaijuKilled;
    }
}
