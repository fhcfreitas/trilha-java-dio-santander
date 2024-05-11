package main.set.ordenacao;

import main.list.ordenacao.Pessoa;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
    private Set<Produto> listaDeProdutos;

    public CadastroProdutos() {
        this.listaDeProdutos = new HashSet<>();
    }

    public void adicionarProduto(long cod, String nome, double preco, int quantidade) {
        listaDeProdutos.add(new Produto(cod, nome, preco, quantidade));
    }

    public void exibirProdutosPorNome() {
        Set<Produto> produtosPorNome = new TreeSet<>(listaDeProdutos);
        if (!listaDeProdutos.isEmpty()) {
            System.out.println(produtosPorNome);
        } else {
            System.out.println("A lista de produtos está vazia");
        }
    }

        public void exibirProdutoPorPreco() {
            Set<Produto> produtosPorPreco = new TreeSet<>(new CompararPorPreco());
            if (!listaDeProdutos.isEmpty()) {
                produtosPorPreco.addAll(listaDeProdutos);
                System.out.println(produtosPorPreco);
            } else {
                System.out.println("A lista de produtos está vazia");
            }
        }

    public static void main(String[] args) {
        CadastroProdutos listaDeProdutos = new CadastroProdutos();

        listaDeProdutos.exibirProdutosPorNome();

        listaDeProdutos.adicionarProduto(1, "TV", 2500.00, 3);
        listaDeProdutos.adicionarProduto(2, "Celular", 4000.00, 1);
        listaDeProdutos.adicionarProduto(3, "Fones Sem Fio", 1000.00, 8);

        // Teste de código do produto
        listaDeProdutos.adicionarProduto(1, "Fones Sem Fio", 1000.00, 8);

        listaDeProdutos.exibirProdutosPorNome();

        listaDeProdutos.exibirProdutoPorPreco();

    }
}
