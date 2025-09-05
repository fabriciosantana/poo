import java.util.Scanner;

public class PalindromeChecker {
    
    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }
    
    public static boolean isPalindrome(String input) {
        String cleanInput = input.toLowerCase().replaceAll("\\s+", "");
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
        Scanner input = new Scanner(System.in);
        
        while (true) {
            System.out.print("Digite uma sequência: ");
            String sequence = input.nextLine();
            
            if (!isValidInput(sequence)) {
                System.out.println("Erro: A entrada não pode estar vazia.");
                continue;
            }
            
            if (isPalindrome(sequence)) {
                System.out.printf("A sequência \"%s\" é um palíndromo.%n", sequence);
            } else {
                System.out.printf("A sequência \"%s\" não é um palíndromo.%n", sequence);
            }
            break;
        }
        
        input.close();
    }
}
