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
public class Datos {
    private String producto;
    private Double precio;
    private Double TonOrigen;
    private Double TonDest;
    private Double Merma;
    private Double Importe;
    private String Folio;
    private String FolioIn;
    private String Placas;
    private String Chofer;
    private String propietario;

    public Datos() {
    }

    public Datos(String producto, Double precio, Double TonOrigen, Double TonDest, Double Merma, Double Importe, String Folio, String FolioIn, String Placas, String Chofer, String propietario) {
        this.producto = producto;
        this.precio = precio;
        this.TonOrigen = TonOrigen;
        this.TonDest = TonDest;
        this.Merma = Merma;
        this.Importe = Importe;
        this.Folio = Folio;
        this.FolioIn = FolioIn;
        this.Placas = Placas;
        this.Chofer = Chofer;
        this.propietario = propietario;
    }

    /**
     * @return the producto
     */
    public String getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     * @return the precio
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * @return the TonOrigen
     */
    public Double getTonOrigen() {
        return TonOrigen;
    }

    /**
     * @param TonOrigen the TonOrigen to set
     */
    public void setTonOrigen(Double TonOrigen) {
        this.TonOrigen = TonOrigen;
    }

    /**
     * @return the TonDest
     */
    public Double getTonDest() {
        return TonDest;
    }

    /**
     * @param TonDest the TonDest to set
     */
    public void setTonDest(Double TonDest) {
        this.TonDest = TonDest;
    }

    /**
     * @return the Merma
     */
    public Double getMerma() {
        return Merma;
    }

    /**
     * @param Merma the Merma to set
     */
    public void setMerma(Double Merma) {
        this.Merma = Merma;
    }

    /**
     * @return the Importe
     */
    public Double getImporte() {
        return Importe;
    }

    /**
     * @param Importe the Importe to set
     */
    public void setImporte(Double Importe) {
        this.Importe = Importe;
    }

    /**
     * @return the Folio
     */
    public String getFolio() {
        return Folio;
    }

    /**
     * @param Folio the Folio to set
     */
    public void setFolio(String Folio) {
        this.Folio = Folio;
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
     * @return the Placas
     */
    public String getPlacas() {
        return Placas;
    }

    /**
     * @param Placas the Placas to set
     */
    public void setPlacas(String Placas) {
        this.Placas = Placas;
    }

    /**
     * @return the Chofer
     */
    public String getChofer() {
        return Chofer;
    }

    /**
     * @param Chofer the Chofer to set
     */
    public void setChofer(String Chofer) {
        this.Chofer = Chofer;
    }

    /**
     * @return the propietario
     */
    public String getPropietario() {
        return propietario;
    }

    /**
     * @param propietario the propietario to set
     */
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
    
    
    
    public boolean Guardar(Datos Datos){
        Statement stm = null;
        Connection con = null;
        boolean guardar=false;
        
        String sql ="INSERT INTO datos (producto,precio,TonOrigen,TonDes,merma,importe,folio,folioIn,placas,Chofer,propietario) values ('"+Datos.getProducto()+"','"+Datos.getPrecio()+"','"+Datos.getTonOrigen()+"','"+Datos.getTonDest()+"','"+Datos.getMerma()+"','"+Datos.getImporte()+"','"+Datos.getFolio()+"','"+Datos.getFolioIn()+"','"+Datos.getPlacas()+"','"+Datos.getChofer()+"','"+Datos.getPropietario()+"')";
        
        try {
            con = dbConnection.con();
            stm = con.createStatement();
            stm.execute(sql);
            guardar = true;
            stm.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return guardar;
    }
    
}
