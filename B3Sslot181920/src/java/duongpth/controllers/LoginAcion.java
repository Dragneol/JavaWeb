/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongpth.controllers;

import duongpth.beans.LoginActionForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author DuongPTHSE62871
 */
public class LoginAcion extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String ADMIN = "admin";
    private static final String USER = "user";
    private static final String FAIL = "fail";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String label = FAIL;
        LoginActionForm bean = (LoginActionForm) form;
        String role = bean.checkLogin();
        switch (role) {
            case "admin":
                label = ADMIN;
                break;
            case "user":
                label = USER;
                break;
            case "failed":
                request.setAttribute("ERROR", "Invalid username or password");
                break;
            default:
                request.setAttribute("ERROR", "Role not supported");
        }
        return mapping.findForward(label);
    }
}
