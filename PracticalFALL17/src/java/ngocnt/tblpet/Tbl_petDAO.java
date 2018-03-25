/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngocnt.tblpet;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import ngocnt.utils.DBUtils;

/**
 *
 * @author ngocnt
 */
public class Tbl_petDAO implements Serializable {

    private List<Tbl_petDTO> listPet;

    public List<Tbl_petDTO> getListPet() {
        return listPet;
    }

    public void setListPet(List<Tbl_petDTO> listPet) {
        this.listPet = listPet;
    }

    public void searchByRegOrUser(String searchValue, String username) throws SQLException, NamingException {
    
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {

            con = DBUtils.makeConnection();
            String sql = "Select * From tbl_Pet Where approveReg=? and userId=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, searchValue);
            stmt.setString(2, username);
            rs = stmt.executeQuery();
            while (rs.next()) {

                String petId = rs.getString("petId");
                String petName = rs.getString("petName");
                String description = rs.getString("description");
                Timestamp dob = rs.getTimestamp("dob");
                String vaccineDesp = rs.getString("vaccineDesp");
                float price = rs.getFloat("price");
                Timestamp registerDate = rs.getTimestamp("registerDate");
                int approveReg = rs.getInt("approveReg");
                String userId = rs.getString("userId");
                
                if (listPet == null) {
                    listPet = new ArrayList<>();
                }
                listPet.add(new Tbl_petDTO(petId, petName, description, dob, vaccineDesp, price, registerDate, approveReg, userId));
                System.out.println(listPet.size());
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    public void searchAll(String username) throws SQLException, NamingException {
    
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {

            con = DBUtils.makeConnection();
            String sql = "Select * From tbl_Pet Whereand userId=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            while (rs.next()) {

                String petId = rs.getString("petId");
                String petName = rs.getString("petName");
                String description = rs.getString("description");
                Timestamp dob = rs.getTimestamp("dob");
                String vaccineDesp = rs.getString("vaccineDesp");
                float price = rs.getFloat("price");
                Timestamp registerDate = rs.getTimestamp("registerDate");
                int approveReg = rs.getInt("approveReg");
                String userId = rs.getString("userId");
                
                if (listPet == null) {
                    listPet = new ArrayList<>();
                }
                listPet.add(new Tbl_petDTO(petId, petName, description, dob, vaccineDesp, price, registerDate, approveReg, userId));
                System.out.println(listPet.size());
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    
    
    public boolean updatePet(String petId, String description, String vaccineDesp, float price) throws SQLException, NamingException{
        
        Connection con = null;
        PreparedStatement stmt = null;
        
        try{
            
            con = DBUtils.makeConnection();
            String sql = "Update tbl_Pet Set description=?, vaccineDesp=?, price=?, registerDate=GETDATE(), approveReg=0 "
                    + "where petId=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, description);            
            stmt.setString(2, vaccineDesp);
            stmt.setFloat(3, price);
            stmt.setString(4, petId);
            int result = stmt.executeUpdate();
            if (result > 0) {
                return true;
            }
            
        }finally{
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
        
    }
    
}
