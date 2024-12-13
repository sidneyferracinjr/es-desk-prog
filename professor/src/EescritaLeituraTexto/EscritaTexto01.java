package EescritaLeituraTexto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
/**
 * @author fabricio@utfpr.edu.br
 */
public class EscritaTexto01 {

    public static void main(String[] args) {
        Writer fileWriter = null;
        try {
            File arquivo = new File("/home/fabricio/log.txt");
            fileWriter = new FileWriter(arquivo, true);
            fileWriter.write("Hello world 2!");
            fileWriter.close();
        } catch (IOException erro) {
            erro.printStackTrace();
        }
    }
}
