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
            }
        } while (!isValidInput(input));

        if (isPalindrome(input)) {
            System.out.printf("A sequência \"%s\" é um palíndromo.\n", input);
        } else {
            System.out.printf("A sequência \"%s\" não é um palíndromo.\n", input);
        }

        scanner.close();
    }

    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isPalindrome(String input) {
        String cleanedInput = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0;
        int right = cleanedInput.length() - 1;

        while (left < right) {
            if (cleanedInput.charAt(left) != cleanedInput.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}


