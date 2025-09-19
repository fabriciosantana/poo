import java.util.Scanner;

public class PalindromeChecker {
    public static boolean isValidInput(String input) {
        if (input == null) {
            return false;
        }
        input = input.trim();
        return !input.isEmpty();
    }
    
    public static boolean isPalindrome(String input) {
        input = input.toLowerCase();
        int n = input.length();

        for (int i = 0; i < n / 2; i++) {
            if (input.charAt(i) != input.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String entrada;

        while (true) {
            System.out.print("Digite uma sequência: ");
            entrada = scanner.nextLine();

            if (!isValidInput(entrada)) {
                System.out.println("Erro: A entrada não pode estar vazia.");
                continue;
            }
            if (isPalindrome(entrada)) {
                System.out.println("A sequência \"" + entrada + "\" é um palíndromo.");
            } else {
                System.out.println("A sequência \"" + entrada + "\" não é um palíndromo.");
            }
            break;
        }
        scanner.close();
    }
}
