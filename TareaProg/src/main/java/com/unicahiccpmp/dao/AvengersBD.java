/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicahiccpmp.dao;

import com.mycompany.tarealprog.AvengersItem;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Jessie Gaboriell
 */


public class AvengersBD {
    
    private ArrayList<AvengersItem> avengerItem = null;
   
    //consstructor
    public AvengersBD(){
        this.avengerItem =  new ArrayList<AvengersItem>();
        
    }
    
    //Polimorfismo
    /*
    Porque le metodo esta en la misma clase.
    */
    public ArrayList<AvengersItem> getAvengerItem(){
        return this.getAvengerItem(false);
    }
    
    public void TableInitialize(){
        String sqlCreate = "CREATE TABLE IF NOT EXISTS AVENGERS"
                + "(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + "NOMBRE TEXT NOR NULL, "
                + "NOMBRE_SUPER TEXT NOT NULL,"
                + "EDAD INTEGER NOT NULL, "
                + "PODER TEXT NOT NULL, "
                + "ALTURA INTEGER NOT NULL"
                + ")";
        try{
            Statement comando = Conexion.getConexion().createStatement();
            int resultado = comando.executeUpdate(sqlCreate);
            comando.close();
            
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public ArrayList<AvengersItem> getAvengerItem(boolean forceload){
        try{
            if(forceload){
                Statement comando = Conexion.getConexion().createStatement();
                ResultSet misRegistro = comando.executeQuery("SELECT * from AVENGERS;");
                this.avengerItem.clear();
                /*
                DEVUELVE UN CURSOR.
                Para ejecutarlo usamos executeUpdate.
                */

                //Ahora ocupamos obtener e ir integrando por cada uno 
                //de los elementos.

                while(misRegistro.next()){
                    AvengersItem registro = new AvengersItem();

                    registro.setId(misRegistro.getInt("ID"));
                    registro.setName(misRegistro.getString("NOMBRE"));
                    registro.setNickname(misRegistro.getString("NOMBRE_SUPER"));
                    registro.setEdad(misRegistro.getInt("EDAD"));
                    registro.setPoder(misRegistro.getString("PODER"));
                    registro.setAltura(misRegistro.getInt("ALTURA"));
                    this.avengerItem.add(registro);
                    //nos devolvera el registro con esos datos
                }
            }
            return this.avengerItem;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return this.avengerItem;
        }
       
    }
    
    public AvengersItem getAvengerItemId(int id){
        try{
            
            String SQLGetByID = "SELECT * FROM AVENGERS WHERE ID = ?;";
            PreparedStatement comand = Conexion.getConexion().prepareStatement(SQLGetByID);
            comand.setInt(1, id);
            ResultSet miRegistro = comand.executeQuery();
            AvengersItem registro = new AvengersItem();
            while (miRegistro.next()){
                registro.setId(miRegistro.getInt("ID"));
                registro.setName(miRegistro.getString("NOMBRE"));
                registro.setNickname(miRegistro.getString("NOMBRE_SUPER"));
                registro.setEdad(miRegistro.getInt("EDAD"));
                registro.setPoder(miRegistro.getString("PODER"));
                registro.setAltura(miRegistro.getInt("ALTURA"));
                break;
            }
            comand.close();
            return registro;
            
        }catch(Exception x){
            
            System.err.println(x.getMessage());
            return null;
            
        }
    }
    
    public int updateAvengersItem(AvengersItem ItemtoUpdate){
        try{
            
            String SQLUpdate ="UPDATE AVENGERS set NOMBRE=?, NOMBRE_SUPER=?, EDAD=?, PODER=?, ALTURA=? where ID=?;";
            PreparedStatement comand= Conexion.getConexion().prepareStatement(SQLUpdate);
            comand.setString(1, ItemtoUpdate.getName());
            comand.setString(2, ItemtoUpdate.getNickname());
            comand.setInt(3, ItemtoUpdate.getEdad());
            comand.setString(4, ItemtoUpdate.getPoder());
            comand.setInt(5, ItemtoUpdate.getAltura());
            comand.setInt(6, ItemtoUpdate.getId());
            
            int registroAfectado = comand.executeUpdate();
            comand.close();
            return registroAfectado;
            
        }catch(Exception x){
            System.err.println(x.getMessage());
            return 0;       
        }
    }
    
    public int insertAvengersItem(AvengersItem ItemtoInsert){
        try{
            
            String SQLUpdate ="INSERT INTO AVENGERS (NOMBRE, NOMBRE_SUPER, EDAD, PODER, ALTURA) VALUES (?,?,?,?,?)";
            PreparedStatement comand= Conexion.getConexion().prepareStatement(SQLUpdate);
            comand.setString(1, ItemtoInsert.getName());
            comand.setString(2, ItemtoInsert.getNickname());
            comand.setInt(3, ItemtoInsert.getEdad());
            comand.setString(4, ItemtoInsert.getPoder());
            comand.setInt(5, ItemtoInsert.getAltura());
            
            int registroAfectado = comand.executeUpdate();
            comand.close();
            System.out.println("Insertado Correctamente");
            return registroAfectado;
            
        }catch(Exception x){
            System.err.println(x.getMessage());
            return 0;       
        }
    }
    
    public int deleteAvengersItem(AvengersItem ItemtoDelete){
        
        try{
            String SQLDelete = "DELETE FROM AVENGERS WHERE ID = ?;";
            PreparedStatement comand = Conexion.getConexion().prepareStatement(SQLDelete);
            comand.setInt(1, ItemtoDelete.getId());
            
            int registroAfectado = comand.executeUpdate();
            comand.close();
            System.out.println("Eliminado Correctamente");
            return registroAfectado;
            
        }catch(Exception x){
            System.err.println(x.getMessage());
            return 0;
        }
        
    }
    
}
