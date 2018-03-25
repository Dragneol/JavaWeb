/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngocnt.struts2;

import ngocnt.tblpet.Tbl_petDAO;

/**
 *
 * @author ngocnt
 */
public class UpdateAction {
    
    private String petId;
    private String description;
    private String vaccineDesp;
    private float price;
    private String lastSearchValue;
    
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public UpdateAction() {
    }

    public String getLastSearchValue() {
        return lastSearchValue;
    }

    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }

    
    
    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVaccineDesp() {
        return vaccineDesp;
    }

    public void setVaccineDesp(String vaccineDesp) {
        this.vaccineDesp = vaccineDesp;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
    
    public String execute() throws Exception {
        
        Tbl_petDAO dao = new Tbl_petDAO();
        boolean result = dao.updatePet(petId, description, vaccineDesp, price);
        if (result) {
            return SUCCESS;
        }
        return FAIL;

    }
    
}
