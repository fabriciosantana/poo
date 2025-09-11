package Lucas_Pontual.src.palindrome;

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
            } else {
                if (isPalindrome(input)) {
                    System.out.printf("A sequência \"%s\" é um palíndromo.%n", input);
                } else {
                    System.out.printf("A sequência \"%s\" não é um palíndromo.%n", input);
                }
            }
        } while (!isValidInput(input));

        scanner.close();
    }

    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isPalindrome(String input) {
        String cleanedInput = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        int length = cleanedInput.length();
        for (int i = 0; i < length / 2; i++) {
            if (cleanedInput.charAt(i) != cleanedInput.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}


