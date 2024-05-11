package main.set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> contatos;

    public AgendaContatos() {
        this.contatos = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero) {
        contatos.add(new Contato(nome, numero));
    }

    public void exibirContatos() {
        if (!contatos.isEmpty()) {
            System.out.println(contatos);
        } else {
            System.out.println("A lista de contatos está vazia");
        }
    }

    public Set<Contato> pesquisarPorNome(String nome) {
        Set<Contato> contatosPorNome = new HashSet<>();
        for (Contato c : contatos) {
            if (c.getNome().startsWith(nome)) {
                contatosPorNome.add(c);
            }
        }
        return contatosPorNome;
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero){
        Contato contatoAtualizado = null;
        for (Contato c : contatos){
            if(c.getNome().equalsIgnoreCase(nome)){
                c.setNumero(novoNumero);
                contatoAtualizado = c;
                break;
            }
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos contatos = new AgendaContatos();

        contatos.adicionarContato("Fabio", 1234556);
        contatos.adicionarContato("Alexandre", 5432155);
        contatos.adicionarContato("Alex", 34567878);
        contatos.adicionarContato("Ale", 56678899);
        contatos.exibirContatos();

        System.out.println(contatos.pesquisarPorNome("Ale"));
        System.out.println("Contato atualizado: " + contatos.atualizarNumeroContato("Alexandre", 111111));
        contatos.exibirContatos();
    }

}

