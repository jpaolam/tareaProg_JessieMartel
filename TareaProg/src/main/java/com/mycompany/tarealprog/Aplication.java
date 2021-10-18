/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tarealprog;

import com.unicahiccpmp.utilities.Layout;
import java.util.ArrayList;
import java.util.Scanner;
import com.unicahiccpmp.dao.AvengersBD;
/**
 *
 * @author Jessie Gaboriell
 */
public class Aplication {
    private Scanner Entrada;
    private ArrayList Avenger;
    private int Contador;
    private AvengersBD avengersmodel;
    
    //Constructor.
    public Aplication(Scanner _Entrada){
        this.Entrada = _Entrada;
        this.Avenger = new ArrayList<AvengersItem>();
        this.Contador = 0;
        this.avengersmodel = new AvengersBD();
        
        this.avengersmodel.TableInitialize();
        /*
        con esto esperamos que la tabla genere la conexion
        y que esta genere la base de datos.
        y esa base de datos va a estar generada en la carpeta
        */
        this.Avenger = this.avengersmodel.getAvengerItem(true);
    }
    
    public void Eventos(String Opcion){
        switch(Opcion.toUpperCase()){
            case "M":
                this.mostrar();
                break;
            case "I":
                this.ingresar();
                break;
            case "A":
                this.actualizar();
                System.out.println("Actualizado Correctamente");
                break;
            case "E":   
                this.eliminar();
                break;
            case "S":
                break;
            default:
                System.out.println("Opción no reconocida!!!");
                break;
        }
    }
    
    private void ingresar(){
        Layout.printHeader("Avenger Nuevo");
        AvengersItem newItem = new AvengersItem();
        
        newItem.setName(Layout.obtenerValores("Nombre real","XYZ",this.Entrada));
        newItem.setNickname(Layout.obtenerValores("Nombre de su personaje","Personaje xx",this.Entrada));
        newItem.setEdad(Integer.parseInt(Layout.obtenerValores("Edad", " XX", this.Entrada)));
        newItem.setPoder(Layout.obtenerValores("Poder", "Poder XX", this.Entrada));
        newItem.setAltura(Integer.parseInt(Layout.obtenerValores("Altura", "Altura XX", this.Entrada)));
        
        newItem.setId(this.Contador + 1);//Le asignamos un valor al Id
        //this.Contador++;//para que incremente en la cantidad de registros que llevo ingresando
        //this.Avenger.add(newItem);//Lo agregamos al ArrayList guardandolo para mostrarlo.
        this.avengersmodel.insertAvengersItem(newItem);
        this.Avenger = this.avengersmodel.getAvengerItem(true);
        Layout.printSeparator();
        System.out.println(this.Avenger.size());//me imprima cuantos datos tengo ingresados.

    }
    
    private void mostrar(){
        Layout.printSeparator();
        
        ArrayList<String> columns = new ArrayList<String>();
        columns.add("ID");
        columns.add("Nombre");
        columns.add("Personaje");
        columns.add("Edad");
        columns.add("Poder");
        columns.add("Altura");
        
        ArrayList<Integer> widths = new ArrayList<Integer>();
        
        widths.add(7);
        widths.add(22);
        widths.add(20);
        widths.add(10);
        widths.add(22);
        widths.add(10);
        
        try{
            Layout.imprimirColumna(columns, widths, "|");
            Layout.printSeparator();
            
            for(int i = 0; i < this.Avenger.size();i++){
                columns = ((AvengersItem) this.Avenger.get(i)).ConseguirDatos();
                Layout.imprimirColumna(columns, widths, "|");
            }
        }catch(Exception X) {
            System.err.println("Error al imprimir " + X.getMessage());
        }
    }
    
    private void actualizar(){
        Layout.printHeader("Actualizar Avenger");
        int idSeleccionado = Integer.valueOf(Layout.obtenerValores("Ingrese el codigo del avenger", "0", this.Entrada));
        AvengersItem selectAvenger = null;
       
    //    for(int i = 0; i < this.Avenger.size();i++){
    //        if(idSeleccionado== ((AvengersItem)this.Avenger.get(i)).getId() ){
     //           selectAvenger = (AvengersItem)this.Avenger.get(i);
    //            break;
                /*
                recorre todo los regustros que hemos ingresado
                buscando el que contenga el mismo codigo que nosostros hemos ingresado
                haciendo uso del java class LenguajesItem.
                */
       //     }
   //     }
   
        selectAvenger = this.avengersmodel.getAvengerItemId(idSeleccionado);
        if(selectAvenger == null){
            System.out.println("El registro no existe!");
        }else{
            
            selectAvenger.setName(Layout.obtenerValores("Nombre del avenger",selectAvenger.getName() , this.Entrada));
            selectAvenger.setNickname(Layout.obtenerValores("Nickname",selectAvenger.getNickname(), this.Entrada));
            int edad = Integer.parseInt(Layout.obtenerValores("Edad", "20", this.Entrada));
            selectAvenger.setPoder(Layout.obtenerValores("Poder", selectAvenger.getPoder(), this.Entrada));
            int altura = Integer.parseInt(Layout.obtenerValores("Altura", "12", this.Entrada));
            
            this.avengersmodel.updateAvengersItem(selectAvenger);
            this.Avenger = this.avengersmodel.getAvengerItem(true);
            Layout.printSeparator();
            System.out.println("Registro Actualizado Correctamente!");
        }
    }
    
    private void eliminar(){
        Layout.printHeader("Eliminar Avenger");
        int selectAvenger = Integer.valueOf(Layout.obtenerValores("Ingrese el codigo del avenger", "0", this.Entrada));
 //       int encontradoIndice = -1;
 //       for(int i = 0; i< this.Avenger.size(); i++){
 //           if(selectAvenger == ((AvengersItem)this.Avenger.get(i)).getId()){
 //               encontradoIndice = i;
 //               break;
 //           }
 //       }
 
        AvengersItem selectedAvenger = this.avengersmodel.getAvengerItemId(selectAvenger);
        
        if(selectedAvenger != null){
            Layout.printSeparator();
            String confirm = Layout.obtenerValores("Esta seguro de eliminar el registro? S - N", "N", this.Entrada);
            if(confirm.toUpperCase().equals("S")){
                this.avengersmodel.deleteAvengersItem(selectedAvenger);
                this.Avenger = this.avengersmodel.getAvengerItem(true);
                Layout.printSeparator();
                System.out.println("Registro eliminado Correctamente!");
                
            }else{
                System.out.println("Registro no existe");
            }
        }
    }
}

