import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class NameRegistry {

    public static boolean addName(Set<String> names, String name) {
        return names.add(name);
    }

    public static boolean containsName(Set<String> names, String name) {
        return names.contains(name);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> names = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");
        String entrada = scanner.nextLine();
        while (!entrada.equalsIgnoreCase("fim")) {
            addName(names, entrada);
            entrada = scanner.nextLine();
        }

        System.out.println();
        System.out.println("Nomes cadastrados:");
        System.out.println(names);

        System.out.println();
        System.out.println("Pesquisar nomes (digite 'sair' para encerrar):");
        String busca = scanner.nextLine();
        while (!busca.equalsIgnoreCase("sair")) {
            if (containsName(names, busca)) {
                System.out.println("Nome encontrado.");
            } else {
                System.out.println("Nome não encontrado.");
            }
            busca = scanner.nextLine();
        }

        scanner.close();
    }
}