import java.util.Scanner;
import java.util.TreeSet;
import java.util.Set;

public class EliminarNomesDuplicados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> nomes = new TreeSet<>();

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");

        while (true) {
            System.out.print("> ");
            String entrada = scanner.nextLine().trim();

            if (entrada.equalsIgnoreCase("fim")) {
                break;
            }

            nomes.add(entrada.toLowerCase());
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

            if (nomes.contains(busca.toLowerCase())) {
                System.out.println("Nome encontrado.");
            } else {
                System.out.println("Nome não encontrado.");
            }
        }

        scanner.close();
    }
}