import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isPalindrome(String input) {
        String cleanInput = input.toLowerCase();
        int left = 0;
        int right = cleanInput.length() - 1;

        while (left < right) {
            if (cleanInput.charAt(left) != cleanInput.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (true) {
            System.out.print("Digite uma sequência: ");
            input = scanner.nextLine();

            if (isValidInput(input)) {
                break;
            } else {
                System.out.println("Erro: A entrada não pode estar vazia.");
            }
        }

        if (isPalindrome(input)) {
            System.out.printf("A sequência \"%s\" é um palíndromo.\n", input);
        } else {
            System.out.printf("A sequência \"%s\" não é um palíndromo.\n", input);
        }

        scanner.close();
    }
}