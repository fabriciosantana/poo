import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CadastroNomes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Set<String> nomes = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        //cadastro de Nomes
        System.out.println("Digite os nomes (digite 'fim' para encerrar):");
        while (true) {
            System.out.print("> ");
            String entrada = scanner.nextLine().trim();
            
            // Verifica a condição de parada
            if (entrada.equalsIgnoreCase("fim")) {
                break;
            }
            
            // Adiciona o nome caso não seja uma string vazia
            if (!entrada.isEmpty()) {
                nomes.add(entrada);
            }
        }

        //Exibição dos Nomes
        System.out.println("\nNomes cadastrados:");
        System.out.println(nomes);

        //Pesquisa de Nomes
        System.out.println("\nPesquisar nomes (digite 'sair' para encerrar):");
        while (true) {
            System.out.print("> ");
            String busca = scanner.nextLine().trim();
            
            //Verifica a condição de parada
            if (busca.equalsIgnoreCase("sair")) {
                break;
            }
            
            if (!busca.isEmpty()) {
                if (nomes.contains(busca)) {
                    System.out.println("Nome encontrado.");
                } else {
                    System.out.println("Nome não encontrado.");
                }
            }
        }

        System.out.println("Programa encerrado.");
        scanner.close();
    }
}