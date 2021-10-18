/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicahiccpmp.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Jessie Gaboriell
 */
public class Conexion {
    
    public static Connection conexion = null;//aqui se guarda la conexion
    
    //que no se pueda instaciar.
    private Conexion (){
        
    }
    //metodo para extraer la conxion
    //si yo quiere sacar la conexion tengo que 
    /*
    la instancio tipo
    Connection algunaConexion = Conexion.getConexion();
    */
    public static Connection getConexion(){
        try{
            if(conexion == null){
                /*
                si la conexion no esta establecida, crea la conexion
                y la devuelve instanciada.
                A esto de le conoce como un patron Singleton.
                esto de cierta forma en un LOO(lenguaje orientado a objetos) variable global.
                */
                Class.forName("org.sqlite.JDBC");//lo que hace es cargar en memoria el archivo o la libreria que vamos a ocupar
               conexion=  DriverManager.getConnection("jdbc:sqlite:avengersdb.db");
               //Fabricador para las conexiones. y le mandamos la BD a la que ocupamos conectarnos.
               return conexion;
            }else{
                return conexion;
            }
        }catch(Exception ex){
            System.out.println("Error" + ex.getMessage());
            return null;
        }
    }
    /*
    Singleton: patron de dise;o en donde el objetivo es
    devolver una unica instancia en toda la vida de una app
    esto quiere decir cuando se abre hasta que se cierra
    Para esto ocupamos establecer un espacio de memoria,
    un puntero que este activo durante toda la aplicacion,
    por eso se ocupa una variable privada estatica, y luego 
    un metodo que verificar'a si ya esta instanciada esa variable
    con un valor.
    como esa clase no se puede instanciar para poder controlarlo
    se establece un constructor de forma privada.
    */
    
    
}
