package IleituraEscritaByte;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
/**
 * @author fabricio@utfpr.edu.br
 */
public class InputStreamExemplo {
    public static void main(String[] args) throws IOException {
        URL locator = new URL("http://paginapessoal.utfpr.edu.br/fabricio/imagens/utfpr.jpg");
        InputStream in = locator.openStream();
        int next = in.read();
        while (next != -1) {
            System.out.println(next);
            next = in.read();
        }
        in.close();
    }
}
