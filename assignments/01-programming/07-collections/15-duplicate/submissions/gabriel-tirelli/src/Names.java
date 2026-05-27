import java.util.Scanner;
import java.util.Set;
import java.util.LinkedHashSet;

public class Names {

    public static void main(String[] args){

        Set<String> nomes = new LinkedHashSet<String>();
        Scanner scan = new Scanner(System.in);
        String nome;

        System.out.println("Digite os nomes (digite 'fim' para encerrar): ");
        do {
            System.out.printf(">");
            nome = scan.nextLine();

            nome = nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase();
            nome = nome.trim();

            if(!nome.equals("Fim")) nomes.add(nome);

        } while (!nome.equals("Fim"));

        System.out.println("Nomes cadastrados: ");
        System.out.print(nomes);
        System.out.println();

        System.out.println("Pesquisar nomes (digite 'sair' para encerrar): ");
        do {

            System.out.printf(">");
            nome = scan.nextLine();

            nome = nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase();
            nome = nome.trim();

            if(!nome.equals("Sair")){
                if(nomes.contains(nome)) System.out.println("Nome encontrado");
                else System.out.println("Nome não encontrado");
            }

        } while (!nome.equals("Sair"));        

        scan.close();
    }
}
