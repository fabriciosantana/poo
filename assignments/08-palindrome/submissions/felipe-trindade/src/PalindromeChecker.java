import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String input;

        do {
            System.out.print("Digite uma sequência: ");
            input = sc.nextLine();

            if(!isValidInput(input)){
                System.out.println("Erro: A entrada não pode estar vazia.");
            }
        } while (!isValidInput(input));

        if (isPalindrome(input)){
            System.out.println("A sequência \"" + input + "\" é um palíndromo.");
        } else {
            System.out.println("A sequência \"" + input + "\" não é um palíndromo.");
        }

        sc.close();
    }

    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isPalindrome(String input) {
        String lower = input.toLowerCase();
        int left = 0;
        int right = lower.length() - 1;

        while (left < right) {
            if (lower.charAt(left) != lower.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
