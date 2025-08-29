import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        String entrada;

        // Try-with-resources to ensure Scanner is closed
        try (Scanner leitor = new Scanner(System.in)) {
            // Loop até entrada válida
            while (true) {
                System.out.print("Digite uma sequência: ");
                entrada = leitor.nextLine();

                if (!isValidInput(entrada)) {
                    System.out.println("Erro: A entrada não pode estar vazia.");
                } else {
                    break;
                }
            }

            // Verificação de palíndromo
            if (isPalindrome(entrada)) {
                System.out.println("A sequência \"" + entrada + "\" é um palíndromo.");
            } else {
                System.out.println("A sequência \"" + entrada + "\" não é um palíndromo.");
            }
        }
    }

    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isPalindrome(String input) {
        String s = input.toLowerCase();
        int n = s.length();

        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}