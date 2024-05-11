package main.set.ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> listaDeAlunos;

    public GerenciadorAlunos(){
        this.listaDeAlunos = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double media){
        listaDeAlunos.add(new Aluno(nome, matricula, media));
    }

    public void listavVazia(){
        System.out.println("A lista está vazia");
    }

    public void removerAluno(long matricula){
        Aluno alunoRemovido = null;
        if(!listaDeAlunos.isEmpty()){
            for (Aluno a : listaDeAlunos){
                if (a.getMatricula() == matricula){
                    alunoRemovido = a;
                    break;
                }
            }
            listaDeAlunos.remove(alunoRemovido);
        } else {
            listavVazia();
        }

        if (alunoRemovido == null){
            System.out.println("Matricula não encontrada");
        }
    }

    public void exibirAlunos(){
        if (!listaDeAlunos.isEmpty()) {
            System.out.println(listaDeAlunos);
        } else {
            listavVazia();
        }
    }

    public void exibirAlunosPorNome(){
        Set<Aluno> alunosPorNome = new TreeSet<>(listaDeAlunos);
        if (!listaDeAlunos.isEmpty()){
            System.out.println(alunosPorNome);
        } else {
            listavVazia();
        }
    }

    public void exibirAlunoPorNota(){
        Set<Aluno> alunosPorNota = new TreeSet<>(new CompararPorNota());
        if(!listaDeAlunos.isEmpty()){
            alunosPorNota.addAll(listaDeAlunos);
            System.out.println(alunosPorNota);
        } else {
            listavVazia();
        }
    }

    public static void main(String[] args) {
        GerenciadorAlunos listaAlunos = new GerenciadorAlunos();

        listaAlunos.exibirAlunos();

        listaAlunos.adicionarAluno("Fábio", 3L, 8.5);
        listaAlunos.adicionarAluno("Alexandre", 1L, 9.5);
        listaAlunos.adicionarAluno("Igor", 2L, 9.0);

        System.out.println("Lista de Alunos: ");
        listaAlunos.exibirAlunos();

        listaAlunos.exibirAlunosPorNome();
        listaAlunos.exibirAlunoPorNota();

        listaAlunos.removerAluno(2L);

        // Conferir erro no número da matricula
        listaAlunos.removerAluno(4L);
        listaAlunos.exibirAlunos();
    }
}
