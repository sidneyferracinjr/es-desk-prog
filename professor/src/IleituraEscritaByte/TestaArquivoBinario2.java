package IleituraEscritaByte;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author fabricio@utfpr.edu.br
 */
public class TestaArquivoBinario2 {

    public static ObjectOutputStream CriaEscritorBinario(
            File arquivo, boolean append, boolean cabecalho) {
        ObjectOutputStream out = null;
        try {
            FileOutputStream fos = new FileOutputStream(arquivo, append);
            if (cabecalho) {
                out = new ObjectOutputStream(fos);
            } else {
                out = new ObjectOutputStream(fos) {
                    @Override
                    protected void writeStreamHeader() {
                        // nao escreve o cabeçalho do arquivo
                    }
                };
            }
        } catch (IOException erro) {
            System.out.println("Erro ao criar arquivo. " + erro);
        }
        return out;
    }

    public static ObjectInputStream CriaLeitorBinario(File arquivo) {
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream(arquivo);
            ois = new ObjectInputStream(fis);
        } catch (IOException erro) {
            System.out.println("Erro ao ler arquivo. " + erro);
        }
        return ois;
    }

    public static void EscreveObjeto(ObjectOutputStream oos, Object obj, boolean flush) {
        try {
            oos.writeObject(obj);
            if (flush) {
                oos.flush();
            }
        } catch (IOException erro) {
            System.out.println("Erro na escrita. " + erro);
        }
    }
    
    public static void LeImprimeObjetos(ObjectInputStream ois) {
        int i = 1;
        Object obj = LeObjeto(ois);
        while (obj!= null){
            System.out.print(i++ +" ");
           imprimeCliente((Cliente) obj);
           obj = LeObjeto(ois);
        }
    }

    public static Object LeObjeto(ObjectInputStream ois) {
        Object objlido = null;
        try {
            objlido = ois.readObject();
        } catch (ClassNotFoundException erro) {
            System.err.println("Classe nao encontrada. " + erro);
        } catch (java.io.EOFException erro) {
            System.err.println("Final de arquivo. " + erro);
        } catch (IOException erro) {
            System.err.println("Erro na leitura do objeto. " + erro);
        } finally {
            return objlido;
        }
    }

    public static void imprimeCliente(Cliente cli) {
        if (cli != null) {
            System.out.println(cli.toString());
        } else {
            System.out.println("Cliente nulo.");
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cliente c1 = new Cliente("Zezinho", "3354-2000", 53);
        Cliente c2 = new Cliente("Huginho", "3354-2000", 50);
        Cliente c3 = new Cliente("Luizinho", "3354-2000", 51);
        File arquivo = new File("/home/fabricio/temp/clientes.obj");

        //inicialmente usando programacao sequencial 
        /*FileOutputStream fileout = new FileOutputStream(arquivo, true);
        ObjectOutputStream objout = new ObjectOutputStream(fileout);
        objout.writeObject(c1);
        objout.writeObject(c2);
        objout.writeObject(c3);
        //objout.flush();
        objout.close();
        fileout.close();
        /*
        FileInputStream filein = new FileInputStream(arquivo);
        ObjectInputStream objin = new ObjectInputStream(filein);
        Cliente leitura1 = (Cliente) objin.readObject();
        System.out.println(leitura1.toString());

        Cliente leitura2 = (Cliente) objin.readObject();
        System.out.println(leitura2.toString());

        Cliente leitura3 = (Cliente) objin.readObject();
        System.out.println(leitura3.toString());

        Cliente leitura4 = (Cliente) objin.readObject();
        System.out.println(leitura4.toString());

        objin.close();
        filein.close();
         */
        //Agora usando POO
        ObjectOutputStream saida = CriaEscritorBinario(arquivo, true, false);
        saida.writeObject(c1);
        saida.writeObject(c2);
        saida.writeObject(c3);
        saida.close();

        ObjectInputStream entrada = CriaLeitorBinario(arquivo);
        LeImprimeObjetos(entrada);
        /*Cliente cli1 = (Cliente) LeObjeto(entrada);
        imprimeCliente(cli1);
        Cliente cli2 = (Cliente) LeObjeto(entrada);
        imprimeCliente(cli2);
        Cliente cli3 = (Cliente) LeObjeto(entrada);
        imprimeCliente(cli3);
        Cliente cli4 = (Cliente) LeObjeto(entrada);
        imprimeCliente(cli4);*/
        entrada.close();
    }
}
/**
 * metodo para ser usado na criação de escritores binarios quando for necessario
 * escrever varios objetos em um mesmo arquivo considerando multiplas execuções
 * da aplicação.
 */
/*
    public static ObjectOutputStream CriaEscritorObjeto(File arquivo) {
        ObjectOutputStream out = null;
        try {
            if (arquivo.exists()) {
                FileOutputStream fos = new FileOutputStream(arquivo, true);
                out = new ObjectOutputStream(fos){
                    @Override
                    protected void writeStreamHeader() {
                        // nao escreve o cabeçalho do arquivo
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
    }*/
