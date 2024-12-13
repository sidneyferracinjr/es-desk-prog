/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HclienteTexto;

import java.util.StringTokenizer;
import HclienteTexto.Cliente;

/**
 *
 * @author fabricio
 */
public class ControllerArquivoTextoCliente extends ControllerArquivoTexto {

    protected Cliente cliente = new Cliente();

    public void lerCliente() {
        setArquivo("Abrir");
        ler();
        String aux = getTexto();

        StringTokenizer tokens = new StringTokenizer(aux, ";");
        //while (tokens.hasMoreTokens()) {
            cliente.setNome(tokens.nextToken());
            cliente.setIdade(Integer.valueOf(tokens.nextToken()));
            cliente.setEmail(tokens.nextToken());
        //}
    }

    public void gravarCliente() {
        String aux = cliente.getNome() + ";" + cliente.getIdade() + ";" + cliente.getEmail();
        setTexto(aux);
        setArquivo("Salvar");
        escrever(true);
    }

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

/**
     * @param
     * 
     */
    public void setCliente(String nome, int idade, String email) {
        this.cliente.setNome(nome);
        this.cliente.setIdade(idade);
        this.cliente.setEmail(email);
    }    
    
}
