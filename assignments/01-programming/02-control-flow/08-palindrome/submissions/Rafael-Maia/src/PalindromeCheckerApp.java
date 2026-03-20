import java.util.Scanner;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.print("Digite uma sequencia: ");
            input = scanner.nextLine();

            if (!PalindromeChecker.isValidInput(input)) {
                System.out.println("Erro: A entrada nao pode estar vazia.");
            }
        } while (!PalindromeChecker.isValidInput(input));

        if (PalindromeChecker.isPalindrome(input)) {
            System.out.println("A sequencia \"" + input + "\" e um palindromo.");
        } else {
            System.out.println("A sequencia \"" + input + "\" nao e um palindromo.");
        }

        scanner.close();
    }
}
