public class CalculadoraJuros {

    private double capital;
    private double taxaDeJuros;
    private int periodo;

    public CalculadoraJuros(double capital, double taxaDeJuros, int periodo) {
        this.capital = capital;
        this.taxaDeJuros = taxaDeJuros;
        this.periodo = periodo;
    }

    public double calcularJurosSimples() {
        return capital * taxaDeJuros * periodo;
    }

    public double calcularJurosCompostos() {
        return capital * Math.pow((1 + taxaDeJuros), periodo) - capital;
    }

    public double calcularMontanteJurosSimples() {
        return capital + calcularJurosSimples();
    }

    public double calcularMontanteJurosCompostos() {
        return capital + calcularJurosCompostos();
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public double getTaxaDeJuros() {
        return taxaDeJuros;
    }

    public void setTaxaDeJuros(double taxaDeJuros) {
        this.taxaDeJuros = taxaDeJuros;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public static void main(String[] args) {
        CalculadoraJuros calculadora = new CalculadoraJuros(1000, 0.05, 2);

        System.out.println("Juros Simples: " + calculadora.calcularJurosSimples());
        System.out.println("Montante com Juros Simples: " + calculadora.calcularMontanteJurosSimples());

        System.out.println("Juros Compostos: " + calculadora.calcularJurosCompostos());
        System.out.println("Montante com Juros Compostos: " + calculadora.calcularMontanteJurosCompostos());
    }
}
