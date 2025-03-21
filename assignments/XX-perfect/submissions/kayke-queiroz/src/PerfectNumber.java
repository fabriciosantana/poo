import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
        System.out.println("Números perfeitos entre 1 e 1000:");
        for (int i = 1; i <= 1000; i++) {
            if (isPerfect(i)) {
                System.out.println(i + " é um número perfeito. Fatores: " + formatFactors(getFactors(i)));
            }
        }

        // Teste adicional para números maiores que 1000
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("\nDigite um número para verificar se é perfeito (ou 0 para sair): ");
            int number = sc.nextInt();
            if (number == 0) break;
            if (number < 0) {
                System.out.println("Por favor, insira um número positivo.");
                continue;
            }
            if (isPerfect(number)) {
                System.out.println(number + " é um número perfeito. Fatores: " + formatFactors(getFactors(number)));
            } else {
                System.out.println(number + " não é um número perfeito.");
            }
        }
        sc.close();
    }

    public static boolean isPerfect(int number) {
        List<Integer> factors = getFactors(number);
        int sum = factors.stream().mapToInt(Integer::intValue).sum();
        return sum == number;
    }

    public static List<Integer> getFactors(int number) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                if (i != number) factors.add(i);
                int otherFactor = number / i;
                if (otherFactor != i && otherFactor != number) { // Evita duplicatas e o próprio número
                    factors.add(otherFactor);
                }
            }
        }
        return factors;
    }

    private static String formatFactors(List<Integer> factors) {
        return factors.toString().replace("[", "").replace("]", "");
    }
}
