import java.util.Scanner;

public class PalindromeChecker {

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

    public static boolean isValidInput(String input) {
        if (input == null) return false;
        else {
            input = input.trim();

            return input.length() > 0;

        }
        
    }

    public static boolean isPalindrome(String input) {

        input = input.toLowerCase();

        int inicio = 0;
        int fim = input.length() - 1;

        while (inicio < fim) {
            if (input.charAt(inicio) != input.charAt(fim)) {
                return false;
            }
            inicio++;
            fim--;
        }

        return true;
    }
}