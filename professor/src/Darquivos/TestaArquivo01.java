package Darquivos;

import java.io.File;
import java.io.IOException;

/**
 * @author fabricio@utfpr.edu.br
 */
public class TestaArquivo01 {

    public static void main(String[] args) throws IOException{
        File dir = new File("/home/fabricio/temp01/");
        File arq = new File(dir, "log.txt");
        if (dir.mkdir()) {
            System.out.println("Pasta criada com sucesso.");
        } else if (dir.exists()) {
            System.out.println("Pasta já existe.");
        } else if (dir.canRead()) {
            System.out.println("Consigo ler.");
        }else{
            System.out.println("Não consigo ler. Pasta não foi criada.");
        }
        if(arq.createNewFile()){
            System.out.println("Arquivo criado com sucesso.");
        }else{
            System.out.println("Arquivo não foi criado.");
        }
        System.out.println("Caminho pasta = "   + dir.getAbsolutePath());
        System.out.println("Caminho arquivo = " + arq.getAbsolutePath());
    }
}
