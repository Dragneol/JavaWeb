/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.DoubleRangeFieldValidator;
import java.util.List;
import sample.mobile.MobileDAO;
import sample.mobile.MobileDTO;
/**
 *
 * @author dragneol
 */
public class SearchPriceAction extends ActionSupport{
    private Float minPrice;
    private Float maxPrice;
    private final String SUCCESS = "success";
    private List<MobileDTO> listMobiles;
    
    public SearchPriceAction() {
    }
    
    public String execute() throws Exception {
        MobileDAO dao = new MobileDAO();
        listMobiles = dao.searchByPriceInRange(minPrice, maxPrice);
        return SUCCESS;
    }

    public Float getMinPrice() {
        return minPrice;
    }

    @DoubleRangeFieldValidator(
            minInclusive = "0",
            message = "Input value must be nonnegative"
    )
    public void setMinPrice(Float minPrice) {
        this.minPrice = minPrice;
    }

    public Float getMaxPrice() {
        return maxPrice;
    }

    @DoubleRangeFieldValidator(
            minInclusive = "0",
            message = "Input value must be nonnegative"
    )
    public void setMaxPrice(Float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public List<MobileDTO> getListMobiles() {
        return listMobiles;
    }
    
}
