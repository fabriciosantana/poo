import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Duplicate{
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        
        Set<String> names = new HashSet<>();
        Set<String> lowerNames = new HashSet<>();

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");

        while(true){
            
            System.out.print("> ");
            String name = scanner.next();
            
            if(name.equalsIgnoreCase("FIM")){
                break;
            }

            if(lowerNames.add(name.toLowerCase())){
                names.add(name);
            }

        }

        System.out.println("\nNomes cadastrados:");
        System.out.println(names);

        System.out.println("\nPesquisar nomes (digite 'sair' para encerrar):");

        while(true){
            
            System.out.print("> ");
            String search = scanner.next();
            
            if(search.equalsIgnoreCase("SAIR")){
                break;
            }
            
            if(lowerNames.add(search.toLowerCase())){
                System.out.println("Nome não encontrado.");
            } else{
                System.out.println("Nome encontrado.");
            }

            
        }
    }
}