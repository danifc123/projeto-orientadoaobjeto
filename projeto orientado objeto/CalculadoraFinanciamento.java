public class CalculadoraFinanciamento {
    private double valorPrincipal;
    private double taxaDeJurosAnual;
    private int numeroParcelas;
    private double totalRecebido;

    public CalculadoraFinanciamento(double valorPrincipal, double taxaDeJurosAnual, int numeroParcelas) {
        this.valorPrincipal = valorPrincipal;
        this.taxaDeJurosAnual = taxaDeJurosAnual;
        this.numeroParcelas = numeroParcelas;
        this.totalRecebido = 0;
    }

    public double calcularPrestacaoMensal() {
        double taxaDeJurosMensal = taxaDeJurosAnual / 12 / 100;
        double prestacaoMensal = (valorPrincipal * taxaDeJurosMensal) /
                (1 - Math.pow(1 + taxaDeJurosMensal, -numeroParcelas));

        totalRecebido += prestacaoMensal; 

        return prestacaoMensal;
    }

    public double calcularTotalRecebido() {
        return totalRecebido;
    }
}
