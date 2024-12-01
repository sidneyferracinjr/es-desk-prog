/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Aluno;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ControllerArquivoTextoAluno extends ControllerArquivoTexto {

    private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    protected Aluno aluno = new Aluno();

    public boolean escreverAluno(boolean append) {
        boolean aux = false;
        for (int i = 0; i < alunos.size(); i++) {
            Aluno aluno = alunos.get(i);
            String texto = aluno.getNome() + ";" + aluno.getMatricula() + ";" + aluno.getTurma() + "--";
            setTexto(texto);
            if (i == 0) {
                aux = (escrever(false));
            } else {
                aux = (escrever(append));
            }
        }
        return aux;
    }
    
    public boolean lerAluno() {
        alunos = new ArrayList<Aluno>();
        if (ler()) {
            String conteudo = getTexto();
            StringTokenizer linha = new StringTokenizer(conteudo, "--");
            while (linha.hasMoreTokens()) {
                StringTokenizer registro = new StringTokenizer(linha.nextToken(), ";");
                Aluno alu = new Aluno();
                alu.setNome(registro.nextToken());
                alu.setMatricula(Integer.parseInt(registro.nextToken()));
                alu.setTurma(registro.nextToken());
                getAlunos().add(alu);
            }
            return true;
        } else {
            return false;
        }
    }
    
    public void gravarAluno() {
        String aux = aluno.getNome() + ";" + aluno.getMatricula() + ";" + aluno.getTurma();
        setTexto(aux);
        setArquivo("Salvar");
        escrever(true);
    }
    
public boolean alterarAluno(int matricula, String novoNome, int novaMatricula, String novaTurma) {
    // Passo 1: Encontrar o aluno a ser alterado
    Aluno alunoAlterado = null;
    for (Aluno aluno : alunos) {
        if (aluno.getMatricula() == matricula) {
            alunoAlterado = aluno;
            break;
        }
    }

    // Se o aluno não for encontrado, retornar falso
    if (alunoAlterado == null) {
        System.out.println("Aluno com matrícula " + matricula + " não encontrado.");
        return false;
    }

    // Passo 2: Atualizar os dados do aluno encontrado
    alunoAlterado.setNome(novoNome);
    alunoAlterado.setMatricula(novaMatricula);
    alunoAlterado.setTurma(novaTurma);

    // Passo 3: Atualizar o arquivo com a lista modificada
    return escreverAluno(false); // Sobrescrever o arquivo com a lista atualizada
}

    
    public boolean excluirAluno(int matricula) {
        // aluno a ser removido
        Aluno alunoRemovido = null;
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula() == matricula) {
                alunoRemovido = aluno;
                break;
            }
        }

        // se o aluno não for encontrado, retornar falso
        if (alunoRemovido == null) {
            System.out.println("Aluno com matrícula " + matricula + " não encontrado.");
            return false;
        }

        // Passo 2: Remover o aluno da lista
        alunos.remove(alunoRemovido);

        // Passo 3: Reescrever o arquivo sem o aluno excluído
        if (alunos.isEmpty()) {
            // Se a lista estiver vazia após a remoção, limpar o arquivo
            setTexto("");
            return escrever(false); // Sobrescrever o arquivo com conteúdo vazio
        } else {
            // Reescrever a lista atualizada no arquivo
            return escreverAluno(false); // Sobrescrever o arquivo com a lista atualizada
        }
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }
    
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(String nome, int matricula, String turma) {
        this.aluno.setNome(nome);
        this.aluno.setMatricula(matricula);
        this.aluno.setTurma(turma);
    } 

}
