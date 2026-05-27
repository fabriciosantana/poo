import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Collection {

    public static void addName(Set <String> list, Scanner scanner){
        String newName;

        do { 
            System.out.println("Digite os nomes(Digite 'fim' para encerrar)");
            newName = scanner.nextLine();
            if(!newName.equalsIgnoreCase("fim")){
                list.add(newName);  
            }else{
                System.out.println("Encerrando função de adcionar nome");
            }
            
        } while (!newName.equalsIgnoreCase("fim"));

    }

    public static void searchName(Set <String> list, Scanner scanner){

        String nameToSearch;

        do{
            System.out.println("Pesquisar nomes(digite 'sair' para encerrar)");
            nameToSearch = scanner.nextLine();

            if(!nameToSearch.equalsIgnoreCase("sair")){
                boolean hasName = list.contains(nameToSearch);
                if(hasName){
                    System.out.println(">"+ nameToSearch);
                    System.out.println("Nome encontrado");
                }else{
                    System.out.println(">"+ nameToSearch);
                    System.out.println("Nome não encontrado");
                }
            }
        }while(!nameToSearch.equalsIgnoreCase("Sair"));

    }



    public static void main(String[] args){
        Set<String> names = new TreeSet <>(String.CASE_INSENSITIVE_ORDER);
        Scanner scanner = new Scanner(System.in);

        names.add("Ana");
        names.add("ana");
        names.add("Maria");
        names.add("Jose");
        names.add("jose");
        names.add("Pedro");

        addName(names, scanner);
        searchName(names, scanner);
        
        System.out.println(names);

    }
}
