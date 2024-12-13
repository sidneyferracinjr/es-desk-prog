package EescritaLeituraTexto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author fabricio@utfpr.edu.br
 */
public class EscritaTexto02 {

    public void leTexto(String filename) throws FileNotFoundException, IOException {
        File entrada = new File(filename);
        FileReader leitor = new FileReader(entrada);
        leitor.read();
        leitor.close();
    }

    public void escreveTexto(String filename) throws FileNotFoundException, IOException {
        File entrada = new File(filename);
        FileWriter escritor = new FileWriter(entrada, false);
        escritor.write("Hello world!");
        escritor.close();
    }

    public static void main(String[] args) {
        String filename1 = "/home/fabricio/log.txt";
        BufferedWriter fileWriter = null;
        try {
            fileWriter = new BufferedWriter(new FileWriter(new File(filename1), true));
            fileWriter.write("Hello world 5!");
            fileWriter.newLine();
            fileWriter.write("Hello world 6!");
            fileWriter.newLine();
            fileWriter.flush();
            fileWriter.close();
            //EscritaTexto02 obj = new EscritaTexto02();
            //obj.leTexto("/home/fabricio/logqqqqq.txt");
        } catch (FileNotFoundException erro) {
            System.err.println("Arquivo não encontrado.");
        } catch (IOException erro) {
            erro.printStackTrace();
        }
    }
}
