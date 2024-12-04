package aulaarquivos01;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

/**
 * @author fabricio@utfpr.edu.br
 */
public class TestaArquivo04 {

    /**
     * Metodo para impressao de listagens em console
     */
    public void leituraPastaConsole(File dir) {
        String aux = leituraPasta(dir);
        System.out.println(aux);
    }

    /**
     * Metodo para impressao de listagens e retorno de conteudo
     */
    public String leituraPasta(File dir) {
        StringBuilder sb = new StringBuilder();
        String[] listagem = dir.list();
        for (String arquivo : listagem) {
            File filho = new File(dir, arquivo);
            sb.append("Nome: " + filho.getName()).append("\n");
            sb.append(filho.getAbsolutePath()).append("\n");
            sb.append("É diretorio? " + filho.isDirectory()).append("\n");
            sb.append("É arquivo? " + filho.isFile()).append("\n");
            sb.append("Tamanho = " + filho.length() + " bytes.").append("\n");
            Date aux = new Date(filho.lastModified());
            sb.append("Ultima alteração = ").append(aux).append("\n\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Entre com o caminho: ");
        Scanner leitura = new Scanner(System.in);
        String path = leitura.nextLine();
        File arquivo = new File(path);
        TestaArquivo04 obj = new TestaArquivo04();
        obj.leituraPastaConsole(arquivo);
    }
}
