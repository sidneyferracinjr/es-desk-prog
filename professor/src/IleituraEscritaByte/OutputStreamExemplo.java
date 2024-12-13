package IleituraEscritaByte;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author fabricio@utfpr.edu.br
 */
public class OutputStreamExemplo {
    public static void main(String[] args) throws IOException {
        URL locator = new URL("http://paginapessoal.utfpr.edu.br/fabricio/imagens/utfpr.jpg");
        InputStream in = locator.openStream();
        FileOutputStream out = new FileOutputStream("/home/fabricio/temp/img.jpg");
        int next = in.read();
        while (next != -1) {
            out.write(next);
            next = in.read();
        }
        in.close();
        out.close();
    }
}
