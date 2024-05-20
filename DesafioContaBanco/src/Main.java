import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Conta cc = new Conta();
        Conta cc2 = new Conta();
        int opcao = -1;

        while (opcao != 0) {
            String exibeMenu = """
                    Escolha uma opção:
                    1. Depositar
                    2. Sacar
                    3. Transferir
                    4. Exibir Informações da Conta
                    5. Exibir Histórico
                                        
                    0. Encerrar Sessão
                    """;

            System.out.println(exibeMenu);
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor a ser depositado.");
                    double valorDeposito = input.nextDouble();
                    cc.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.println("Digite o valor a ser sacado.");
                    double valorSaque = input.nextDouble();
                    cc.sacar(valorSaque);
                    break;
                case 3:
                    System.out.println("Digite o valor a ser transferido.");
                    double valorTransferencia = input.nextDouble();
                    cc.transferir(valorTransferencia, cc2);
                    break;
                case 4:
                    cc.exibirInfos();
                    break;
                case 5:
                    cc.exibirHistorico();
                    break;
                case 0:
                    System.out.println("Encerrando sessão...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}