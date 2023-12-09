public class ProjecaoInvestimento {

    private double capitalInicial;
    private double taxaDeRetornoAnual;
    private int periodo;

    public ProjecaoInvestimento(double capitalInicial, double taxaDeRetornoAnual, int periodo) {
        this.capitalInicial = capitalInicial;
        this.taxaDeRetornoAnual = taxaDeRetornoAnual;
        this.periodo = periodo;
    }

    public void projetarInvestimento() {
        double montante = capitalInicial;

        System.out.println("Projeção do Investimento ao longo do tempo:");

        for (int i = 1; i <= periodo; i++) {
            montante *= (1 + taxaDeRetornoAnual);
            System.out.printf("Ano %d: %.2f%n", i, montante);
        }
    }

    public double getCapitalInicial() {
        return capitalInicial;
    }

    public void setCapitalInicial(double capitalInicial) {
        this.capitalInicial = capitalInicial;
    }

    public double getTaxaDeRetornoAnual() {
        return taxaDeRetornoAnual;
    }

    public void setTaxaDeRetornoAnual(double taxaDeRetornoAnual) {
        this.taxaDeRetornoAnual = taxaDeRetornoAnual;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
}
