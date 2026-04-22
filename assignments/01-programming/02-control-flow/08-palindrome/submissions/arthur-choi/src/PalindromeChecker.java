import java.util.Scanner;

public class PalindromeChecker {

    //check if the input is valid (only letters and numbers and not empty)
    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty() && input.matches("[a-zA-Z0-9]+");
    }
    public static boolean isPalindrome(String input) {
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversedInput = new StringBuilder(cleanedInput).reverse().toString();
        return cleanedInput.equals(reversedInput);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma sequência: ");
        String sequence = scanner.nextLine();

    do {
        if (!isValidInput(sequence)) {
            System.out.println("Entrada inválida. Por favor, insira apenas letras e números.");
            System.out.print("Digite uma sequência: ");
            sequence = scanner.nextLine();
        }
    } while (!isValidInput(sequence));

        if (isPalindrome(sequence)) {
            System.out.println("A sequência é um palíndromo.");
        } else {
            System.out.println("A sequência não é um palíndromo.");
        }

        scanner.close();
    }

    
}
