import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NameRegistry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Map para manter nomes originais mas garantir case-insensitive (chave = lowercase, valor = original)
        Map<String, String> nomes = new TreeMap<>();

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");
        while (true) {
            System.out.print("> ");
            String entrada = sc.nextLine().trim();

            if (entrada.equalsIgnoreCase("fim")) {
                break;
            }
            if (!entrada.isEmpty()) {
                String chave = entrada.toLowerCase();
                // Só adiciona se não existir ainda
                if (!nomes.containsKey(chave)) {
                    nomes.put(chave, entrada);
                }
            }
        }

        // Exibir nomes cadastrados
        System.out.println("\nNomes cadastrados:");
        System.out.println(nomes.values());

        // Pesquisa de nomes
        System.out.println("\nPesquisar nomes (digite 'sair' para encerrar):");
        while (true) {
            System.out.print("> ");
            String pesquisa = sc.nextLine().trim();

            if (pesquisa.equalsIgnoreCase("sair")) {
                break;
            }
            if (pesquisa.isEmpty()) {
                continue;
            }

            if (nomes.containsKey(pesquisa.toLowerCase())) {
                System.out.println("Nome encontrado.");
            } else {
                System.out.println("Nome não encontrado.");
            }
        }

        sc.close();
    }
}
