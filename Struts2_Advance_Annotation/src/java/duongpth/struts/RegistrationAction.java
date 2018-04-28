/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongpth.struts;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.FieldExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author DuongPTHSE62871
 */
public class RegistrationAction extends ActionSupport {

    private String username, password, confirm, fullname, email, phone;

    public RegistrationAction() {
    }

    public String execute() throws Exception {
        System.out.println("execute");
        return SUCCESS;
    }

    @Action(
            value = "/registration",
            exceptionMappings = {
                @ExceptionMapping(
                        exception = "com.microsoft.sqlserver.jdbc.SQLServerException",
                        result = "input")
            },
            results = {
                @Result(name = "success", location = "/success.jsp")
                ,
                @Result(name = "input", location = "/index.jsp")
            })
    public String insert() throws Exception {
        System.out.println("insert");
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
    @Validations(
            requiredStrings = {
                @RequiredStringValidator(type = ValidatorType.FIELD, key = "username.required")
            },
            stringLengthFields = {
                @StringLengthFieldValidator(type = ValidatorType.FIELD, minLength = "6", maxLength = "30",
                        message = "Username must be 6 to 30 chars")
            }
    )
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
    @Validations(
            requiredStrings = {
                @RequiredStringValidator(type = ValidatorType.FIELD, message = "Password is required")
            },
            stringLengthFields = {
                @StringLengthFieldValidator(type = ValidatorType.FIELD, minLength = "6", maxLength = "30",
                        message = "Password must be 6 to 30 chars")
            }
    )
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    @RequiredStringValidator(type = ValidatorType.FIELD, message = "Fullname is required")
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    @RegexFieldValidator(type = ValidatorType.FIELD, regex = "\\d{4}-\\d{7}", message = "Phone No invalid")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the confirm
     */
    public String getConfirm() {
        return confirm;
    }

    /**
     * @param confirm the confirm to set
     */
    @FieldExpressionValidator(expression = "confirm==password", message = "Confirm not match")
    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

}
