/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sidne
 */
public class Boletim implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Aluno aluno;
    private Map<String, Double> notas;
    private double media;

    public Boletim(Aluno aluno, Map<String, Double> notas, double media) {
        this.aluno = aluno;
        this.notas = notas;
        this.media = media;
    }
    
    public Boletim(Aluno aluno) {
        this.aluno = aluno;
        this.notas = new HashMap<>();
    }
    
    public void adicionarNota(String disciplina, double nota) {
        notas.put(disciplina, nota);
        calcularMedia();
    }
    
    public void calcularMedia() {
        double soma = 0;
        for (double nota : notas.values()) {
            soma += nota;
        }
        this.media = notas.isEmpty() ? 0 : soma / notas.size();
    }

    @Override
    public String toString() {
        return "Boletim{" + "aluno=" + aluno + ", notas=" + notas + ", media=" + media + '}';
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Map<String, Double> getNotas() {
        return notas;
    }

    public void setNotas(Map<String, Double> notas) {
        this.notas = notas;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }
    
}
