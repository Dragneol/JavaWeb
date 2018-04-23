/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongpth.dtos;

import java.io.Serializable;

/**
 *
 * @author DuongPTHSE62871
 */
public class RegistrationErrorObj implements Serializable {

    private String usernameError, passwordError;
    private String confirmError, fullnameError, roleError;
    public RegistrationErrorObj() {
    }

    /**
     * @return the usernameError
     */
    public String getUsernameError() {
        return usernameError;
    }

    /**
     * @param usernameError the usernameError to set
     */
    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    /**
     * @return the passwordError
     */
    public String getPasswordError() {
        return passwordError;
    }

    /**
     * @param passwordError the passwordError to set
     */
    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    /**
     * @return the confirmError
     */
    public String getConfirmError() {
        return confirmError;
    }

    /**
     * @param confirmError the confirmError to set
     */
    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }

    /**
     * @return the fullnameError
     */
    public String getFullnameError() {
        return fullnameError;
    }

    /**
     * @param fullnameError the fullnameError to set
     */
    public void setFullnameError(String fullnameError) {
        this.fullnameError = fullnameError;
    }

    /**
     * @return the roleError
     */
    public String getRoleError() {
        return roleError;
    }

    /**
     * @param roleError the roleError to set
     */
    public void setRoleError(String roleError) {
        this.roleError = roleError;
    }

}
