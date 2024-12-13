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
public class StudentModel implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String nome;
    private String turma;
    private int matricula;
    
    private static int contaAluno = 1;

    public StudentModel(String nome, String turma, int matricula) {
        this.nome = nome;
        this.turma = turma;
        this.matricula = matricula;
    }
    
    public StudentModel(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public StudentModel() {
        matricula = contaAluno;
        contaAluno++;
    }

    @Override
    public String toString() {
        return "Aluno{" + "nome=" + nome + ", turma=" + turma + ", matricula=" + matricula + '}';
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
    
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

}
