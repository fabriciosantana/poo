import java.util.Scanner;

public class PalindromeChecker {

    // Verifica se a entrada é válida (não vazia e não só espaços)
    public static boolean isValidInput(String input) {
        if (input == null) return false;
        return !input.trim().isEmpty();
    }

    // Verifica se a entrada é um palíndromo (ignorando espaços e maiúsculas/minúsculas)
    public static boolean isPalindrome(String input) {
        if (!isValidInput(input)) return false;

        // normalizar: minúsculas e remover espaços
        String normalized = input.toLowerCase().replaceAll("\\s+", "");
        int length = normalized.length();

        for (int i = 0; i < length / 2; i++) {
            if (normalized.charAt(i) != normalized.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // Programa principal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("Digite uma sequência: ");
            input = sc.nextLine();

            if (!isValidInput(input)) {
                System.out.println("Erro: A entrada não pode estar vazia.");
            } else {
                break;
            }
        }

        if (isPalindrome(input)) {
            System.out.println("A sequência \"" + input + "\" é um palíndromo.");
        } else {
            System.out.println("A sequência \"" + input + "\" não é um palíndromo.");
        }

        sc.close();
    }
}
