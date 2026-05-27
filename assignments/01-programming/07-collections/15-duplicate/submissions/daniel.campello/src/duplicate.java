import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

public class duplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<String> nomesNormalizados = new HashSet<>();
        Set<String> nomesExibicao = new TreeSet<>();

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");

        while (true) {
            if (!sc.hasNextLine()) {
                break;
            }

            String entrada = sc.nextLine().trim();

            if (entrada.equalsIgnoreCase("fim")) {
                break;
            }

            if (entrada.isEmpty()) {
                continue;
            }

            String chave = entrada.toLowerCase();
            if (nomesNormalizados.add(chave)) {
                nomesExibicao.add(entrada);
                System.out.println("Nome adicionado com sucesso!");
            }
        }

        System.out.println("Nomes cadastrados:");
        System.out.println(nomesExibicao);

        while (true) {
            System.out.println("Pesquisar nomes (digite 'sair' para encerrar):");

            if (!sc.hasNextLine()) {
                break;
            }

            String pesquisa = sc.nextLine().trim();

            if (pesquisa.equalsIgnoreCase("sair")) {
                break;
            }

            if (pesquisa.isEmpty()) {
                continue;
            }

            if (nomesNormalizados.contains(pesquisa.toLowerCase())) {
                System.out.println("Nome encontrado.");
            } else {
                System.out.println("Nome nao encontrado.");
            }
        }

        sc.close();
    }
}
