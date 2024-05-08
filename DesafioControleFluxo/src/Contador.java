import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.println("Digite o primeiro parâmetro");
      int parametroUm = input.nextInt();
      System.out.println("Digite o segundo parâmetro");
      int parametroDois = input.nextInt();

      try {
        //chamando o método contendo a lógica de contagem
        contar(parametroUm, parametroDois);
      }catch (ParametrosInvalidosException e) {
        System.out.println(e.getMessage());
      }

    }
    static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException {
      //validar se parametroUm é MAIOR que parametroDois e lançar a exceção
      if (parametroUm > parametroDois) {
        throw new ParametrosInvalidosException();
      } else {
        int contagem = parametroDois - parametroUm;
        //realizar o for para imprimir os números com base nos parâmetros
        for (int i = 1; i <= contagem; i++) {
          System.out.println("Imprimindo o número " + i);
        }
      }
    }
}
