import java.util.Scanner;

public class PalindromeChecker {

    // Verifica se a entrada é válida (não vazia e não só espaços)
    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }

    // Verifica se a sequência é um palíndromo (ignora maiúsculas/minúsculas)
    public static boolean isPalindrome(String input) {
        String normalized = input.toLowerCase();
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

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        // Continua pedindo até que a entrada seja válida
        while (true) {
            System.out.print("Digite uma sequência: ");
            input = scanner.nextLine();

            if (!isValidInput(input)) {
                System.out.println("Erro: A entrada não pode estar vazia.");
            } else {
                break;
            }
        }

        // Verifica se é palíndromo e exibe o resultado
        if (isPalindrome(input)) {
            System.out.printf("A sequência \"%s\" é um palíndromo.%n", input);
        } else {
            System.out.printf("A sequência \"%s\" não é um palíndromo.%n", input);
        }

        scanner.close();
    }
}
