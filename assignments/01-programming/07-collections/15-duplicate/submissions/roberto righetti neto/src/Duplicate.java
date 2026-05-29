import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Duplicate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Cria um TreeSet usando a ordem insensível a maiúsculas/minúsculas.
        // Isso garante que nomes duplicados (com diferenças de case) sejam eliminados,
        // mantendo a grafia original do primeiro nome inserido e exibindo-os ordenados.
        Set<String> nomes = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");

        while (true) {
            System.out.print("> ");
            if (!scanner.hasNextLine()) {
                break;
            }
            String entrada = scanner.nextLine().trim();

            if (entrada.equalsIgnoreCase("fim")) {
                break;
            }

            if (!entrada.isEmpty()) {
                nomes.add(entrada);
            }
        }

        System.out.println("\nNomes cadastrados:");
        System.out.println(nomes);

        System.out.println("\nPesquisar nomes (digite 'sair' para encerrar):");

        while (true) {
            System.out.print("> ");
            if (!scanner.hasNextLine()) {
                break;
            }
            String entradaBusca = scanner.nextLine().trim();

            if (entradaBusca.equalsIgnoreCase("sair")) {
                break;
            }

            if (!entradaBusca.isEmpty()) {
                if (nomes.contains(entradaBusca)) {
                    System.out.println("Nome encontrado.");
                } else {
                    System.out.println("Nome não encontrado.");
                }
            }
        }

        scanner.close();
    }
}
