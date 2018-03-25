/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samples.struts.search;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import registration.RegistrationDAO;
import registration.RegistrationDTO;

/**
 *
 * @author dragneol
 */
public class SearchLastNameStrutsActionForm extends org.apache.struts.action.ActionForm {

    private String searchValue;
    private List<RegistrationDTO> listAccount;

    /**
     *
     */
    public SearchLastNameStrutsActionForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the searchValue
     */
    public String getSearchValue() {
        return searchValue;
    }

    /**
     * @param searchValue the searchValue to set
     */
    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public void seachLastName() {
        try {
            RegistrationDAO dao = new RegistrationDAO();
            dao.searchLikeLastName(getSearchValue());
            setListAccount(dao.getList());
        } catch (NamingException ex) {
            Logger.getLogger(SearchLastNameStrutsActionForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SearchLastNameStrutsActionForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the listAccount
     */
    public List<RegistrationDTO> getListAccount() {
        return listAccount;
    }

    /**
     * @param listAccount the listAccount to set
     */
    public void setListAccount(List<RegistrationDTO> listAccount) {
        this.listAccount = listAccount;
    }
}
