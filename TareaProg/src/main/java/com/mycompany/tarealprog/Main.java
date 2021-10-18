/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tarealprog;

import com.unicahiccpmp.utilities.Layout;
import java.util.Scanner;



/**
 *
 * @author Jessie Gaboriell
 */
public class Main {
     public static void main (String[] args) {
        Layout.printHeader("Avengers");
        String OpcionMenu = "";
        
        Scanner entradaTeclado = new Scanner(System.in);
        
        Aplication Avengers = new Aplication(entradaTeclado);
        
        while (!(OpcionMenu.toUpperCase().equals("S"))) {
            Layout.printMenu();
            OpcionMenu = entradaTeclado.nextLine();

            System.out.println("Texto ingresado es igual a " + OpcionMenu);
            Avengers.Eventos(OpcionMenu);
            
        }
     }
}

