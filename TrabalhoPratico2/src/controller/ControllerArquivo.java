/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;

/**
 *
 * @author sidneyferracinjr
 */
public abstract class ControllerArquivo {
    
    protected File arquivo = null;
    public abstract ObjectInputStream ler();
    public abstract ObjectOutputStream escrever(boolean append);
    
    /**
     * @return o valor da variavel arquivo
     */
    public File getArquivo() {
        return arquivo;
    }
    
    /**
     * @param arquivo o arquivo a ser escolhido
     */
    public void setArquivo(String textoBotao) {
        arquivo = null;
        String dirInicial = System.getProperty("user.dir");
        JFileChooser chooser = new JFileChooser(dirInicial);
        if (chooser.showDialog(null, textoBotao) == JFileChooser.APPROVE_OPTION) {
            arquivo = chooser.getSelectedFile();
        }     
    }
    
}
