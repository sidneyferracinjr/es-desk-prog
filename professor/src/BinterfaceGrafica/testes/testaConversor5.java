/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BinterfaceGrafica.testes;

import AinterfaceGrafica.exercicios.Conversor5;

/**
 *
 * @author fabricio
 */
public class testaConversor5 {

    public static void main(String[] args) {
        Conversor5 obj = new Conversor5();
        double vlr = Double.valueOf(args[0]);
        double f = obj.Celsius2Fahrenheit(vlr);
        System.out.print("O valor "+vlr+" Celsius convertido em Fahrenheit:");
        System.out.println(f);
    }

}
