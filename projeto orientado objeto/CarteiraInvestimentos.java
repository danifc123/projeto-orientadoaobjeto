import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarteiraInvestimentos {
    private List<Ativo> ativos;

    public CarteiraInvestimentos() {
        this.ativos = new ArrayList<>();
    }

    public void adicionarAtivo(Scanner scanner) {
        System.out.println("Digite o nome do ativo: ");
        String nomeAtivo = scanner.next();

        System.out.println("Digite o valor do ativo: ");
        double valorAtivo = scanner.nextDouble();

        Ativo novoAtivo = new Ativo(nomeAtivo, valorAtivo);
        ativos.add(novoAtivo);

        System.out.println("Ativo adicionado à carteira: " + novoAtivo);
    }

    public void removerAtivo(String nomeAtivo) {
        ativos.removeIf(ativo -> ativo.getNome().equalsIgnoreCase(nomeAtivo));
    }

    public void exibirCarteira() {
        System.out.println("Carteira de Investimentos:");
        for (Ativo ativo : ativos) {
            System.out.println(ativo);
        }
    }

    public double calcularTotalInvestimentos() {
        double total = 0;

        for (Ativo ativo : ativos) {
            total += ativo.getValor();
        }

        return total;
    }
}
