package JleituraEscritaByteInterfaceGrafica;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author fabricio@utfpr.edu.br
 */
public abstract class ControllerArquivo {
    protected File arquivo = null;
    public abstract boolean ler();
    public abstract boolean escrever(boolean append);
    
    /**
     * @return the arquivo
     */
    public File getArquivo() {
        return arquivo;
    }

    /**
     * @param arquivo the arquivo to set
     */
    // implementado
    // O método `setArquivo` abre um seletor de arquivos (JFileChooser) no diretório atual, permitindo ao usuário selecionar um arquivo e atribuí-lo à variável `arquivo`.
    public void setArquivo(String TextoBotao) {
        arquivo = null;
        String pastainicial = System.getProperty("user.dir");
        JFileChooser chooser = new JFileChooser(pastainicial);
        if (chooser.showDialog(null, TextoBotao) == JFileChooser.APPROVE_OPTION) {
            arquivo = chooser.getSelectedFile();
        }     
    }
}
