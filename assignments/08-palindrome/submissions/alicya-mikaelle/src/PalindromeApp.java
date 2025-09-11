import java.util.Scanner;

class PalindromeChecker {

    public static boolean isValidInput(String input) {
        if (input == null) return false;
        input = input.trim();  
        return !input.isEmpty(); 
    }

    public static boolean isPalindrome(String input) {
        input = input.toLowerCase(); 
        int left = 0, right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

public class PalindromeApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("Digite uma sequência: ");
            input = sc.nextLine();

            if (!PalindromeChecker.isValidInput(input)) {
                System.out.println("Erro: A entrada não pode estar vazia.");
                continue; 
            }

            if (PalindromeChecker.isPalindrome(input)) {
                System.out.println("A sequência \"" + input + "\" é um palíndromo.");
            } else {
                System.out.println("A sequência \"" + input + "\" não é um palíndromo.");
            }
            break; 
        }
    }
}

