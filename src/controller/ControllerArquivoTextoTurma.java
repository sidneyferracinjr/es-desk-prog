/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Turma;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ControllerArquivoTextoTurma extends ControllerArquivoTexto {

    private ArrayList<Turma> turmas = new ArrayList<Turma>();
    protected Turma turma = new Turma();

    public boolean escreverTurma(boolean append) {
        boolean aux = false;
        for (int i = 0; i < turmas.size(); i++) {
            Turma turma = turmas.get(i);
            String texto = turma.getNome() + ";" + turma.getCodigo() + ";" + turma.getAlunos() + "--";
            setTexto(texto);
            if (i == 0) {
                aux = (escrever(false));
            } else {
                aux = (escrever(append));
            }
        }
        return aux;
    }
    
    public boolean lerTurma() {
        turmas = new ArrayList<Turma>();
        if (ler()) {
            String conteudo = getTexto();
            StringTokenizer linha = new StringTokenizer(conteudo, "--");
            while (linha.hasMoreTokens()) {
                StringTokenizer registro = new StringTokenizer(linha.nextToken(), ";");
                Turma alu = new Turma();
                alu.setNome(registro.nextToken());
                alu.setCodigo(Integer.parseInt(registro.nextToken()));
                alu.setAlunos(registro.nextToken());
                getTurmas().add(alu);
            }
            return true;
        } else {
            return false;
        }
    }
    
    public void gravarTurma() {
        String aux = turma.getNome() + ";" + turma.getCodigo() + ";" + turma.getAlunos();
        setTexto(aux);
        setArquivo("Salvar");
        escrever(true);
    }
    
public boolean alterarTurma(int codigo, String novoNome, int novoCodigo, String novoAluno) {
    // Passo 1: Encontrar o turma a ser alterado
    Turma turmaAlterado = null;
    for (Turma turma : turmas) {
        if (turma.getCodigo() == codigo) {
            turmaAlterado = turma;
            break;
        }
    }

    // Se o turma não for encontrado, retornar falso
    if (turmaAlterado == null) {
        System.out.println("Turma com codigo " + codigo + " não encontrado.");
        return false;
    }

    // Passo 2: Atualizar os dados do turma encontrado
    turmaAlterado.setNome(novoNome);
    turmaAlterado.setCodigo(novoCodigo);
    turmaAlterado.setAlunos(novoAluno);

    // Passo 3: Atualizar o arquivo com a lista modificada
    return escreverTurma(false); // Sobrescrever o arquivo com a lista atualizada
}

    
    public boolean excluirTurma(int codigo) {
        // turma a ser removido
        Turma turmaRemovido = null;
        for (Turma turma : turmas) {
            if (turma.getCodigo() == codigo) {
                turmaRemovido = turma;
                break;
            }
        }

        // se o turma não for encontrado, retornar falso
        if (turmaRemovido == null) {
            System.out.println("Turma com codigo " + codigo + " não encontrado.");
            return false;
        }

        // Passo 2: Remover o turma da lista
        turmas.remove(turmaRemovido);

        // Passo 3: Reescrever o arquivo sem o turma excluído
        if (turmas.isEmpty()) {
            // Se a lista estiver vazia após a remoção, limpar o arquivo
            setTexto("");
            return escrever(false); // Sobrescrever o arquivo com conteúdo vazio
        } else {
            // Reescrever a lista atualizada no arquivo
            return escreverTurma(false); // Sobrescrever o arquivo com a lista atualizada
        }
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(ArrayList<Turma> turmas) {
        this.turmas = turmas;
    }
    
    public Turma getTurma() {
        return turma;
    }

    public void setTurma(String nome, int codigo, String alunos) {
        this.turma.setNome(nome);
        this.turma.setCodigo(codigo);
        this.turma.setAlunos(alunos);
    } 

}
