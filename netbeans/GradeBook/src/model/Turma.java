/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sidne
 */
public class Turma implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int codigo;
    private String nome;
    private List<Aluno> alunos;

    public Turma(int codigo, String nome, List<Aluno> alunos) {
        this.codigo = codigo;
        this.nome = nome;
        this.alunos = alunos;
    }
    
    public Turma(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.alunos = new ArrayList<>();
    }
    
    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
        aluno.setTurma(this);
    }
    
    public List<Aluno> listarAlunos() {
        return alunos;
    }

    @Override
    public String toString() {
        return "Turma{" + "codigo=" + codigo + ", nome=" + nome + ", alunos=" + alunos + '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
    
}
