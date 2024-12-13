/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AinterfaceGrafica.exercicios;

import java.text.DecimalFormat;

/**
 *
 * @author fabricio
 */
public class Conversor5 {

    /**
     * O metodo format recebe um parametro double e converte para 
     * sua representação texto.
     * @param number representa o numero
     * @return String com representação do número.
     */
    public String Format(double number) {
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        return (numberFormat.format(number));
    }

    public String Celsius2FahrenheitS(double c) {
        return Format(Celsius2Fahrenheit(c));
    }

    /**
     * O metodo Celsius2Fahrenheit recebe um parametro double na escala Celsius
     * e converte para a escalaFahrenheit.
     * @param c representa graus Celsius
     * @return Double com representação em escala Fahrenheit.
     */
    public Double Celsius2Fahrenheit(double c) {
        double f = 0;
        //transforma c para f
        f = (c * 9 / 5) + 32;
        return f;
    }

    public double Celsius2Kelvin(double c) {
        double k = 0;
        //transforma c para k
        return k;
    }

    public double Fahrenheit2Celsius(double f) {
        double c = 0;
        //transforma f para c
        return c;
    }

    public double Fahrenheit2Kelvin(double f) {
        double k = 0;
        //transforma f para k
        return k;
    }

    public double Kelvin2Celsius(double k) {
        double c = 0;
        //transforma k para c
        return c;
    }

    public double Kelvin2Fahrenheit(double k) {
        double f = 0;
        //transforma k para f
        return f;
    }
}
