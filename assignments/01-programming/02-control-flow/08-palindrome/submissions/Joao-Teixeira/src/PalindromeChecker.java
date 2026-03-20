import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isValidInput(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                return true;
            }
        }
        return false;
    }

    public static boolean isPalindrome(String input) {
        if (input == null) return false;
        
        String cleanInput = "";
        input = input.toLowerCase();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ') {
                cleanInput += c;
            }
        }
        
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
        Scanner scanner = new Scanner(System.in);
        String input = "";
        
        while (true) {
            System.out.print("Digite uma sequência: ");
            input = scanner.nextLine();
            
            if (isValidInput(input)) {
                break;
            }
            System.out.println("Erro: A entrada não pode estar vazia.");
        }
        
        if (isPalindrome(input)) {
            System.out.println("A sequência \"" + input + "\" é um palíndromo.");
        } else {
            System.out.println("A sequência \"" + input + "\" não é um palíndromo.");
        }
    }
}
