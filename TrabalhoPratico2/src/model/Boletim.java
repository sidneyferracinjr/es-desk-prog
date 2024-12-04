/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author sidneyferracinjr
 */
public class Boletim implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private static int contaAluno = 1;
    private int idBoletim;
    private String aluno;
    private float media;

    public Boletim(String aluno, float media) {
        this.aluno = aluno;
        this.media = media;
    }
    
    public Boletim(String aluno) {
        this.aluno = aluno;
    }
    
    public Boletim() {
        idBoletim = contaAluno;
        contaAluno++;
    }

    @Override
    public String toString() {
        return "Boletim{" + "aluno=" + aluno + ", media=" + media + '}';
    }

    public int getIdBoletim() {
        return idBoletim;
    }

    public void setIdBoletim(int idBoletim) {
        this.idBoletim = idBoletim;
    }  
  
    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }
    
}
