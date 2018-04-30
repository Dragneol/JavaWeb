/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacific.struts;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.DateRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import java.sql.Date;
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
    @Result(name = "success", type = "redirectAction", location = "robot-manipulate",
            params = {"searchField", "${searchField}"})
    ,@Result(name = "input", location = "robot-info", type = "chain")
    ,@Result(name = "error", location = "robot-info", type = "chain")
})
public class RobotUpdateAction extends ActionSupport {

    private String name;
    private String origin;
    private String classified;
    private String imgLink;
    private Date dateLauched;
    private String date;
    private int kaijuKilled;
    private boolean available;
    private String searchField;
    private String message;

    public RobotUpdateAction() {
    }

    public String execute() throws Exception {
        RobotDTO dto = new RobotDTO(name, origin, classified, imgLink, available, Date.valueOf(getDate()), kaijuKilled);
        RobotDAO dao = new RobotDAO();
        boolean updated = dao.updateByPrimaryKey(dto);
        if (updated) {
            return SUCCESS;
        } else {
            setMessage("Updation ");
            return ERROR;
        }
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
    @Validations(
            requiredStrings = {
                @RequiredStringValidator(trim = true, type = ValidatorType.FIELD, message = "This field is required")
            })
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
    @Validations(
            requiredFields = {
                @RequiredFieldValidator(type = ValidatorType.FIELD, message = "This field is required")
            },
            regexFields = {
                @RegexFieldValidator(caseSensitive = true, trim = true,
                        type = ValidatorType.FIELD, regex = "Mark-{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})",
                        message = "Classified not valid. Ex : Mark-VI")}
    )
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
     * @return the kaijuKilled
     */
    public int getKaijuKilled() {
        return kaijuKilled;
    }

    /**
     * @param kaijuKilled the kaijuKilled to set
     */
    @Validations(
            intRangeFields = @IntRangeFieldValidator(min = "1", type = ValidatorType.FIELD, message = "Invalid number"))
    public void setKaijuKilled(int kaijuKilled) {
        this.kaijuKilled = kaijuKilled;
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
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
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
