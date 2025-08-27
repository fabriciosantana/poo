import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DuplicateEliminator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> names = new TreeSet<>(); // Using TreeSet for ordered output

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");
        String inputName;
        while (true) {
            System.out.print("> ");
            inputName = scanner.nextLine();
            if (inputName.equalsIgnoreCase("fim")) {
                break;
            }
            names.add(inputName.toLowerCase()); // Store in lowercase for case-insensitivity
        }

        System.out.println("\nNomes cadastrados:");
        // Convert to a new TreeSet to ensure case-insensitive uniqueness and proper display
        Set<String> displayNames = new TreeSet<>();
        for (String name : names) {
            // Find the original casing if possible, or just use the lowercased version
            // This is a simplification; a more robust solution might involve a Map<String, String>
            // to store original casing. For this exercise, we'll just capitalize the first letter.
            displayNames.add(name.substring(0, 1).toUpperCase() + name.substring(1));
        }
        System.out.println(displayNames);

        System.out.println("\nPesquisar nomes (digite 'sair' para encerrar):");
        String searchName;
        while (true) {
            System.out.print("> ");
            searchName = scanner.nextLine();
            if (searchName.equalsIgnoreCase("sair")) {
                break;
            }
            if (names.contains(searchName.toLowerCase())) {
                System.out.println("Nome encontrado.");
            } else {
                System.out.println("Nome não encontrado.");
            }
        }

        scanner.close();
    }
}


