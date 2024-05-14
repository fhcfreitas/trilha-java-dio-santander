package main.map.pesquisas;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EstoqueProdutos {
    private Map<Long, Produto> estoque;

    public EstoqueProdutos(){
        this.estoque = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco){
        estoque.put(cod, new Produto(nome, quantidade, preco));
    }

    public void exibirProdutos(){
        System.out.println(estoque);
    }

    public double calcularValorTotalEstoque(){
        double valorTotalEstoque = 0d;
        if(!estoque.isEmpty()){
            for(Produto p : estoque.values()){
                valorTotalEstoque += p.getPreco() * p.getQuantidade();
            }
        } return valorTotalEstoque;
    }

    public Produto obterProdutoMaisCaro(){
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;

        if(!estoque.isEmpty()){
            for(Produto p : estoque.values()){
                if(p.getPreco() > maiorPreco){
                    produtoMaisCaro = p;
                }
            }
        }
        return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato(){
        Produto produtoMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;

        for(Produto p : estoque.values()){
            if(p.getPreco() < menorPreco){
                produtoMaisBarato = p;
                menorPreco = p.getPreco();
            }
        }
        return produtoMaisBarato;
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque(){
        Produto produtoMaiorQuantidadeValorTotal = null;
        double maiorValorTotalProduto = 0d;

        if(!estoque.isEmpty()){
            for(Map.Entry<Long, Produto> entry : estoque.entrySet()){
                double valorProdutoEmEstoque = entry.getValue().getPreco() * entry.getValue().getQuantidade();
                if (valorProdutoEmEstoque > maiorValorTotalProduto){
                    maiorValorTotalProduto = valorProdutoEmEstoque;
                    produtoMaiorQuantidadeValorTotal = entry.getValue();
                }
            }
        }
        return produtoMaiorQuantidadeValorTotal;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();

        estoque.adicionarProduto(1L, "Açucar", 2, 5.90);
        estoque.adicionarProduto(3L, "Azeite", 1, 50.50);
        estoque.adicionarProduto(2L, "Arroz", 5, 10.90);

        System.out.println("--- Estoque de Produtos");
        estoque.exibirProdutos();

        System.out.println("\nValor total do estoque");
        System.out.println(estoque.calcularValorTotalEstoque());

        System.out.println("\nProduto Mais Caro");
        System.out.println(estoque.obterProdutoMaisCaro());

        System.out.println("\nProduto com maior valor somado por quantidade no estoque");
        System.out.println(estoque.obterProdutoMaiorQuantidadeValorTotalNoEstoque());

        System.out.println("\nProduto Mais Barato");
        System.out.println(estoque.obterProdutoMaisBarato());
    }
}
