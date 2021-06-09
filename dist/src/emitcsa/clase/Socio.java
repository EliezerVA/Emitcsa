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
public class Socio {
    
    private String nombre;
    private String telefono;
    private String RFC;
    private String DomiFis;
   
    

    public Socio() {
    }

    public Socio(String nombre, String telefono, String RFC, String DomiFis) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.RFC = RFC;
        this.DomiFis = DomiFis;
    }

    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the RFC
     */
    public String getRFC() {
        return RFC;
    }

    /**
     * @param RFC the RFC to set
     */
    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    /**
     * @return the DomiFis
     */
    public String getDomiFis() {
        return DomiFis;
    }

    /**
     * @param DomiFis the DomiFis to set
     */
    public void setDomiFis(String DomiFis) {
        this.DomiFis = DomiFis;
    }
    
    
    
    
    public boolean  guardar(Socio Socio){
         Statement stm = null;
         Connection con = null;
         boolean guardar=false;
         
         String sql="INSERT INTO socio (nombre,telefono,rfc,direccionFis) values ('"+Socio.getNombre()+"','"+Socio.getTelefono()+"','"+Socio.getRFC()+"','"+Socio.getDomiFis()+"')";
        
         
         
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

    public List<Socio> obtenerTodo(){
        Statement stm = null;
        Connection con = null;
        ResultSet rs = null;
        
        String sql= "SELECT nombre FROM socio";
        
        List<Socio> listanom = new ArrayList<Socio>();
        
        try {
            
            con = dbConnection.con();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
                Socio so = new Socio();
                so.setNombre(rs.getString(1));
                listanom.add(so);
            }
            con.close();
            rs.close();
            stm.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listanom;
    }
    
    public List<Socio> obtenerTodo2(){
        Statement stm = null;
        Connection con = null;
        ResultSet rs = null;
        
        String sql= "SELECT nombre,telefono,rfc,direccionFis FROM socio";
        
        List<Socio> listodo = new ArrayList<Socio>();
        
        try {
            
            con = dbConnection.con();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
                Socio so = new Socio();
                so.setNombre(rs.getString(1));
                so.setTelefono(rs.getString(2));
                so.setRFC(rs.getString(3));
                so.setDomiFis(rs.getString(4));
                listodo.add(so);
            }
            con.close();
            rs.close();
            stm.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listodo;
    }
   
   
   
    
}
