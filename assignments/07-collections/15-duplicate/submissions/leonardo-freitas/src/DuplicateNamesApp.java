import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Cadastro e pesquisa de primeiros nomes sem duplicidade, com comparação
 * independente de maiúsculas e minúsculas.
 *
 * Atividade I2-07: assignments/07-collections/15-duplicate (Java 21).
 */
public final class DuplicateNamesApp {
    private DuplicateNamesApp() {
        // Classe de aplicação: não deve ser instanciada.
    }

    public static void main(String[] args) {
        // A ordenação e a deduplicação usam o mesmo critério case-insensitive.
        // A grafia da primeira ocorrência cadastrada é preservada.
        Set<String> nomes = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8)) {
            System.out.println("Digite os nomes (digite 'fim' para encerrar):");

            while (scanner.hasNextLine()) {
                System.out.print("> ");
                String nome = scanner.nextLine().trim();

                if (nome.equalsIgnoreCase("fim")) {
                    break;
                }
                if (!nome.isEmpty()) {
                    nomes.add(nome);
                }
            }

            System.out.println();
            System.out.println("Nomes cadastrados:");
            System.out.println(nomes);
            System.out.println();
            System.out.println("Pesquisar nomes (digite 'sair' para encerrar):");

            while (scanner.hasNextLine()) {
                System.out.print("> ");
                String pesquisa = scanner.nextLine().trim();

                if (pesquisa.equalsIgnoreCase("sair")) {
                    break;
                }
                System.out.println(nomes.contains(pesquisa)
                        ? "Nome encontrado."
                        : "Nome não encontrado.");
            }
        }
    }
}
