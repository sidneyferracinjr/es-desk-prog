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
public class ClassModel implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int contaTurma = 1;
    private int codigo;
    private String nome;
    private String alunos;

    public ClassModel(int codigo, String nome, String alunos) {
        this.codigo = codigo;
        this.nome = nome;
        this.alunos = alunos;
    }
    
    public ClassModel() {
        codigo = contaTurma;
        contaTurma++;
    }
    
    public String listarAlunos() {
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

    public String getAlunos() {
        return alunos;
    }

    public void setAlunos(String alunos) {
        this.alunos = alunos;
    }
    
}
