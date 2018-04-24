/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duongpth.beans;

import duongpth.daos.RegistrationDAO;
import duongpth.dtos.RegistrationDTO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author DuongPTHSE62871
 */
public class SearchBean implements Serializable {

    private String search;
    private List<RegistrationDTO> list;

    public SearchBean() {
    }

    public SearchBean(String search) {
        this.search = search;
    }

    public List<RegistrationDTO> searchFullName() throws ClassNotFoundException, SQLException {
        RegistrationDAO dao = new RegistrationDAO();
        list = dao.findByLikeFullName(search);
        return list;
    }
    
    public RegistrationDTO searchPrimary() throws SQLException, ClassNotFoundException {
        RegistrationDAO dao = new RegistrationDAO();
        return dao.findByPrimaryKey(search);
    }

    /**
     * @return the search
     */
    public String getSearch() {
        return search;
    }

    /**
     * @param search the search to set
     */
    public void setSearch(String search) {
        this.search = search;
    }

    /**
     * @return the list
     */
    public List<RegistrationDTO> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<RegistrationDTO> list) {
        this.list = list;
    }

}
