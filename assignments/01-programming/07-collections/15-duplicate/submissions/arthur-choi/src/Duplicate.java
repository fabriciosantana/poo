import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class Duplicate{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Set<String> nomes = new HashSet<>();
        Set<String> nomesNormalizados = new HashSet<>();

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");

        while(true){
            String entrada = scanner.nextLine().trim();

            if(entrada.equalsIgnoreCase("fim")){
                break;
            }

            if(entrada.isEmpty()){
                continue;
            }

            String chave = entrada.toLowerCase();
            if(nomesNormalizados.add(chave)){
                nomes.add(entrada);
            }
        }

        System.out.println("Nomes cadastrados:");
        System.out.println(nomes);

        while(true){
            System.out.println("Pesquisar nomes (digite 'sair' para encerrar):");
            String pesquisa = scanner.nextLine().trim();

            if(pesquisa.equalsIgnoreCase("sair")){
                break;
            }

            if(pesquisa.isEmpty()){
                continue;
            }

            if(nomesNormalizados.contains(pesquisa.toLowerCase())){
                System.out.println("Nome encontrado.");
            } else {
                System.out.println("Nome nao encontrado.");
            }
        }

    }
}