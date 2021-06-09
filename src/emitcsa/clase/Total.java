/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emitcsa.clase;

import emitcsa.Persis.dbConnection;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author Eliezer
 */
public class Total {
    private String FolioIn;
    private Double Total;

    public Total() {
    }

    public Total(String FolioIn, Double Total) {
        this.FolioIn = FolioIn;
        this.Total = Total;
    }

    /**
     * @return the FolioIn
     */
    public String getFolioIn() {
        return FolioIn;
    }

    /**
     * @param FolioIn the FolioIn to set
     */
    public void setFolioIn(String FolioIn) {
        this.FolioIn = FolioIn;
    }

    /**
     * @return the Total
     */
    public Double getTotal() {
        return Total;
    }

    /**
     * @param Total the Total to set
     */
    public void setTotal(Double Total) {
        this.Total = Total;
    }
    
    public boolean Guardar(Total Total){
        Statement stm = null;
        Connection con = null;
        boolean guardar=false;
        
        String sql ="INSERT INTO total (folioIn,total) values ('"+Total.getFolioIn()+"','"+Total.getTotal()+"')";
        try {
            con = dbConnection.con();
            stm = con.createStatement();
            stm.execute(sql);
            guardar = true;
            stm.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return guardar;
    }
    
}
