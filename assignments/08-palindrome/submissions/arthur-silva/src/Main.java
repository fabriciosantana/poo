import java.util.Scanner;

public class Main {
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
            break;
        }

        if (PalindromeChecker.isPalindrome(input)) {
            System.out.printf("A sequência \"%s\" é um palíndromo.%n", input);
        } else {
            System.out.printf("A sequência \"%s\" não é um palíndromo.%n", input);
        }
    }
}