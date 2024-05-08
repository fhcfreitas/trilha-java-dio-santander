import java.util.Scanner;

public class ContaTerminal {
    private int numero;
    private String agencia;
    private String nome;
    private double saldo;

    public static void main(String[] args) {
        ContaTerminal conta = new ContaTerminal();
        Scanner input = new Scanner(System.in);

        System.out.println("Bem vindo ao Banco DIO");
        System.out.println("Digite o número da sua conta:");
        conta.numero = input.nextInt();
        System.out.println("Digite a agência da sua conta:");
        conta.agencia = input.next();
        System.out.println("Digite o seu nome:");
        conta.nome = input.next();
        System.out.println("Digite o saldo da sua conta:");
        conta.saldo = input.nextDouble();

        System.out.printf("""
            Data da conta:
            Número: %d
            Agência: %s
            Nome: %s
            Saldo: %.2f
            """, conta.numero, conta.agencia, conta.nome, conta.saldo);
    }
}
