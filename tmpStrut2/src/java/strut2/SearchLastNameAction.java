/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strut2;

import java.util.List;
import registration.RegistrationDAO;
import registration.RegistrationDTO;

/**
 *
 * @author dragneol
 */
public class SearchLastNameAction {

    private String searchValue;
    private List<RegistrationDTO> listResult;
    private String SUCCESS = "success";
    private String FAIL = "fail";

    public SearchLastNameAction() {
    }

    public String execute() throws Exception {

        RegistrationDAO dao = new RegistrationDAO();
        dao.searchLikeLastName(getSearchValue());
        System.out.println(dao);
        setListResult(dao.getList());

//        System.out.println(dao.getList());
        
//        if (listResult.isEmpty()) {
//            return FAIL;
//        } else {
            return getSUCCESS();
//        }
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
     * @return the SUCCESS
     */
    public String getSUCCESS() {
        return SUCCESS;
    }

    /**
     * @param SUCCESS the SUCCESS to set
     */
    public void setSUCCESS(String SUCCESS) {
        this.SUCCESS = SUCCESS;
    }

    /**
     * @return the FAIL
     */
    public String getFAIL() {
        return FAIL;
    }

    /**
     * @param FAIL the FAIL to set
     */
    public void setFAIL(String FAIL) {
        this.FAIL = FAIL;
    }

    /**
     * @return the listResult
     */
    public List<RegistrationDTO> getListResult() {
        return listResult;
    }

    /**
     * @param listResult the listResult to set
     */
    public void setListResult(List<RegistrationDTO> listResult) {
        this.listResult = listResult;
    }

}
