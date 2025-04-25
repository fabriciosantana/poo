import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input;
            do {
                System.out.print("Digite uma sequência: ");
                input = scanner.nextLine().trim();
                
                if (!isValidInput(input)) {
                    System.out.println("Erro: A entrada não pode estar vazia.");
                    continue;
                }
                
                if (isPalindrome(input)) {
                    System.out.println("A sequência \"" + input + "\" é um palíndromo.");
                } else {
                    System.out.println("A sequência \"" + input + "\" não é um palíndromo.");
                }
                
                break; 
            } while (true);
        }
    }

    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isPalindrome(String input) {
        String cleanInput = input.toLowerCase();
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
}