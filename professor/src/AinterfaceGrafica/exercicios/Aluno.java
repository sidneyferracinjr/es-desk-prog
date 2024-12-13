/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AinterfaceGrafica.exercicios;

/**
 *
 * @author fabricio
 */
public class Aluno {
    private float p1;
    private float p2;
    private float p3;
    private float p4;

    /**
     * @return the p1
     */
    public float getP1() {
        return p1;
    }

    /**
     * @param p1 the p1 to set
     */
    public void setP1(float p1) {
        this.p1 = p1;
    }

    /**
     * @return the p2
     */
    public float getP2() {
        return p2;
    }

    /**
     * @param p2 the p2 to set
     */
    public void setP2(float p2) {
        this.p2 = p2;
    }

    /**
     * @return the p3
     */
    public float getP3() {
        return p3;
    }

    /**
     * @param p3 the p3 to set
     */
    public void setP3(float p3) {
        this.p3 = p3;
    }

    /**
     * @return the p4
     */
    public float getP4() {
        return p4;
    }

    /**
     * @param p4 the p4 to set
     */
    public void setP4(float p4) {
        this.p4 = p4;
    }
    
    public String media(){
        float media = (p1+p2+p3+p4)/4;
        if (media >= 6){
            return "Média: "+media+" -> Aprovado.";
        } else if (media >= 4 && media < 6){
            return "Média: "+media+" -> Recuperação.";
        }else{
            return "Média: "+media+" -> Reprovado.";
        }
    }
    
}
