import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class collection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> nomes = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");

        while (true) {
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

        while (true) {
            String pesquisa = scanner.nextLine().trim();

            if (pesquisa.equalsIgnoreCase("sair")) {
                break;
            }

            if (nomes.contains(pesquisa)) {
                System.out.println("Nome encontrado.");
            } else {
                System.out.println("Nome não encontrado.");
            }
        }

        scanner.close();
    }
}
