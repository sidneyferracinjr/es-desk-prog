package FescritaLeituraInterfaceGrafica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 * @author fabricio@utfpr.edu.br
 */
public class FileChooserDemo {

    File arquivo = null;

   
    public void AbreArquivo() throws IOException {
        String pastainicial = System.getProperty("user.dir");
        JFileChooser chooser = new JFileChooser(pastainicial);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            arquivo = chooser.getSelectedFile();
        }
    }

    public void LerArquivo() throws IOException {
        BufferedReader entrada = null;
        AbreArquivo();
        entrada = new BufferedReader(new FileReader(arquivo));
        int lineNumber = 0;
        while (entrada.ready()) {
            String line = entrada.readLine();
            System.out.println(lineNumber + ": " + line);
            lineNumber++;
        }
        entrada.close();
    }

    public static void main(String[] args) throws IOException {
        //System.out.println(System.getProperties());
        FileChooserDemo obj = new FileChooserDemo();
        obj.LerArquivo();
    }
}
