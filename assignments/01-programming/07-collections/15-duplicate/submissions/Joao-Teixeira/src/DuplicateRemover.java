import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DuplicateRemover {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> nomes = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("fim")) {
                break;
            }

            if (!input.isEmpty()) {
                String nomeFormatado = input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
                nomes.add(nomeFormatado);
            }
        }

        System.out.println("\nNomes cadastrados:");
        System.out.println(nomes);

        System.out.println("\nPesquisar nomes (digite 'sair' para encerrar):");

        while (true) {
            System.out.print("> ");
            String busca = scanner.nextLine().trim();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            if (nomes.contains(busca)) {
                System.out.println("Nome encontrado.");
            } else {
                System.out.println("Nome não encontrado.");
            }
        }

        scanner.close();
    }
}
