import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.print("Digite uma sequência: ");
        input = scanner.nextLine();

        if (input.isEmpty()) {
            System.out.println("Erro: A entrada não pode estar vazia.");
        } else {
        
            String cleanInput = input.toLowerCase().replaceAll("[^a-z0-9]", "");
            if (cleanInput.equals(new StringBuilder(cleanInput).reverse().toString())) {
                System.out.println("A sequência \"" + input + "\" é um palíndromo.");
            } else {
                System.out.println("A sequência \"" + input + "\" não é um palíndromo.");
            }
        }

        scanner.close();
    }
}
