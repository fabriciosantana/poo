import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class EliminarDuplicados {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Set<String> nomes = new TreeSet<>();

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");

        while (true) {

            System.out.print("> ");
            String nome = sc.nextLine().trim();

            if (nome.equalsIgnoreCase("fim")) {
                break;
            }

            if (!nome.isEmpty()) {

                nome = nome.substring(0, 1).toUpperCase()
                        + nome.substring(1).toLowerCase();

                nomes.add(nome);
            }
        }

        System.out.println("\nNomes cadastrados:");
        System.out.println(nomes);

        System.out.println("\nPesquisar nomes (digite 'sair' para encerrar):");

        while (true) {

            System.out.print("> ");
            String busca = sc.nextLine().trim();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            busca = busca.substring(0, 1).toUpperCase()
                    + busca.substring(1).toLowerCase();

            if (nomes.contains(busca)) {
                System.out.println("Nome encontrado.");
            } else {
                System.out.println("Nome não encontrado.");
            }
        }

        sc.close();
    }
}