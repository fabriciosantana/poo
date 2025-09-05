// PalindromeChecker.java
// Verifica se uma sequência de caracteres é um palíndromo.
// Requisitos: usar String.charAt(i), String.length(), String.toLowerCase().

import java.util.Scanner;

public class PalindromeChecker {

    /**
     * Verifica se a entrada é válida: não nula e não vazia após trim().
     * @param input String de entrada do usuário
     * @return true se for válida; false caso contrário
     */
    public static boolean isValidInput(String input) {
        if (input == null) return false;
        return input.trim().length() > 0;
    }

    /**
     * Verifica se a entrada é um palíndromo, ignorando maiúsculas e minúsculas.
     * Usa apenas charAt e length para percorrer a String.
     * @param input String de entrada (pressupõe entrada válida)
     * @return true se for palíndromo; false caso contrário
     */
    public static boolean isPalindrome(String input) {
        if (input == null) return false;

        // Normaliza: remove espaços em volta e ignora diferenças de maiúsculas/minúsculas.
        String s = input.trim().toLowerCase();

        int i = 0;
        int j = s.length() - 1;

        // Compara caracteres das extremidades avançando ao centro
        while (i < j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (ci != cj) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rawInput;

        // Continua solicitando até entrada válida
        while (true) {
            System.out.print("Digite uma sequência: ");
            rawInput = sc.nextLine();

            if (!isValidInput(rawInput)) {
                System.out.println("Erro: A entrada não pode estar vazia.");
                continue;
            }
            break;
        }

        // Usa a versão "limpa" para exibição (sem espaços nas pontas)
        String display = rawInput.trim();

        boolean palindrome = isPalindrome(rawInput);
        if (palindrome) {
            System.out.println("A sequência \"" + display + "\" é um palíndromo.");
        } else {
            System.out.println("A sequência \"" + display + "\" não é um palíndromo.");
        }

        sc.close();
    }
}
