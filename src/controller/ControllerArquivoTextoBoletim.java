/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Boletim;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ControllerArquivoTextoBoletim extends ControllerArquivoTexto {

    private ArrayList<Boletim> boletins = new ArrayList<Boletim>();
    protected Boletim boletim = new Boletim();

    public boolean escreverBoletim(boolean append) {
        boolean aux = false;
        for (int i = 0; i < boletins.size(); i++) {
            Boletim boletim = boletins.get(i);
            String texto = boletim.getAluno() + ";" + boletim.getMedia() +"--";
            setTexto(texto);
            if (i == 0) {
                aux = (escrever(false));
            } else {
                aux = (escrever(append));
            }
        }
        return aux;
    }
    
    public boolean lerBoletim() {
        boletins = new ArrayList<Boletim>();
        if (ler()) {
            String conteudo = getTexto();
            StringTokenizer linha = new StringTokenizer(conteudo, "--");
            while (linha.hasMoreTokens()) {
                StringTokenizer registro = new StringTokenizer(linha.nextToken(), ";");
                Boletim boletim = new Boletim();
                boletim.setAluno(registro.nextToken());
                boletim.setMedia(Integer.parseInt(registro.nextToken()));
                getBoletins().add(boletim);
            }
            return true;
        } else {
            return false;
        }
    }
    
    public void gravarAluno() {
        String aux = boletim.getAluno() + ";" + boletim.getIdBoletim() + ";" + boletim.getMedia();
        setTexto(aux);
        setArquivo("Salvar");
        escrever(true);
    }
    
public boolean alterarBoletim(int idBoletim, String novoAluno, int novaMedia) {
    // Passo 1: Encontrar o aluno a ser alterado
    Boletim boletimAlterado = null;
    for (Boletim boletim : boletins) {
        if (boletim.getIdBoletim() == idBoletim) {
            boletimAlterado = boletim;
            break;
        }
    }

    // Se o aluno não for encontrado, retornar falso
    if (boletimAlterado == null) {
        System.out.println("Boletim com Id " + idBoletim + " não encontrado.");
        return false;
    }

    // Passo 2: Atualizar os dados do aluno encontrado
    boletimAlterado.setAluno(novoAluno);
    boletimAlterado.setMedia(novaMedia);

    // Passo 3: Atualizar o arquivo com a lista modificada
    return escreverBoletim(false); // Sobrescrever o arquivo com a lista atualizada
}

    
    public boolean excluirBoletim(int idBoletim) {
        // aluno a ser removido
        Boletim boletimRemovido = null;
        for (Boletim boletim : boletins) {
            if (boletim.getIdBoletim() == idBoletim) {
                boletimRemovido = boletim;
                break;
            }
        }

        // se o aluno não for encontrado, retornar falso
        if (boletimRemovido == null) {
            System.out.println("Boletim com Id " + idBoletim + " não encontrado.");
            return false;
        }

        // Passo 2: Remover o aluno da lista
        boletins.remove(boletimRemovido);

        // Passo 3: Reescrever o arquivo sem o aluno excluído
        if (boletins.isEmpty()) {
            // Se a lista estiver vazia após a remoção, limpar o arquivo
            setTexto("");
            return escrever(false); // Sobrescrever o arquivo com conteúdo vazio
        } else {
            // Reescrever a lista atualizada no arquivo
            return escreverBoletim(false); // Sobrescrever o arquivo com a lista atualizada
        }
    }

    public ArrayList<Boletim> getBoletins() {
        return boletins;
    }

    public void setBoletins(ArrayList<Boletim> boletins) {
        this.boletins = boletins;
    }
    
    public Boletim getBoletim() {
        return boletim;
    }

    public void setAluno(int idBoletim, String aluno, float media) {
        this.boletim.setIdBoletim(idBoletim);
        this.boletim.setAluno(aluno);
        this.boletim.setMedia(media);
    } 

}
