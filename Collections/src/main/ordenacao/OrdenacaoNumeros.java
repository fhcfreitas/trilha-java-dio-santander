package main.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros{
    private List<Integer> numeros;

    public OrdenacaoNumeros(){
        this.numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        this.numeros.add(numero);
    }

    public List<Integer> ordernarAscendente(){
        List<Integer> numerosAscendentes = new ArrayList<>(numeros);
        if (!numeros.isEmpty()){
            Collections.sort(numerosAscendentes);
            return numerosAscendentes;
        } else {
            throw new RuntimeException("A lista está vazia");
        }
    }

    public List<Integer> ordernarDescedente(){
        List<Integer> numerosDescendentes = new ArrayList<>(numeros);
        if (!numeros.isEmpty()){
            numeros.sort(Collections.reverseOrder());
            return numerosDescendentes;
        } else {
            throw new RuntimeException("A lista está vazia");
        }
    }

    public void ExibirNumeros(){
        if (!numeros.isEmpty()){
            System.out.println(this.numeros);
        } else {
            throw new RuntimeException("A lista está vazia");
        }
    }

    public static void main(String[] args) {
      OrdenacaoNumeros listaNumeros = new OrdenacaoNumeros();

      listaNumeros.adicionarNumero(1);
      listaNumeros.adicionarNumero(5);
      listaNumeros.adicionarNumero(7);
      listaNumeros.adicionarNumero(2);
      listaNumeros.adicionarNumero(4);

      listaNumeros.ExibirNumeros();

      System.out.println(listaNumeros.ordernarAscendente());
      System.out.println(listaNumeros.ordernarDescedente());
    }

}