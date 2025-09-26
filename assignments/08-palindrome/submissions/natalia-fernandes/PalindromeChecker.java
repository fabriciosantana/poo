import java.util.Scanner;

public class PalindromeChecker {

    // Verifica se a entrada é válida (não nula, não vazia e não apenas espaços)
    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }

    // Verifica se a string é um palíndromo (ignora maiúsculas/minúsculas)
    public static boolean isPalindrome(String input) {
        if (input == null) return false;

        String normalized = input.toLowerCase(); // ignora maiúsculas/minúsculas
        int length = normalized.length();

        for (int i = 0; i < length / 2; i++) {
            if (normalized.charAt(i) != normalized.charAt(length - 1 - i)) {
                return false; // encontrou uma diferença
            }
        }
        return true;
    }

    // Método principal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("Digite uma sequência: ");
            input = sc.nextLine();

            if (!isValidInput(input)) {
                System.out.println("Erro: A entrada não pode estar vazia.");
            } else {
                break; // entrada válida → sai do loop
            }
        }

        if (isPalindrome(input)) {
            System.out.printf("A sequência \"%s\" é um palíndromo.%n", input);
        } else {
            System.out.printf("A sequência \"%s\" não é um palíndromo.%n", input);
        }

        sc.close();
    }
}
