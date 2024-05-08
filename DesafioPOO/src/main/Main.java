package main;

import dispositivo.Iphone;

public class Main {
  public static void main(String[] args) {
    Iphone iphone = new Iphone();

    iphone.ligar();
    iphone.atender();
    iphone.iniciarCorreioVoz();

    iphone.tocar();
    iphone.pausar();
    iphone.selecionarMusica();

    iphone.exibirPagina();
    iphone.adicionarNovaAba();
    iphone.atualizarPagina();
  }

}
