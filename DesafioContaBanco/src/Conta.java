import java.util.ArrayList;
import java.util.List;

public class Conta {
    private int agencia;
    private int numeroConta;
    private double saldo;
    private List<String> historico;
    private static final int AGENCIA_DIGITAL = 0;
    private static int SEQUENCIAL = 1;

    public Conta() {
        this.agencia = Conta.AGENCIA_DIGITAL;
        this.numeroConta = SEQUENCIAL++;
        this.saldo = 0;
        this.historico = new ArrayList<>();
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void sacar(double valor){
        if (valor > this.saldo){
            System.out.println("Saldo insuficiente para saque. Saldo atual: R$ " + this.saldo);
        } else {
            this.saldo -= valor;
            System.out.println("Saque no valor de R$ " + valor + " realizado. Saldo atual: R$ " + this.saldo);
            historico.add("+ Saque: R$ " + valor);
        }
    }

    public void depositar(double valor){
        if (valor > 0){
            this.saldo += valor;
            System.out.println("Saldo atual: R$ " + this.saldo);
            historico.add("- Depósito: R$ " + valor);
        } else {
            System.out.println("Operação não realizada.");
        }
    }

    public void transferir(double valor, Conta contaDestino){
        if (this.saldo >= valor){
            this.saldo -= valor;
            contaDestino.saldo += valor;
            System.out.println("Transferência no valor de R$ " + valor + " realizada com sucesso. Saldo atual: R$ " + this.saldo);
            historico.add("- Transferência: R$ " + valor);
        } else {
            System.out.println("Saldo insuficiente para transferência. Saldo atual: R$ " + this.saldo);
        }
    }

    public void exibirInfos(){
        System.out.printf("*** Dados da conta ***\n" +
                "Agência: %d\n" +
                "Conta: %d\n" +
                "Saldo: R$ %.2f\n", this.agencia, this.numeroConta, this.saldo);
    }

    public void exibirHistorico(){
        System.out.println("Histórico de Transações");
        for (String transacao : historico){
            System.out.println(transacao);
        }
    }
}
