package dispositivo;

import funcionalidades.Celular;
import funcionalidades.Safari;
import funcionalidades.Ipod;

public class Iphone implements Celular, Safari, Ipod {

    public void ligar() {
        System.out.println("Ligando o aparelho celular");
    }

    public void atender() {
        System.out.println("Atendendo ligação");
    }

    public void iniciarCorreioVoz() {
        System.out.println("Iniciando correio de voz");
    }

    public void exibirPagina() {
        System.out.println("Exibindo página no navegador");
    }

    public void adicionarNovaAba() {
        System.out.println("Adicionando nova aba ao navegador");
    }

    public void atualizarPagina() {
        System.out.println("Atualizando página do navegador");
    }

    public void tocar() {
        System.out.println("Tocando música");
    }

    public void pausar() {
        System.out.println("Pausando música");
    }

    public void selecionarMusica() {
        System.out.println("Selecionando música");
    }
}
