/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tarealprog;

import java.util.ArrayList;

/**
 *
 * @author Jessie Gaboriell
 */
public class AvengersItem {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the poder
     */
    public String getPoder() {
        return poder;
    }

    /**
     * @param poder the poder to set
     */
    public void setPoder(String poder) {
        this.poder = poder;
    }

    /**
     * @return the altura
     */
    public int getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    private int id;
    private String name;
    private String nickname;
    private int edad;
    private String poder;
    private int altura;
    
    public AvengersItem(){
        this.name="";
        this.id=0;
        this.nickname="";
        this.edad=0;
        this.poder="";
        this.altura=0;
    }
    
    public AvengersItem(int _id, String _name, String _nickname, int _edad,String _poder, int _altura){
        this.id= _id;
        this.name= _name;
        this.nickname=_nickname;
        this.edad= _edad;
        this.poder=_poder;
        this.altura= _altura;
    }
    public ArrayList<String>ConseguirDatos(){
        ArrayList<String> datos = new ArrayList<String>();
        datos.add(String.valueOf(this.id));
        datos.add(this.name);
        datos.add(this.nickname);
        datos.add(String.valueOf(this.edad));
        datos.add(this.poder);
        datos.add(String.valueOf(this.altura));
  
        return datos;
    }
}

    