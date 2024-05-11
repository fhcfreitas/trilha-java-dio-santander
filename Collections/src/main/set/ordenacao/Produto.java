package main.set.ordenacao;

import java.util.Comparator;
import java.util.Objects;
import java.util.PropertyPermission;

public class Produto implements Comparable<Produto>{
    private String nome;
    private Long cod;
    private double preco;
    private int quantidade;

    public Produto( Long cod, String nome, double preco, int quantidade) {
        this.cod = cod;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto produto)) return false;
        return Objects.equals(getCod(), produto.getCod());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCod());
    }

    @Override
    public int compareTo(Produto p) {
        return nome.compareToIgnoreCase(p.getName());
    }

    public String getName() {
        return nome;
    }

    public Long getCod() {
        return cod;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "Produto: " + nome +
                ", cód: " + cod +
                ", preço: " + preco +
                ", qtde: " + quantidade;
    }
}

class CompararPorPreco implements Comparator<Produto> {

    @Override
    public int compare(Produto p1, Produto p2) {
        return Double.compare(p1.getPreco(), p2.getPreco());
    }
}
