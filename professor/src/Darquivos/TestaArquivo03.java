package Darquivos;

import java.io.File;
import java.util.Date;
import java.util.Scanner;
/**
 * @author fabricio@utfpr.edu.br
 */
public class TestaArquivo03 {

    // implementado
    public static void leituraPasta(File dir) {
        String[] listagem = dir.list();
        for (String arquivo : listagem) {
            File filho = new File(dir, arquivo);
            System.out.println("Nome: "+ filho.getName());
            System.out.println(filho.getAbsolutePath());
            System.out.println("É diretorio? " + filho.isDirectory());
            System.out.println("É arquivo? " + filho.isFile());
            System.out.println("Tamanho = " + filho.length() + " bytes.");
            Date aux = new Date(filho.lastModified());
            System.out.println("Ultima alteração = " + aux+"\n\n");
        }
    }

    // inutil
    public static void main(String[] args) {
        System.out.println("Entre com o caminho: ");
        Scanner leitura = new Scanner(System.in);
        String path = leitura.nextLine();
        File arquivo = new File(path);
        leituraPasta(arquivo);
    }
}
