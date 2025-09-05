import java.util.Scanner;

public class PalindromeChecker {

    // Verifica se a entrada é válida (não vazia e sem espaços em branco excessivos)
    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }

    // Verifica se a string é um palíndromo
    public static boolean isPalindrome(String input) {
        input = input.toLowerCase(); // ignorar maiúsculas/minúsculas
        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
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
                break; // entrada válida → sai do loop
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
