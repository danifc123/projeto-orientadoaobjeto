
public class ContaBancaria {
    private static int numeroContaAtual = 1; // Usado para gerar números únicos de conta
    private int numeroConta;
    private double saldoTotal;
    private String nomeBanco;

    public ContaBancaria(String nomeBanco) {
        this.numeroConta = numeroContaAtual++;
        this.saldoTotal = 0.0;
        this.nomeBanco = nomeBanco;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldoTotal() {
        return saldoTotal;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldoTotal += valor;
            System.out.println("Depósito de " + valor + " realizado com sucesso na conta " + numeroConta);
        } else {
            System.out.println("Valor de depósito inválido. O valor deve ser maior que zero.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldoTotal) {
            saldoTotal -= valor;
            System.out.println("Saque de " + valor + " realizado com sucesso na conta " + numeroConta);
        } else {
            System.out.println("Valor de saque inválido ou saldo insuficiente.");
        }
    }

    public static ContaBancaria criarConta(String nomeBanco) {
        return new ContaBancaria(nomeBanco);
    }

    public static void excluirConta(ContaBancaria conta) {
        System.out.println("Conta " + conta.getNumeroConta() + " do banco " + conta.getNomeBanco() + " excluída com sucesso.");
    }
}

