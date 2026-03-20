import java.util.Scanner;

public class PalindromeTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        boolean valid = false;

        while (!valid) {
            System.out.print("Digite uma sequência: ");
            input = scanner.nextLine();

            if (PalindromeChecker.isValidInput(input)) {
                valid = true;
            } else {
                System.out.println("Erro: A entrada não pode estar vazia.");
            }
        }

        if (PalindromeChecker.isPalindrome(input)) {
            System.out.printf("A sequência \"%s\" é um palíndromo.%n", input);
        } else {
            System.out.printf("A sequência \"%s\" não é um palíndromo.%n", input);
        }

        scanner.close();
    }
}