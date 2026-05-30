
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class RemovedorNomesDuplicados {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
       
        Set<String> nomes = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");
        
       
        while (true) {
            System.out.print("> ");
            String entrada = scanner.nextLine().trim();

            
            if (entrada.equalsIgnoreCase("fim")) {
                break;
            }

            
            if (!entrada.isEmpty()) {
                nomes.add(entrada);
            }
        }

        
        System.out.println("\nNomes cadastrados:");
        System.out.println(nomes);

        System.out.println("\nPesquisar nomes (digite 'sair' para encerrar):");
        
        
        while (true) {
            System.out.print("> ");
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