import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Doacao {
    private String tipo;
    private double quantidade;
    private LocalDate data;
    private Doador doador;

    public Doacao(String tipo, double quantidade, LocalDate data, Doador doador) {
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.data = data;
        this.doador = doador;
    }

    public double getQuantidade() {
        return quantidade;
    }

    // Getters e Setters para outros campos, se necessário
}

class Doador {
    private String nome;
    private String contato;

    public Doador(String nome, String contato) {
        this.nome = nome;
        this.contato = contato;
    }

    // Getters e Setters para outros campos, se necessário
}

class GerenciadorDoacoes {
    private List<Doacao> listaDoacoes = new ArrayList<>();

    public void adicionarDoacao(Doacao doacao) {
        listaDoacoes.add(doacao);
    }

    public double calcularTotalDoacoes() {
        return listaDoacoes.stream().mapToDouble(Doacao::getQuantidade).sum();
    }
}

public class Main {
    public static void main(String[] args) {
        GerenciadorDoacoes gerenciador = new GerenciadorDoacoes();
        Scanner scanner = new Scanner(System.in);

        // Interface simples para entrada de dados
        while (true) {
            System.out.print("Nome do doador (ou 'sair' para encerrar): ");
            String nome = scanner.nextLine();
            if (nome.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.print("Contato do doador: ");
            String contato = scanner.nextLine();
            Doador doador = new Doador(nome, contato);

            System.out.print("Tipo de doação: ");
            String tipo = scanner.nextLine();
            System.out.print("Quantidade: ");
            double quantidade = scanner.nextDouble();
            scanner.nextLine(); // Consome a nova linha após o número
            LocalDate data = LocalDate.now();

            Doacao doacao = new Doacao(tipo, quantidade, data, doador);
            gerenciador.adicionarDoacao(doacao);

            // Calcular e exibir o total de doações
            double totalDoacoes = gerenciador.calcularTotalDoacoes();
            System.out.println("Total de doações: " + totalDoacoes);
        }

        scanner.close();
    }
}
