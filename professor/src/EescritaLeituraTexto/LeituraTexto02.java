package EescritaLeituraTexto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author fabricio@utfpr.edu.br
 */
public class LeituraTexto02 {
    public static void main(String[] args) {
        try {
            BufferedReader leitor = 
                    new BufferedReader(new FileReader(new File("/home/fabricio/log.txt")));
            while (leitor.ready()) {
                String data = leitor.readLine();
                System.out.println(data);
            }
            leitor.close();
        } catch (IOException erro){
            erro.printStackTrace();
        }
    }
}
