import java.util.Scanner;

public class MedianCalculator {

    public static int findMedian(int a, int b, int c) {
        if ((a >= b && a <= c) || (a >= c && a <= b)) {
            return a;
        }

        if ((b >= a && b <= c) || (b >= c && b <= a)) {
            return b;
        }

        return c;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite o primeiro numero: ");
            int num1 = scanner.nextInt();

            System.out.print("Digite o segundo numero: ");
            int num2 = scanner.nextInt();

            System.out.print("Digite o terceiro numero: ");
            int num3 = scanner.nextInt();

            int median = findMedian(num1, num2, num3);
            System.out.println("A mediana dos numeros e: " + median);
        }
    }
}
