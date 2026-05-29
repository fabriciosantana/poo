import java.util.Scanner;
import java.util.TreeSet;

public class NomesSemDuplicata {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> nomes = new TreeSet<>();

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");

        while(true) {
            System.out.println("> ");
            String entrada = scanner.nextLine().trim();

            if (entrada.equalsIgnoreCase("fim")) break;

            nomes.add(entrada.substring(0, 1).toUpperCase() + entrada.substring(1).toLowerCase());
        }

        System.out.println("\nNomes cadastrados");
        System.out.println(nomes);

        System.out.println("\nPesquisar nomes(digite 'sair' para encerrar):");
        while (true) {
            System.out.println("> ");
            String busca = scanner.nextLine().trim();

            if (busca.equalsIgnoreCase("sair")) break;

            String buscaNormalizada = busca.substring(0, 1).toUpperCase() + busca.substring(1).toLowerCase();

            if (nomes.contains(buscaNormalizada)) {
                System.out.println("Nome encontrado.");
            } else {
                System.out.println("Nome não encontrado.");
            }
        }

        scanner.close();
    }
}