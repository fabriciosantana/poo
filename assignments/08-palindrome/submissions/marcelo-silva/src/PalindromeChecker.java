import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;

        while (true) {
            System.out.print("Digite uma sequência: ");
            userInput = scanner.nextLine();

            if (isValidInput(userInput)) {
                break;
            } else {
                System.out.println("Erro: A entrada não pode estar vazia.");
            }
        }

        String cleanInput = userInput.trim();

        if (isPalindrome(cleanInput)) {
            System.out.println("A sequência \"" + cleanInput + "\" é um palíndromo.");
        } else {
            System.out.println("A sequência \"" + cleanInput + "\" não é um palíndromo.");
        }

        scanner.close();
    }

    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isPalindrome(String input) {
        String processedInput = input.toLowerCase();
        int length = processedInput.length();
        int left = 0;
        int right = length - 1;

        while (left < right) {
            char charLeft = processedInput.charAt(left);
            char charRight = processedInput.charAt(right);

            if (charLeft != charRight) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
