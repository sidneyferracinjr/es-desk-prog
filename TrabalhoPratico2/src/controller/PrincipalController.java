/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import config.Config;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import utils.FileUtils;

/**
 *
 * @author sidneyferracinjr
 */
public class PrincipalController {
    
//    ControllerDiretorio controllerDiretorio = new ControllerDiretorio();
    FileUtils fileUtils = FileUtils.getInstance();
    Config config = Config.getInstance();

    public PrincipalController() {
    
    }
    
    /**
     * Gera informações detalhadas sobre um diretório fornecido.
     * @throws IllegalArgumentException Se o parâmetro {@code diretorio} for nulo ou não for um diretório válido.
     */
    public String salvarEm(String filePath) throws IOException {
        FileUtils.selectFile();
        return FileUtils.describeDiretory(filePath);
    }
    
    public boolean abrirJAluno() {
        
        return false;
    }
    
    public boolean abrirJBoletim() {
        
        return false;
    }
    
    public boolean abrirJTurma() {
        
        return false;
    }

}
