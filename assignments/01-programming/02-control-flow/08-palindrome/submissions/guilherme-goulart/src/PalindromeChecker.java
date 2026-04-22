import java.util.Scanner;

public class PalindromeChecker {
    public static boolean isValidInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean isPalindrome(String input) {
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        int left = 0;
        int right = cleanedInput.length() - 1;
        
        while (left < right) {
            if (cleanedInput.charAt(left) != cleanedInput.charAt(right)) {
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
        
        while (true) {
            System.out.println("Digite uma sequência: ");
            input = scanner.nextLine();
            
            if (!isValidInput(input)) {
                System.out.println("Erro: A entrada não pode estar vazia.  ");
                continue;
            }
            
            break;
        }

        boolean result = isPalindrome(input);

        if (result) {
            System.out.println("A sequência " + input + " é um palíndromo.");
        } else {
            System.out.println("A sequência " + input + " não é um palíndromo.");
        }
        scanner.close();
    }
}
