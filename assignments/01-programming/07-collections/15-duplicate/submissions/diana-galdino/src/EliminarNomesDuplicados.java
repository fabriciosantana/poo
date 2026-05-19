import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class EliminarNomesDuplicados {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<String> nomes = new TreeSet<>();

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");

        while (true) {
            System.out.print("> ");
            String nome = scanner.nextLine().trim();

            if (nome.equalsIgnoreCase("fim")) {
                break;
            }

            if (nome.isEmpty()) {
                System.out.println("Nome inválido.");
                continue;
            }

            nome = formatarNome(nome);

            if (nomes.add(nome)) {
                System.out.println("Nome cadastrado.");
            } else {
                System.out.println("Nome já existe.");
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

            busca = formatarNome(busca);

            if (nomes.contains(busca)) {
                System.out.println("Nome encontrado.");
            } else {
                System.out.println("Nome não encontrado.");
            }
        }

        System.out.println("\nPrograma encerrado.");
        scanner.close();
    }

    public static String formatarNome(String nome) {

        nome = nome.toLowerCase();

        return nome.substring(0, 1).toUpperCase()
                + nome.substring(1);
    }
}