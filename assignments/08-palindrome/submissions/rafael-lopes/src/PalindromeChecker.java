import java.util.Scanner;

public class PalindromeChecker {
    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isPalindrome(String input) {
        input = input.toLowerCase().replaceAll("\\s", "");
        int length = input.length();
        for (int i = 0; i < length / 2; i++) {
            if (input.charAt(i) != input.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        
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
        
        scanner.close();
    }
}
