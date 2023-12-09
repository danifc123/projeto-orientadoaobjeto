public class Patrimonio {
    private double valor;
    private ContaBancaria contaBancaria;

    public Patrimonio(double valor, ContaBancaria contaBancaria) {
        this.valor = valor;
        this.contaBancaria = contaBancaria;
    }

    // Getters e Setters, se necessário

    public void associarConta(ContaBancaria novaConta) {
        this.contaBancaria = novaConta;
    }
}
