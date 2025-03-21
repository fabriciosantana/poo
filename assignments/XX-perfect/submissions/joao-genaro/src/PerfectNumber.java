import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class PerfectNumber {

    public static List<Integer> getFactors(int number) {
        List<Integer> factors = new ArrayList<>();
        if (number <= 1) {
            return factors;
        }
        factors.add(1);
        int sqrt = (int) Math.sqrt(number);
        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) {
                factors.add(i);
                int paired = number / i;
                if (paired != i && paired != number) {
                    factors.add(paired);
                }
            }
        }
        Collections.sort(factors);
        return factors;
    }

    public static boolean isPerfect(int number) {
        if (number <= 1) {
            return false;
        }
        List<Integer> factors = getFactors(number);
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum == number;
    }

    public static void displayPerfectNumbersInRange(int start, int end) {
        System.out.println("Numeros perfeitos no intervalo de " + start + " a " + end + ":");
        for (int i = start; i <= end; i++) {
            if (isPerfect(i)) {
                System.out.println(formatPerfectNumber(i));
            }
        }
    }

    public static String formatPerfectNumber(int number) {
        List<Integer> factors = getFactors(number);
        return number + " é um numero perfeito. Divisores: " + String.join(", ", factors.stream().map(String::valueOf).toArray(String[]::new));
    }

    public static void testUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Verificação personalizada:");
        System.out.print("Insira um número para verificar se é perfeito: ");
        
        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            if (num <= 0) {
                System.out.println("Entrada invalida! Digite um numero inteiro positivo.");
            } else {
                System.out.println(isPerfect(num) ? formatPerfectNumber(num) : num + "não é um numero perfeito.");
            }
        } else {
            System.out.println("Erro! Insira um número inteiro valido.");
        }
        scanner.close();
    }

    public static void main(String[] args) {
        displayPerfectNumbersInRange(1, 1000);
        testUserInput();
    }
}