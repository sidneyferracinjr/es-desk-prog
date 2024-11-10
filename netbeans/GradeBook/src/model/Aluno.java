/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author sidne
 */
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int matricula;
    private String nome;
    private Turma turma;

    public Aluno(int matricula, String nome, Turma turma) {
        this.matricula = matricula;
        this.nome = nome;
        this.turma = turma;
    }
    
    public Aluno(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }
    
    public Boletim obterBoletim() {
        return new Boletim(this);
    }

    @Override
    public String toString() {
        return "Aluno{" + "matricula=" + matricula + ", nome=" + nome + ", turma=" + turma + '}';
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

}
