import java.util.Scanner;

public class PalindromeChecker {
    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isPalindrome(String input) {
        if (!isValidInput(input)) {
            return false;
        }

        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.print("Digite uma sequencia: ");
            input = scanner.nextLine();
        } while (!isValidInput(input));

        if (isPalindrome(input)) {
            System.out.println("A sequencia \"" + input + "\" e um palindromo.");
        } else {
            System.out.println("A sequencia \"" + input + "\" nao e um palindromo.");
        }

        scanner.close();
    }
}
