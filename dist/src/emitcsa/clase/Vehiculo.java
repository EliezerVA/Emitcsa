/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emitcsa.clase;

import emitcsa.Persis.dbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eliezer
 */
public class Vehiculo {
    private String modelo;
    private String placa;
    private String socio;

    public Vehiculo() {
    }

    public Vehiculo(String modelo, String placa, String socio) {
        this.modelo = modelo;
        this.placa = placa;
        this.socio = socio;
    }
    
    

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return the socio
     */
    public String getSocio() {
        return socio;
    }

    /**
     * @param socio the socio to set
     */
    public void setSocio(String socio) {
        this.socio = socio;
    }
    
    public boolean guardar(Vehiculo Vehiculo){
        
         Statement stm = null;
         Connection con = null;
         boolean guardar=false;
         
         String sql="INSERT INTO transporte (modelo,placas,socio) values ('"+Vehiculo.getModelo()+"','"+Vehiculo.getPlaca()+"','"+Vehiculo.getSocio()+"')";
        
         
         
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
    
    public List<Vehiculo> obtenerTo(){
        Statement stm = null;
        Connection con = null;
        ResultSet rs = null;
        
        String sql= "SELECT modelo,placas,socio FROM transporte";
        
        List<Vehiculo> vei = new ArrayList<Vehiculo>();
        
         try {
            
            con = dbConnection.con();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
                Vehiculo ve = new Vehiculo();
                ve.setModelo(rs.getString(1));
                ve.setPlaca(rs.getString(2));
                ve.setSocio(rs.getString(3));
                vei.add(ve);
                        
                
                
            }
            con.close();
            rs.close();
            stm.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return vei;
    }
    
    public List<Vehiculo> ObtenerPlaca(String socio){
        
        Statement stm = null;
        Connection con = null;
        ResultSet rs = null;
        
        String sql="SELECT placas FROM transporte WHERE socio='"+socio+"'";
        
        List<Vehiculo> vei = new ArrayList<Vehiculo>();
        
        try {
            con = dbConnection.con();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
                Vehiculo ve = new Vehiculo();
                ve.setPlaca(rs.getString(1));
                vei.add(ve);
            }
            
            con.close();
            rs.close();
            stm.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return vei;
    }
    
    
}
