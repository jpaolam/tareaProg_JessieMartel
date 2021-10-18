/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicahiccpmp.utilities;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jessie Gaboriell
 */
public class Layout {
    public static void printSeparator () {
        System.out.println("----------------------------------------------------------------------------");
    }
    public static void printHeader (String header) {
        int headerLength = header.length();//obtengo el tamanio del header
        int startPoint = (int) Math.floor((80 - headerLength) / 2);
        String headerBuffer = "";
        for(int i = 0; i<startPoint; i++) {
            headerBuffer += " ";
        }
        headerBuffer += header;
        startPoint = headerBuffer.length();
        for (int i = startPoint ; i < 80; i++ ){
            headerBuffer += " ";
        }
        
        printSeparator();
        System.out.println(headerBuffer);
        printSeparator();
    }
    
    public static void printMenu() {
        printHeader("Menu");
        
        System.out.println("\nM - Mostrar\nI - Ingresar\nA - Actualizar\nE - Eliminar\n\nS - Salir\n");
        printSeparator();
        System.out.println("Seleccione una opción : ");
       
    }
    
    public static String obtenerValores(String mensaje,String datoPredeterminado,Scanner EntradaTeclado ){
        System.out.println(mensaje + " (" + datoPredeterminado + " ) :");
        String dato= EntradaTeclado.nextLine();
        if(dato.isEmpty()){
            return datoPredeterminado;
        }
        return dato;
    }
    
    public static void imprimirColumna(ArrayList<String> columns, ArrayList<Integer> widths, String separator) throws Exception{
        if ( columns.size() != widths.size()) {
            throw new Exception("Las columnas no coinciden con los anchos");
        }
        System.out.print(separator);
        for (int i = 0; i < columns.size(); i++){
            String column = String.format("%1$-" + String.valueOf(widths.get(i)) +"s", columns.get(i));
            column = column.substring(0, widths.get(i));
            
            System.out.print(column);
            System.out.print(separator);
        
        }
        System.out.println();
    }
}
