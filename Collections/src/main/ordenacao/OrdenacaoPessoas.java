package main.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenacaoPessoas {
    private List<Pessoa> pessoas;

    public OrdenacaoPessoas(){
        this.pessoas = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura){
        pessoas.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordernarPorIdade(){
        List<Pessoa> pessoasPorIdade = new ArrayList<>(pessoas);
        Collections.sort(pessoasPorIdade);
        return pessoasPorIdade;
    }

    public List<Pessoa> ordernarPorAltura(){
        List<Pessoa> pessoasPorAltura = new ArrayList<>(pessoas);
        Collections.sort(pessoasPorAltura, new CompararPorAltura());
        return pessoas;
    }

    public List<Pessoa> ordernarPorNome(){
        Collections.sort(pessoas);
        return pessoas;
    }


    public static void main(String[] args) {
        OrdenacaoPessoas ordenacaoPessoas = new OrdenacaoPessoas();

        ordenacaoPessoas.adicionarPessoa("Mariana", 25, 1.60);
        ordenacaoPessoas.adicionarPessoa("Filipe", 32, 1.69);
        ordenacaoPessoas.adicionarPessoa("Fabio", 29, 1.70);
        ordenacaoPessoas.adicionarPessoa("Igor", 37, 1.73);
        ordenacaoPessoas.adicionarPessoa("Alexandre", 36, 1.71);

        System.out.println(ordenacaoPessoas.pessoas);

        System.out.println(ordenacaoPessoas.ordernarPorIdade());
        System.out.println(ordenacaoPessoas.ordernarPorAltura());
//        System.out.println(ordenacaoPessoas.ordernarPorNome());
    }
}
