package main.map.ordenacao;

import java.util.*;

public class LivrariaOnline {
    Map<String, Livro> catalogoLivros;

    public LivrariaOnline() {
        this.catalogoLivros = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco) {
        catalogoLivros.put(link, new Livro(titulo, autor, preco));
    }

    public void removerLivro(String titulo) {
        List<String> chavesParaRemover = new ArrayList<>();
        if (!catalogoLivros.isEmpty()) {
            for (Map.Entry<String, Livro> entry : catalogoLivros.entrySet()) {
                if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
                    chavesParaRemover.add(entry.getKey());
                }
            }
            for (String chave : chavesParaRemover) {
                catalogoLivros.remove(chave);
            }
        } else {
            System.out.println("A livraria está vazia");
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(catalogoLivros.entrySet());

        Collections.sort(livrosParaOrdenarPorPreco, new CompararPorPreco());

        Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorPreco) {
            livrosOrdenadosPorPreco.put(entry.getKey(), entry.getValue());
        }
        return livrosOrdenadosPorPreco;
    }

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
        Map<String, Livro> livrosPorAutor = new LinkedHashMap<>();
        for (Map.Entry<String, Livro> entry : catalogoLivros.entrySet()) {
            Livro livro = entry.getValue();
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                livrosPorAutor.put(entry.getKey(), entry.getValue());
            }
        }
        return livrosPorAutor;
    }

    public Map<String, Livro> obterLivroMaisCaro() {
        Map<String, Livro> livroMaisCaro = new HashMap<>();
        double maiorPreco = Double.MIN_VALUE;

        if (!catalogoLivros.isEmpty()) {
            for (Livro l : catalogoLivros.values()) {
                if (l.getPreco() > maiorPreco) {
                    maiorPreco = l.getPreco();
                }
            }
        } else {
            throw new NoSuchElementException("O catálogo está vazio");
        }

        for(Map.Entry<String, Livro> entry : catalogoLivros.entrySet()){
            if (entry.getValue().getPreco() == maiorPreco){
                livroMaisCaro.put(entry.getKey(), entry.getValue());
            }
        }
        return livroMaisCaro;
    }

    public void exibirLivros(){
        System.out.println(catalogoLivros);
    }

    public static void main(String[] args) {
        LivrariaOnline livraria = new LivrariaOnline();
        livraria.adicionarLivro("link amazon", "Harry Potter", "JK Rowling", 19.90);
        livraria.adicionarLivro("link mercadolivre", "Dune", "Frank Herbert", 39.90 );
        livraria.adicionarLivro("link amazon2", "Tudo é rio", "Carla Madeira", 25.90);

        livraria.exibirLivros();

        System.out.println("\nLivros Ordenados por Preço:");
        System.out.println(livraria.exibirLivrosOrdenadosPorPreco());

        System.out.println("\nPesquisas Livros de Carla Madeira:");
        System.out.println(livraria.pesquisarLivrosPorAutor("Carla Madeira"));

        System.out.println("\nObter Livro mais caro do catálogo: ");
        System.out.println(livraria.obterLivroMaisCaro());


        livraria.removerLivro("Harry Potter");
        System.out.println("\nLista de Livros sem Harry Potter");
        livraria.exibirLivros();
    }

}


