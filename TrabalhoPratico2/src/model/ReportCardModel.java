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
public class ReportCardModel implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private static int contaAluno = 1;
    private int idBoletim;
    private String aluno;
    private String media;

    public ReportCardModel(int idBoletim, String aluno, String media) {
        this.idBoletim = idBoletim;
        this.aluno = aluno;
        this.media = media;
    }
    
    public ReportCardModel(String aluno) {
        this.aluno = aluno;
    }
    
    public ReportCardModel() {
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

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }
    
}
