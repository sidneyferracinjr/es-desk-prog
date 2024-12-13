package JleituraEscritaByteInterfaceGrafica;

import IleituraEscritaByte.Cliente;
import FescritaLeituraInterfaceGrafica.ControllerArquivo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author fabricio
 */
public class ControllerArquivoBinario extends ControllerArquivo {

    private Cliente cliente = null;
    private ObjectInputStream leitor = null;
    private ObjectOutputStream escritor = null;

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // implementado
    // Este método **`ler()`** tenta ler um objeto serializado de um arquivo usando `ObjectInputStream`. Retorna `true` se a leitura for bem-sucedida, ou `false` se ocorrer uma exceção de classe não encontrada ou erro de I/O, exibindo mensagens de erro no console.
    @Override
    public boolean ler() {
        try {
            leitor = new ObjectInputStream(new FileInputStream(arquivo));
            cliente = (Cliente) leitor.readObject();
            leitor.close();
            return true;
        } catch (ClassNotFoundException erro) {
            //erro.printStackTrace();
            System.err.println(erro.getMessage() + "Classe não encontrada.");
            return false;
        } catch (IOException erro) {
            System.err.println(erro.getMessage() + "Erro ao ler arquivo binário.");
            return false;
        }
    }

    // Esse método `escrever` grava um objeto `cliente` em um arquivo binário, permitindo a escolha de adicionar ao conteúdo existente (`append`) ou sobrescrever. Retorna `true` em caso de sucesso e `false` em caso de falha.
    @Override
    public boolean escrever(boolean append) {
        if (arquivo != null) {
            try {
                escritor = new ObjectOutputStream(new FileOutputStream(arquivo, append));
                escritor.writeObject(cliente);
                escritor.close();
                return true;
            } catch (IOException erro) {
                System.err.println(erro.getMessage() + "Erro ao escrever arquivo binário.");
                return false;
            }
        } else {
            return false;
        }
    }

    /*
     * metodo para ser usado na criação de escritores binarios
     * quando for necessario escrever varios objetos em um mesmo
     * arquivo considerando multiplas execuções da aplicação. 
     */
    // O método `CriaEscritorObjeto` cria e retorna um `ObjectOutputStream` para gravar objetos em um arquivo; ele omite o cabeçalho do stream se o arquivo já existir, para evitar conflitos de escrita.
    public static ObjectOutputStream CriaEscritorObjeto(File arquivo) {
        ObjectOutputStream out = null;
        try {
            if (arquivo.exists()) {
                FileOutputStream fos = new FileOutputStream(arquivo, true);
                out = new ObjectOutputStream(fos) {

                    @Override
                    protected void writeStreamHeader() {
                        // do not write a header
                    }
                };
            } else {
                FileOutputStream fos = new FileOutputStream(arquivo, true);
                out = new ObjectOutputStream(fos);
            }
        } catch (IOException erro) {
            System.out.println("Erro ao criar arquivo. " + erro);
        }
        return out;
    }
}
