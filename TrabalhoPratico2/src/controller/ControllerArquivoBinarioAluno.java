/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import model.Aluno;

/**
 *
 * @author sidneyferracinjr
 */
public class ControllerArquivoBinarioAluno extends ControllerArquivoBinario{
    
    private Aluno aluno = null;

    /**
     * @return o valor da variavel aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @param aluno define o aluno
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public boolean lerAluno() {
        try {
            aluno = (Aluno) ler().readObject();
            return true;
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de aluno: " + e.getMessage());
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            System.err.println("Classe Aluno não encontrada: " + e.getMessage());
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            System.err.println("Erro desconhecido ao ler o aluno: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean escreverAluno(boolean append) {
        try {
            escrever(append);
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage() + "Erro ao escrever arquivo binário.");
            return false;
        }
    }
}
