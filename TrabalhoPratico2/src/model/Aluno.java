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
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private static int contaAluno = 1;
    private int matricula;
    private String nome;
    private String turma;

    public Aluno(int matricula, String nome, String turma) {
        this.matricula = matricula;
        this.nome = nome;
        this.turma = turma;
    }
    
    public Aluno(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public Aluno() {
        matricula = contaAluno;
        contaAluno++;
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

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

}
