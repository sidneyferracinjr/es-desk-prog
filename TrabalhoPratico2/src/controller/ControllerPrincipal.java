/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.ControllerDiretorio;
import java.io.File;

/**
 *
 * @author sidneyferracinjr
 */
public class ControllerPrincipal {
    
    ControllerDiretorio controllerDiretorio = new ControllerDiretorio();
    /**
     * Gera informações detalhadas sobre um diretório fornecido.
     * 
     * Este método retorna informações como o nome do diretório, caminho absoluto,
     * tamanho em bytes e a data da última modificação. Essas informações são formatadas
     * em um texto estruturado, ideal para exibição ou impressão.
     * 
     * @param diretorio O diretório que será analisado. Deve ser um objeto {@code File} representando um diretório válido.
     * @return Uma {@code String} contendo as informações do diretório, incluindo:
     *         - Nome do diretório
     *         - Caminho absoluto
     *         - Tamanho em bytes
     *         - Data da última modificação
     * @throws IllegalArgumentException Se o parâmetro {@code diretorio} for nulo ou não for um diretório válido.
     */
    public String prepararDiretorio(String salvarEm) {
        File pastaApontada = new File(salvarEm);
        try {
            controllerDiretorio.selecionarDiretorio(pastaApontada);

            // Selecionando diretório
            String diretorioSelecionado = controllerDiretorio.selecionarDiretorio(ControllerDiretorio.getCaminhoDiretorioSelecionado());

            // Lendo informações do diretório
            String leituraPasta = controllerDiretorio.lerDiretorio();

            // Verificando e criando subdiretório
            if (diretorioSelecionado != null && !diretorioSelecionado.isEmpty()) {
                boolean sucesso = controllerDiretorio.criarDiretorio(diretorioSelecionado, "teste");
                if (!sucesso) {
                    System.err.println("Não foi possível criar o subdiretório 'teste'.");
                }
            }

            return leituraPasta;

        } catch (IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
            throw new RuntimeException("Erro ao preparar o diretório.", e);
        }
    }

}
