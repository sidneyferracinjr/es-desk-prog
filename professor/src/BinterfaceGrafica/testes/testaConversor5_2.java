/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BinterfaceGrafica.testes;

import AinterfaceGrafica.exercicios.Conversor5;
import java.util.Scanner;

/**
 *
 * @author fabricio
 */
public class testaConversor5_2 {

    public static void main(String[] args) {
        Conversor5 obj = new Conversor5();
        Scanner scn = new Scanner(System.in);
        System.out.print("Digite Temperatura em Celsius:");
        double vlr = scn.nextDouble();
        System.out.print("O valor "
                + vlr
                + " Celsius convertido em Fahrenheit:");
        System.out.println(obj.Celsius2FahrenheitS(vlr));
    }
}
