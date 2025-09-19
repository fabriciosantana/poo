import java.util.Scanner;

public class PalindromeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("Digite uma sequência: ");
            input = scanner.nextLine();

            if (!PalindromeChecker.isValidInput(input)) {
                System.out.println("Erro: A entrada não pode estar vazia.");
                continue;
            } else {
                break;
            }
        }

        if (PalindromeChecker.isPalindrome(input)) {
            System.out.println("A sequência \"" + input + "\" é um palíndromo.");
        } else {
            System.out.println("A sequência \"" + input + "\" não é um palíndromo.");
        }

        scanner.close();
    }
}

