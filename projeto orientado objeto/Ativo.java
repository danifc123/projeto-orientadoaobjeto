public class Ativo {
    private String nome;
    private double valor;

    public Ativo(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Ativo{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                '}';
    }
}