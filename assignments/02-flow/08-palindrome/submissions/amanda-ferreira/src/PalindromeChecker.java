import java.util.Scanner;

public class PalindromeChecker {
    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isPalindrome(String input) {
        if (!isValidInput(input)) return false;

        String palavra = input.trim().toLowerCase();
        int esquerda = 0;
        int direita = palavra.length() - 1;
        while (esquerda < direita) {
            if (palavra.charAt(esquerda) != palavra.charAt(direita)) return false;
            esquerda++;
            direita--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String entrada = "";
        boolean ehValido = false;

        while (!ehValido) {
            System.out.print("Digite uma sequência: ");
            entrada = scanner.nextLine();

            ehValido = isValidInput(entrada);

            if (!ehValido) {
                System.out.println("Erro: A entrada não pode estar vazia.");
            }
        }

        if (isPalindrome(entrada)) {
            System.out.println("A sequência \"" + entrada + "\" é um palíndromo.");
        } else {
            System.out.println("A sequência \"" + entrada + "\" não é um palíndromo.");
        }

        scanner.close();
    }
}
