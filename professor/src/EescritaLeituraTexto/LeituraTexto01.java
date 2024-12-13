/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EescritaLeituraTexto;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author fabricio@utfpr.edu.br
 */
public class LeituraTexto01 {

    public static void main(String[] args) {
        FileReader fileReader = null;
        try {
            //File entrada = new File("/home/fabricio/log.txt");
            // if (entrada.exists()) {
            fileReader = new FileReader("/home/fabricio/log.txt");
            int data = fileReader.read();
            while (data != -1) {
                char c = (char) data;
                System.out.println(data + " = " + c);
                data = fileReader.read();
            }
            fileReader.close();
            //}
        } catch (IOException erro) {
            erro.printStackTrace();
        }

    }
}
