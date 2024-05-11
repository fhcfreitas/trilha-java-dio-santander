package main.list.pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> catalogoLivros;

    public CatalogoLivros(){
        this.catalogoLivros = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        this.catalogoLivros.add(new Livro(titulo, autor, anoPublicacao));
    }

    public void exibirCatalogo(){
        System.out.println(catalogoLivros);
    }

    public List<Livro> pesquisarPorAutor(String autor) {
        List<Livro> livrosPorAutor = new ArrayList<>();
        if (!catalogoLivros.isEmpty()){
            for (Livro l : catalogoLivros) {
                if(l.getAutor().equalsIgnoreCase(autor)){
                    livrosPorAutor.add(l);
                }
            }
        } else {
            System.out.println("O catálogo está vazio.");
        }
        return livrosPorAutor;
    }

    public List<Livro> pesquisarPorIntervalodDeAno(int anoInicial, int anoFinal){
        List<Livro> livrosPorIntervaloAno = new ArrayList<>();
        if (!catalogoLivros.isEmpty()){
            for (Livro l : catalogoLivros){
                if (l.getAnoPublicacao() >= anoInicial && l.getAnoPublicacao() <= anoFinal){
                    livrosPorIntervaloAno.add(l);
                };
            }
        } else {
            System.out.println("Não há livros nesse período");
        }
        return livrosPorIntervaloAno;
    }

    public Livro pesquisarPorTitulo(String titulo){
        Livro livroPorTitulo = null;
        if (!catalogoLivros.isEmpty()){
            for (Livro l : catalogoLivros){
                if(l.getTitulo().equalsIgnoreCase(titulo)){
                    livroPorTitulo = l;
                    break;
                }
            }
        } else {
            System.out.println("O livro não foi encontrado");
        }
        return livroPorTitulo;
    }


    public static void main(String[] args) {
        CatalogoLivros catalogo = new CatalogoLivros();

        catalogo.adicionarLivro("A culpa é das estrelas","John Green", 2020);
        catalogo.adicionarLivro("Cidades de Papel","John Green", 2015);
        catalogo.adicionarLivro("Harry Potter","J.K. Rowling", 2010);
        catalogo.adicionarLivro("Crepúsculo", "Stephanie Meyer", 2005);
        catalogo.exibirCatalogo();
        System.out.println(catalogo.pesquisarPorTitulo("harry potter"));
        System.out.println(catalogo.pesquisarPorAutor("john green"));
        System.out.println(catalogo.pesquisarPorIntervalodDeAno(2005, 2010));
        System.out.println(catalogo.pesquisarPorTitulo("Crepúsculo"));

    }
}
