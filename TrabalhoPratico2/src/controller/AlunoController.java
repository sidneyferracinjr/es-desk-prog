/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import config.Config;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import utils.FileUtils;

/**
 *
 * @author sidneyferracinjr
 */
public class AlunoController {
    
    private List<Aluno> alunos = new ArrayList<Aluno>();
    Config config = Config.getInstance();
    private String filePath = config.getProperty("filePath");

    public AlunoController() {
        
    }
    
    public AlunoController(String filePath) {
        if (!filePath.isBlank()) {
            this.filePath = filePath;
        }
    }
    
    public boolean abrirArquivo() {
        
        return false;
    }
    
    public boolean salvarArquivo() throws IOException {
        FileUtils.createDirectory(filePath);
        return false;
    }
    
    public boolean salvarArquivoComo() {
        
        return false;
    }
    
    public boolean criarAluno(Aluno aluno) {
        if (aluno != null) {
            alunos.add(aluno);
            return true;
        }

        return false;
    }

    public boolean lerAluno(int matricula) {
        
        return false;
    }
    
    public boolean atualizarAluno(int matricula) {
        
        return false;
    }

    public boolean excluirAluno(int matricula) {

        return false;
    }
    
    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
