/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;

/**
 *
 * @author sidneyferracinjr
 */
public class ControllerDiretorio {
    
    private static String caminhoDiretorioSelecionado = null;
    private static File diretorioSelecionado = new File(caminhoDiretorioSelecionado);
    
    public boolean criarDiretorio(String diretorio, String subdiretorio) {
        if (diretorio == null || subdiretorio == null) {
            System.out.println("Erro: Caminhos inválidos fornecidos.");
            return false;
        }

        File pasta = new File(diretorio, subdiretorio);

        try {
            if (pasta.mkdirs()) {
                System.out.println("Pasta criada com sucesso.");
                return true;
            } else if (pasta.exists()) {
                System.out.println("Pasta já existe.");
                return true;
            } else {
                System.out.println("Erro desconhecido ao criar pasta.");
                return false;
            }
        } catch (SecurityException e) {
            System.out.println("Erro: Permissão negada para criar pasta.");
            return false;
        }
    }

    
    public String lerDiretorio() {
        if (diretorioSelecionado == null || !diretorioSelecionado.exists()) {
            return "Erro: O arquivo fornecido não existe.";
        }
        
        if (!diretorioSelecionado.isDirectory()) {
            return "Erro: O arquivo fornecido não é um diretório.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(diretorioSelecionado.getName()).append("\n");
        sb.append("Caminho do Diretório: ").append(diretorioSelecionado.getAbsolutePath()).append("\n");

        long tamanho = calcularTamanhoPasta(diretorioSelecionado);
        sb.append("Tamanho da Pasta: ").append(tamanho).append(" bytes").append("\n");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String ultimaAlteracao = sdf.format(new Date(diretorioSelecionado.lastModified()));
        sb.append("Última alteração: ").append(ultimaAlteracao).append("\n");

        return sb.toString();
    }

    private long calcularTamanhoPasta(File pasta) {
        long tamanho = 0;
        File[] arquivos = pasta.listFiles();
        if (arquivos != null) {
            for (File arquivo : arquivos) {
                if (arquivo.isFile()) {
                    tamanho += arquivo.length();
                } else if (arquivo.isDirectory()) {
                    tamanho += calcularTamanhoPasta(arquivo);
                }
            }
        }
        return tamanho;
    }

    public String selecionarDiretorio(String caminhoDiretorio) {
        JFileChooser folderChooser = new JFileChooser();

        if (caminhoDiretorio != null && !caminhoDiretorio.isEmpty()) {
            File diretorioInicial = new File(caminhoDiretorio);
            if (diretorioInicial.exists() && diretorioInicial.isDirectory()) {
                folderChooser.setCurrentDirectory(diretorioInicial);
            }
        }

        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int result = folderChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File pastaSelecionada = folderChooser.getSelectedFile();
            return pastaSelecionada.getAbsolutePath();
        } else {
            if (!pastaSelecionada.exists() || !pastaSelecionada.isDirectory()) {
                throw new IllegalArgumentException("O diretório fornecido não existe ou não é válido.");
            } else{
                            System.out.println("Nenhum diretório selecionado.");
            return null; // Melhor retorno em caso de não seleção
            }
        }
    }


    public static File getDiretorioSelecionado() {
        return diretorioSelecionado;
    }

    public void setDiretorioSelecionado(File diretorioSelecionado) {
        this.diretorioSelecionado = diretorioSelecionado;
    }
    
    public static String getCaminhoDiretorioSelecionado() {
        return caminhoDiretorioSelecionado;
    }

    public void setCaminhoDiretorioSelecionado(String caminhoDiretorioSelecionado) {
        this.caminhoDiretorioSelecionado = caminhoDiretorioSelecionado;
    }
}