/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sidneyferracinjr
 */
public class ControllerArquivoBinario extends ControllerArquivo{
    
    private ObjectInputStream leitor = null;
    private ObjectOutputStream escritor = null;
    
    @Override
    public ObjectInputStream ler() {
        try {
            leitor = new ObjectInputStream(new FileInputStream(arquivo));
            leitor.readObject();
            leitor.close();
            return leitor;
        } catch (IOException e) {
            System.err.println(e.getMessage() + "Erro ao ler arquivo binário.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControllerArquivoBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return leitor;
    }
    
    @Override
    public ObjectOutputStream escrever(boolean append) {
        if (arquivo != null) {
            try {
                escritor = new ObjectOutputStream(new FileOutputStream(arquivo, append));
                escritor.writeObject(arquivo);
                escritor.close();
                return escritor;
            } catch (IOException e) {
                System.err.println(e.getMessage() + "Erro ao escrever arquivo binário.");
                return escritor;
            }
        } else {
            return escritor;
        }
    }
    
    public static ObjectOutputStream CriaEscritorObjeto(File arquivo) {
        ObjectOutputStream out = null;
        try {
            if (arquivo.exists()) {
                FileOutputStream fos = new FileOutputStream(arquivo, true);
                out = new ObjectOutputStream(fos) {

                    @Override
                    protected void writeStreamHeader() {
                        // do not write a header
                    }
                };
            } else {
                FileOutputStream fos = new FileOutputStream(arquivo, true);
                out = new ObjectOutputStream(fos);
            }
        } catch (IOException erro) {
            System.out.println("Erro ao criar arquivo. " + erro);
        }
        return out;
    }
}
