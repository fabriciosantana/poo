import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PerfectNumber {
    public static boolean isPerfect(int number) {
        int sum = 0;
        List<Integer> factors = new ArrayList<>();

        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                factors.add(i);
                sum += i;
            }
        }

        if (sum == number) {
            System.out.println(number + " é um número perfeito. Fatores: " + factors);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Números perfeitos entre 1 e 1000:");
        for (int i = 1; i <= 1000; i++) {
            isPerfect(i);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDigite um número para verificar se é perfeito: ");
        int num = scanner.nextInt();

        if (!isPerfect(num)) {
            System.out.println(num + " não é um número perfeito.");
        }

        scanner.close();
    }
}
