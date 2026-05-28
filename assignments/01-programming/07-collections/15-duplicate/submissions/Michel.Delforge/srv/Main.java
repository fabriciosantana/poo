import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Set<String> nomes = new TreeSet<>();

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");

        while (true) {

            String nome = sc.nextLine().trim();

            if (nome.equalsIgnoreCase("fim")) {
                break;
            }

            nomes.add(nome.toLowerCase());
        }

        System.out.println("\nNomes cadastrados:");

        for (String nome : nomes) {
            System.out.println(nome);
        }

        System.out.println("\nPesquisar nomes (digite 'sair' para encerrar):");

        while (true) {

            String busca = sc.nextLine().trim().toLowerCase();

            if (busca.equals("sair")) {
                break;
            }

            if (nomes.contains(busca)) {
                System.out.println("Nome encontrado.");
            } else {
                System.out.println("Nome não encontrado.");
            }
        }

        sc.close();
    }
}