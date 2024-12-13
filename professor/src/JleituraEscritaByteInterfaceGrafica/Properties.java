/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JleituraEscritaByteInterfaceGrafica;

import java.io.Serializable;

/**
 *
 * @author fabricio
 */
public class Properties implements Serializable {

    private static final long serialVersionUID = 1;

    private String pastadefault = System.getProperty("user.dir");
    private String arqcliente = "cliente.bin";
    private String arqfornecedor = "fornecedor.bin";
    private String arqproduto = "produto.bin";

    /**
     * @return the pastadefault
     */
    public String getPastadefault() {
        return pastadefault;
    }

    /**
     * @param pastadefault the pastadefault to set
     */
    public void setPastadefault(String pastadefault) {
        this.pastadefault = pastadefault;
    }

    /**
     * @return the arqcliente
     */
    public String getArqcliente() {
        return arqcliente;
    }

    /**
     * @param arqcliente the arqcliente to set
     */
    public void setArqcliente(String arqcliente) {
        this.arqcliente = arqcliente;
    }

    /**
     * @return the arqfornecedor
     */
    public String getArqfornecedor() {
        return arqfornecedor;
    }

    /**
     * @param arqfornecedor the arqfornecedor to set
     */
    public void setArqfornecedor(String arqfornecedor) {
        this.arqfornecedor = arqfornecedor;
    }

    /**
     * @return the arqproduto
     */
    public String getArqproduto() {
        return arqproduto;
    }

    /**
     * @param arqproduto the arqproduto to set
     */
    public void setArqproduto(String arqproduto) {
        this.arqproduto = arqproduto;
    }
    

    public static void main(String[] args) {
        Properties prop = new Properties();

        ControllerArquivoBinario controller = new ControllerArquivoBinario();
        
//        controller.setObject(prop);
//        controller.gravarObject();
    }
}
