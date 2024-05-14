package main.map.pesquisas;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private Map<String, Integer> palavras;

    public ContagemPalavras() {
        this.palavras = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem){
        palavras.put(palavra, contagem);
    }

    public void removerPalavra(String palavra){
        if (!palavras.isEmpty()){
            if (palavras.containsKey(palavra)) {
                palavras.remove(palavra);
            } else {
                System.out.println("Palavra não consta na lista");
            }
        } else {
            System.out.println("A lista está vazia");
        }
    }

    public void exibirContagemPalavras(){
        if (!palavras.isEmpty()){
            for (Map.Entry<String, Integer> entry : palavras.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        } else {
            System.out.println("A lista está vazia");
        }
    }

    public static void main(String[] args) {
        ContagemPalavras contagemPalavras = new ContagemPalavras();

        // Teste lista vazia
        contagemPalavras.exibirContagemPalavras();

        contagemPalavras.adicionarPalavra("Java", 2);
        contagemPalavras.adicionarPalavra("Ruby", 4);
        contagemPalavras.adicionarPalavra("Kotlin", 3);
        contagemPalavras.adicionarPalavra("C#",1 );
        contagemPalavras.exibirContagemPalavras();

        // Teste palavra não existente
        contagemPalavras.removerPalavra("PHP");

        System.out.println("\nLista sem Ruby: ");
        contagemPalavras.removerPalavra("Ruby");
        contagemPalavras.exibirContagemPalavras();


    }
}
