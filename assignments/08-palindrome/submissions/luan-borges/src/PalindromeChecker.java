import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isValidInput(String input) {
        if (input == null) {
            return false;
        }
        return !input.trim().isEmpty();
    }

    public static boolean isPalindrome(String input) {
        String processedInput = input.toLowerCase();
        String reversedInput = new StringBuilder(processedInput).reverse().toString();
        return processedInput.equals(reversedInput);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("Digite uma sequência: ");
            input = scanner.nextLine();

            if (isValidInput(input)) {
                break;
            } else {
                System.out.println("Erro: A entrada não pode estar vazia.");
            }
        }
        
        scanner.close();

        if (isPalindrome(input)) {
            System.out.println("A sequência \"" + input + "\" é um palíndromo.");
        } else {
            System.out.println("A sequência \"" + input + "\" não é um palíndromo.");
        }
    }
}