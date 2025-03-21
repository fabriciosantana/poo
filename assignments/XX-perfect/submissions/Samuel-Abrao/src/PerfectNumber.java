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

    public static void main(String[] args) {
        System.out.println("Números perfeitos entre 1 e 1000:");
        for (int i = 1; i <= 1000; i++) {
            if (isPerfect(i)) {
                List<Integer> factors = getFactors(i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < factors.size(); j++) {
                    sb.append(factors.get(j));
                    if (j < factors.size() - 1) {
                        sb.append(", ");
                    }
                }
                System.out.println(i + " é um número perfeito. Fatores: " + sb);
            }
        }

        System.out.println("\nTeste adicional:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número para verificar se é perfeito: ");
        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            if (num <= 0) {
                System.out.println("Por favor, digite um número inteiro positivo.");
            } else {
                if (isPerfect(num)) {
                    List<Integer> factors = getFactors(num);
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < factors.size(); j++) {
                        sb.append(factors.get(j));
                        if (j < factors.size() - 1) {
                            sb.append(", ");
                        }
                    }
                    System.out.println(num + " é um número perfeito. Fatores: " + sb);
                } else {
                    System.out.println(num + " não é um número perfeito.");
                }
            }
        } else {
            System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
        }
        scanner.close();
    }
}
