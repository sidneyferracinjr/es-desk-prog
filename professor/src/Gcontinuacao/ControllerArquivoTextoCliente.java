/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gcontinuacao;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author fabricio
 */
public class ControllerArquivoTextoCliente extends ControllerArquivoTexto {

    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public boolean lerCliente() {
        clientes = new ArrayList<Cliente>();
        if (ler()) {
            String conteudo = getTexto();
            StringTokenizer linha = new StringTokenizer(conteudo, "--");
            while (linha.hasMoreTokens()) {
                StringTokenizer registro = new StringTokenizer(linha.nextToken(), ";");
                Cliente cli = new Cliente();
                cli.setNome(registro.nextToken());
                cli.setZap(registro.nextToken());
                cli.setEmail(registro.nextToken());
                getClientes().add(cli);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean escreverCliente(boolean append) {
        boolean aux = false;
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            String texto = cliente.getNome() + ";" + cliente.getZap() + ";" + cliente.getEmail() + "--";
            setTexto(texto);
            if (i == 0) {
                aux = (escrever(false));
            } else {
                aux = (escrever(append));
            }
        }
        return aux;
    }

    /**
     * @return the clientes
     */
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

}
