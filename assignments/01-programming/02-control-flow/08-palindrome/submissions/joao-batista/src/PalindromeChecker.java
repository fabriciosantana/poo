import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isPalindrome(String input) {
        String cleanInput = input.toLowerCase().trim();
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
        Scanner input = new Scanner(System.in);
        String sequence;

        do {
            System.out.print("Digite uma sequência: ");
            sequence = input.nextLine();

            if (!isValidInput(sequence)) {
                System.out.println("Erro: A entrada não pode estar vazia.");
                continue;
            }

            if (isPalindrome(sequence)) {
                System.out.println("A sequência \"" + sequence + "\" é um palíndromo.");
            } else {
                System.out.println("A sequência \"" + sequence + "\" não é um palíndromo.");
            }
            break;
        } while (true);

        input.close();
    }
}