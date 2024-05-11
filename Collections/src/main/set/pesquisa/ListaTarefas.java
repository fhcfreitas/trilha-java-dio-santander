package main.set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> listaTarefas;

    public ListaTarefas(){
        this.listaTarefas = new HashSet<>();
    }

    public void adicionarTarefa(String descricao){
        listaTarefas.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
        Tarefa tarefaRemovida = null;
        if (!listaTarefas.isEmpty()){
            for (Tarefa t : listaTarefas){
                if (t.getDescricao().equalsIgnoreCase(descricao)){
                    tarefaRemovida = t;
                    break;
                }
            }
        } else {
            System.out.println("A lista de tarefas está vazia");
        }
        listaTarefas.remove(tarefaRemovida);
    }

    public void exibirTarefas(){
        if(!listaTarefas.isEmpty()){
            System.out.println(listaTarefas);
        } else {
            System.out.println("Lista de tarefas está vazia");
        }
    }

    public int contarTarefas(){
       return listaTarefas.size();
    }

    public void marcarTarefaConcluida(String descricao){
        for (Tarefa t : listaTarefas){
          if (t.getDescricao().equalsIgnoreCase(descricao)){
              t.setConcluido(true);
          }
      }
    }

    public Set<Tarefa> obterTarefasConcluidas(){
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        for (Tarefa t : listaTarefas){
            if (t.isConcluido() == true){
                tarefasConcluidas.add(t);
            }
        }
        listaTarefas.removeAll(tarefasConcluidas);
        return tarefasConcluidas;
    }

    public void limparListaTarefas() {
        if (!listaTarefas.isEmpty()) {
            listaTarefas.clear();
        } else {
            System.out.println("A lista já está vazia");
        }
    }


    public static void main(String[] args) {
        ListaTarefas tarefas = new ListaTarefas();

        tarefas.adicionarTarefa("Lavar a louça");
        tarefas.adicionarTarefa("Guardar as roupas");
        tarefas.adicionarTarefa("Lavar o carro");
        System.out.println("A lista contém " + tarefas.contarTarefas() + " tarefas a serem feitas: ");
        tarefas.exibirTarefas();

        tarefas.marcarTarefaConcluida("Lavar a louça");

        System.out.println("\nTarefas Concluídas:");
        System.out.println(tarefas.obterTarefasConcluidas());

        System.out.println("\nLista Tarefas a serem feitas:");
        tarefas.exibirTarefas();

        tarefas.limparListaTarefas();

        tarefas.exibirTarefas();
    }
}
