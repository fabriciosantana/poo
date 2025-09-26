import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
public class UniqueNamesApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // conjunto para guardar nomes unicos ordenados
        Set<String> nomes = new TreeSet<>();

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");

        // leitura dos nomes
        while (true) {
            String entrada = sc.nextLine().trim();

            // verifica se usuario digitou fim
            if (entrada.equalsIgnoreCase("fim")) {
                break;
            }
            // adiciona nome formatado com primeira letra maiuscula e resto minusculo
            if (!entrada.isEmpty()) {
                String nomeFormatado = entrada.substring(0,1).toUpperCase() + entrada.substring(1).toLowerCase();
                nomes.add(nomeFormatado);
            }
        }
        // mostra nomes cadastrados
        System.out.println("\nNomes cadastrados:");
        System.out.println(nomes);

        // fase de pesquisa
        System.out.println("\nPesquisar nomes (digite 'sair' para encerrar):");

        while (true) {
            String busca = sc.nextLine().trim();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            // formata busca igual ao cadastro
            String buscaFormatada = busca.substring(0,1).toUpperCase() + busca.substring(1).toLowerCase();

            if (nomes.contains(buscaFormatada)) {
                System.out.println("Nome encontrado.");
            } else {
                System.out.println("Nome nao encontrado.");
            }
        }

        sc.close();
    }
}
