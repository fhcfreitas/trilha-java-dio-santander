package main.set.operacoesBasicas;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> alunos;

    public GerenciadorAlunos(){
        this.alunos = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double media){
        alunos.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(Long matricula){
        Aluno alunoRemovido = null;
        if (!alunos.isEmpty()) {
            for (Aluno a : alunos) {
                if (a.getMatricula().equals(matricula)) {
                    alunoRemovido = a;
                    break;
                }
            }
            alunos.remove(alunoRemovido);
        } else {
            throw new RuntimeException("A lista de alunos está vazia");
        }
    }

    public void exibirAlunosPorNome(){
        Set<Aluno> alunosPorNome = new TreeSet<>(alunos);
        if (!alunos.isEmpty()){
            System.out.println(alunosPorNome);
        } else {
            System.out.println("A lista está vazia");
        }
    }

    public void exibirAlunosPorNota(){
        Set<Aluno> alunosPorNota = new TreeSet<>(new CompararPorNota());
        if(!alunos.isEmpty()) {
            alunosPorNota.addAll(alunos);
            System.out.println(alunosPorNota);
        } else {
            System.out.println("A lista está vazia");
        }
    }

    public static void main(String[] args) {
        GerenciadorAlunos listaAlunos = new GerenciadorAlunos();

        listaAlunos.adicionarAluno("Fabio", 1L, 8);
        listaAlunos.adicionarAluno("Alexandre", 2L, 9);
        listaAlunos.adicionarAluno("Igor", 3L, 7);

        listaAlunos.exibirAlunosPorNome();
        listaAlunos.exibirAlunosPorNota();
        listaAlunos.removerAluno(2L);
        listaAlunos.exibirAlunosPorNome();

    }

}
