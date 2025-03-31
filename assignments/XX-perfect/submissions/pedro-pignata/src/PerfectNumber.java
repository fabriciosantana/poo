import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PerfectNumber {

    public static boolean isPerfect(int number) {
        if (number < 2) return false;
        List<Integer> factors = getFactors(number);
        int sum = factors.stream().mapToInt(Integer::intValue).sum();
        return sum == number;
    }

    public static List<Integer> getFactors(int number) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }

    public static void main(String[] args) {
        System.out.println("Números perfeitos entre 1 e 1000:");
        for (int i = 1; i <= 1000; i++) {
            if (isPerfect(i)) {
                List<Integer> factors = getFactors(i);
                System.out.println(i + " é um número perfeito. Fatores: " + factors);
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nTeste adicional:");
        System.out.print("Digite um número para verificar se é perfeito: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida! Digite um número inteiro válido.");
            scanner.next();
        }
        int userInput = scanner.nextInt();
        scanner.close();
        
        if (isPerfect(userInput)) {
            System.out.println(userInput + " é um número perfeito. Fatores: " + getFactors(userInput));
        } else {
            System.out.println(userInput + " não é um número perfeito.");
        }
    }
}