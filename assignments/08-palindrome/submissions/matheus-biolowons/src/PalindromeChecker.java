import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.print("Digite uma sequência: ");
            input = scanner.nextLine();

            if (!isValidInput(input)) {
                System.out.println("Erro: A entrada não pode estar vazia.");
            } else {
                if (isPalindrome(input)) {
                    System.out.printf("A sequência \"%s\" é um palíndromo.%n", input);
                } else {
                    System.out.printf("A sequência \"%s\" não é um palíndromo.%n", input);
                }
                break;
            }
        } while (true);

        scanner.close();
    }

    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isPalindrome(String input) {
        String normalized = input.toLowerCase();
        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}