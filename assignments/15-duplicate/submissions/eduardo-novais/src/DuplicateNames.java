import java.util.*;

public class DuplicateNamesApp {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> nomes = new TreeSet<>();
        
        System.out.println("Digite os nomes (digite 'fim' para encerrar):");
        
        while (true) {
            System.out.print("> ");
            String entrada = scanner.nextLine().trim();
            
            if (entrada.equalsIgnoreCase("fim")) {
                break;
            }
            
            if (!entrada.isEmpty()) {
                String nomeFormatado = formatarNome(entrada);
                nomes.add(nomeFormatado);
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
            
            if (!busca.isEmpty()) {
                String nomeFormatado = formatarNome(busca);
                
                if (nomes.contains(nomeFormatado)) {
                    System.out.println("Nome encontrado.");
                } else {
                    System.out.println("Nome não encontrado.");
                }
            }
        }
        
        scanner.close();
        System.out.println("\nPrograma encerrado.");
    }
    
    private static String formatarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return "";
        }
        
        String nomeLimpo = nome.trim();
        String primeiraLetra = nomeLimpo.substring(0, 1).toUpperCase();
        String restoNome = nomeLimpo.substring(1).toLowerCase();
        
        return primeiraLetra + restoNome;
    }
}
