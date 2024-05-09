package main.operacoesBasicas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {
    private List<Item> shoppingCart;

    public ShoppingCart() {
        this.shoppingCart = new ArrayList<>();
    }

    public void adicionarItem(String product, double price, int quantity) {
        this.shoppingCart.add(new Item(product, price, quantity));
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        if (!shoppingCart.isEmpty()) {
            for (Item i : shoppingCart) {
                if (i.getProduct().equalsIgnoreCase(nome)) {
                    itensParaRemover.add(i);
                }
            }
            shoppingCart.removeAll(itensParaRemover);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public double calcularValorTotal() {
        double valorTotal = 0;
        if (!shoppingCart.isEmpty()) {
            for (Item item : shoppingCart) {
                valorTotal += item.getPrice() * item.getQuantity();
            }
            return valorTotal;
        } else {
            throw new RuntimeException("A lista está vazia");
        }
    }

    public void exibirItens(){
        System.out.println(shoppingCart);
    }

    public static void main(String[] args) {
        ShoppingCart carrinho = new ShoppingCart();
        Scanner input = new Scanner(System.in);

        carrinho.adicionarItem("Iphone", 1200, 2);
        carrinho.adicionarItem("Galaxy", 1200, 2);
        carrinho.exibirItens();
        System.out.println("Digite o item a ser removido: ");
        String removeItem = input.nextLine();
        carrinho.removerItem(removeItem);
        carrinho.exibirItens();
        carrinho.calcularValorTotal();
    }

}