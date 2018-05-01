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
public class PilotDTO implements Serializable {

    private String username, password, firstName, lastName, citizenship, groupCode, ranker, imgLink;
    private float weight, height;

    public PilotDTO() {
    }

    public PilotDTO(String username, String firstName, String lastName, String groupCode) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.groupCode = groupCode;
    }

    public PilotDTO(String username, String firstName, String lastName, String citizenship, String groupCode, String ranker, String imgLink, float weight, float height) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.citizenship = citizenship;
        this.groupCode = groupCode;
        this.ranker = ranker;
        this.imgLink = imgLink;
        this.weight = weight;
        this.height = height;
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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the groupCode
     */
    public String getGroupCode() {
        return groupCode;
    }

    /**
     * @param groupCode the groupCode to set
     */
    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    /**
     * @return the weight
     */
    public float getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * @return the height
     */
    public float getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(float height) {
        this.height = height;
    }
//
//    @Override
//    public String toString() {
//        return firstName + lastName;
//    }

    /**
     * @return the citizenship
     */
    public String getCitizenship() {
        return citizenship;
    }

    /**
     * @param citizenship the citizenship to set
     */
    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    /**
     * @return the ranker
     */
    public String getRanker() {
        return ranker;
    }

    /**
     * @param ranker the ranker to set
     */
    public void setRanker(String ranker) {
        this.ranker = ranker;
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
}
