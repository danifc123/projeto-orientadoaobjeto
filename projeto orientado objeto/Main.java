import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        CarteiraInvestimentos carteira = new CarteiraInvestimentos();
        List<CalculadoraFinanciamento> financiamentos = new ArrayList<>();
        List<Patrimonio> patrimonios = new ArrayList<>();
        List<ContaBancaria> contasBancarias = new ArrayList<>();

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Calcular Juros");
            System.out.println("2. Projetar Investimento");
            System.out.println("3. Gerenciar Carteira de Investimentos");
            System.out.println("4. Calcular Financiamento");
            System.out.println("5. Simular Financiamento");
            System.out.println("6. Calcular Patrimônio Líquido");
            System.out.println("7. Criar Conta Bancária");
            System.out.println("8. Excluir Conta Bancária");
            System.out.println("9. Associar Patrimônio a Conta Bancária");
            System.out.println("10. Depositar na Conta Bancária");
            System.out.println("11. Sacar da Conta Bancária");
            System.out.println("12. Sair");

            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    // Calcular Juros
                    calcularJuros(scanner);
                    break;
                case 2:
                    // Projetar Investimento
                    projetarInvestimento(scanner);
                    break;
                case 3:
                    // Gerenciar Carteira de Investimentos
                    gerenciarCarteiraInvestimentos(scanner, carteira);
                    break;
                case 4:
                    // Calcular Financiamento
                    adicionarFinanciamento(scanner, financiamentos);
                    break;
                case 5:
                    // Simular Financiamento
                    simularFinanciamento(scanner, financiamentos);
                    break;
                case 6:
                    // Calcular Patrimônio Líquido
                    exibirPatrimonioLiquido(carteira, financiamentos);
                    break;
                case 7:
                    // Criar Conta Bancária
                    criarContaBancaria(scanner, contasBancarias);
                    break;
                case 8:
                    // Excluir Conta Bancária
                    excluirContaBancaria(scanner, contasBancarias);
                    break;
                case 9:
                    // Associar Patrimônio a Conta Bancária
                    associarPatrimonioConta(scanner, patrimonios, contasBancarias);
                    break;
                case 10:
                    // Depositar na Conta Bancária
                    depositarNaConta(scanner, contasBancarias);
                    break;
                case 11:
                    // Sacar da Conta Bancária
                    sacarDaConta(scanner, contasBancarias);
                    break;
                case 12:
                    // Sair do programa
                    System.out.println("Saindo do programa. Até logo!");
                    break;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }

        } while (escolha != 12);

        // Fechar o scanner
        scanner.close();
    }

    // Métodos anteriores...

    private static void exibirPatrimonioLiquido(CarteiraInvestimentos carteira, List<CalculadoraFinanciamento> financiamentos) {
        double totalInvestimentos = carteira.calcularTotalInvestimentos();
        double totalFinanciamentos = calcularTotalFinanciamentos(financiamentos);
    
        double patrimonioLiquido = totalInvestimentos - totalFinanciamentos;
    
        System.out.printf("Patrimônio Líquido: %.2f%n", patrimonioLiquido);
    }
    
    private static double calcularTotalFinanciamentos(List<CalculadoraFinanciamento> financiamentos) {
        double totalFinanciamentos = 0;
    
        for (CalculadoraFinanciamento financiamento : financiamentos) {
            totalFinanciamentos += financiamento.calcularTotalRecebido(); // Ajustar conforme a lógica desejada
        }
    
        return totalFinanciamentos;
    }

    private static void simularFinanciamento(Scanner scanner, List<CalculadoraFinanciamento> financiamentos) {
        System.out.println("Digite o número do financiamento a ser simulado: ");
        int numeroFinanciamento = scanner.nextInt();
    
        if (numeroFinanciamento >= 1 && numeroFinanciamento <= financiamentos.size()) {
            CalculadoraFinanciamento financiamento = financiamentos.get(numeroFinanciamento - 1);
            double prestacaoMensal = financiamento.calcularPrestacaoMensal();
    
            System.out.printf("Simulação do Financiamento %d:%n", numeroFinanciamento);
            System.out.printf("Prestação Mensal: %.2f%n", prestacaoMensal);
        } else {
            System.out.println("Financiamento não encontrado.");
        }
    }

    private static void adicionarFinanciamento(Scanner scanner, List<CalculadoraFinanciamento> financiamentos) {
        System.out.println("Digite o valor principal do financiamento: ");
        double valorPrincipal = scanner.nextDouble();
    
        System.out.println("Digite a taxa de juros anual (em percentual): ");
        double taxaDeJurosAnual = scanner.nextDouble();
    
        System.out.println("Digite o número de parcelas: ");
        int numeroParcelas = scanner.nextInt();
    
        CalculadoraFinanciamento financiamento = new CalculadoraFinanciamento(valorPrincipal, taxaDeJurosAnual, numeroParcelas);
        financiamentos.add(financiamento);
    
        System.out.println("Financiamento adicionado com sucesso.");
    }

    private static void gerenciarCarteiraInvestimentos(Scanner scanner, CarteiraInvestimentos carteira) {
        int escolhaCarteira;
        do {
            System.out.println("Escolha uma opção para a Carteira de Investimentos:");
            System.out.println("1. Adicionar Ativo");
            System.out.println("2. Remover Ativo");
            System.out.println("3. Exibir Carteira");
            System.out.println("4. Voltar ao menu principal");
    
            escolhaCarteira = scanner.nextInt();
    
            switch (escolhaCarteira) {
                case 1:
                    carteira.adicionarAtivo(scanner);
                    break;
                case 2:
                    System.out.println("Digite o nome do ativo a ser removido: ");
                    String nomeAtivo = scanner.next();
                    carteira.removerAtivo(nomeAtivo);
                    break;
                case 3:
                    carteira.exibirCarteira();
                    break;
                case 4:
                    System.out.println("Retornando ao menu principal.");
                    break;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        } while (escolhaCarteira != 4);
    }

    private static void projetarInvestimento(Scanner scanner) {
        System.out.println("Digite o capital inicial: ");
        double capitalInicial = scanner.nextDouble();

        System.out.println("Digite a taxa de retorno anual (em decimal): ");
        double taxaDeRetornoAnual = scanner.nextDouble();

        System.out.println("Digite o período de projeção (em anos): ");
        int periodo = scanner.nextInt();

        ProjecaoInvestimento projecao = new ProjecaoInvestimento(capitalInicial, taxaDeRetornoAnual, periodo);

        projecao.projetarInvestimento();
    }


private static void calcularJuros(Scanner scanner) {
    System.out.println("Digite o capital inicial: ");
    double capital = scanner.nextDouble();

    System.out.println("Digite a taxa de juros (em decimal): ");
    double taxaDeJuros = scanner.nextDouble();

    System.out.println("Digite o período (em anos): ");
    int periodo = scanner.nextInt();

    System.out.println("Escolha o tipo de juros (1 para Juros Simples, 2 para Juros Compostos): ");
    int tipoDeJuros = scanner.nextInt();

    CalculadoraJuros calculadora = new CalculadoraJuros(capital, taxaDeJuros, periodo);

    switch (tipoDeJuros) {
        case 1:
            System.out.println("Juros Simples: " + calculadora.calcularJurosSimples());
            System.out.println("Montante com Juros Simples: " + calculadora.calcularMontanteJurosSimples());
            break;
        case 2:
            System.out.println("Juros Compostos: " + calculadora.calcularJurosCompostos());
            System.out.println("Montante com Juros Compostos: " + calculadora.calcularMontanteJurosCompostos());
            break;
        default:
            System.out.println("Escolha inválida. Por favor, escolha 1 ou 2 para o tipo de juros.");
    }
}

    private static void criarContaBancaria(Scanner scanner, List<ContaBancaria> contasBancarias) {
        System.out.println("Digite o nome do banco para a nova conta: ");
        String nomeBanco = scanner.next();

        ContaBancaria novaConta = ContaBancaria.criarConta(nomeBanco);
        contasBancarias.add(novaConta);

        System.out.println("Conta bancária criada com sucesso. Número da conta: " + novaConta.getNumeroConta());
    }

    private static void excluirContaBancaria(Scanner scanner, List<ContaBancaria> contasBancarias) {
        System.out.println("Digite o número da conta bancária a ser excluída: ");
        int numeroConta = scanner.nextInt();

        ContaBancaria contaParaExcluir = encontrarContaPorNumero(contasBancarias, numeroConta);

        if (contaParaExcluir != null) {
            contasBancarias.remove(contaParaExcluir);
            System.out.println("Conta bancária excluída com sucesso.");
        } else {
            System.out.println("Conta bancária não encontrada.");
        }
    }

    private static ContaBancaria encontrarContaPorNumero(List<ContaBancaria> contasBancarias, int numeroConta) {
        for (ContaBancaria conta : contasBancarias) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }

    private static void associarPatrimonioConta(Scanner scanner, List<Patrimonio> patrimonios, List<ContaBancaria> contasBancarias) {
        System.out.println("Digite o valor do patrimônio a ser associado: ");
        double valorPatrimonio = scanner.nextDouble();

        System.out.println("Digite o número da conta bancária para associação: ");
        int numeroConta = scanner.nextInt();

        ContaBancaria contaAssociada = encontrarContaPorNumero(contasBancarias, numeroConta);

        if (contaAssociada != null) {
            Patrimonio novoPatrimonio = new Patrimonio(valorPatrimonio, contaAssociada);
            patrimonios.add(novoPatrimonio);
            System.out.println("Patrimônio associado à conta bancária com sucesso.");
        } else {
            System.out.println("Conta bancária não encontrada.");
        }
    }

    private static void depositarNaConta(Scanner scanner, List<ContaBancaria> contasBancarias) {
        System.out.println("Digite o número da conta bancária para depósito: ");
        int numeroConta = scanner.nextInt();

        ContaBancaria contaParaDeposito = encontrarContaPorNumero(contasBancarias, numeroConta);

        if (contaParaDeposito != null) {
            System.out.println("Digite o valor para depósito: ");
            double valorDeposito = scanner.nextDouble();
            contaParaDeposito.depositar(valorDeposito);
        } else {
            System.out.println("Conta bancária não encontrada.");
        }
    }

    private static void sacarDaConta(Scanner scanner, List<ContaBancaria> contasBancarias) {
        System.out.println("Digite o número da conta bancária para saque: ");
        int numeroConta = scanner.nextInt();

        ContaBancaria contaParaSaque = encontrarContaPorNumero(contasBancarias, numeroConta);

        if (contaParaSaque != null) {
            System.out.println("Digite o valor para saque: ");
            double valorSaque = scanner.nextDouble();
            contaParaSaque.sacar(valorSaque);
        } else {
            System.out.println("Conta bancária não encontrada.");
        }
    }
}
