import java.util.Scanner;

public class MedianCalculator {

    public static int findMedian(int a, int b, int c) {
        if ((b <= a && a <= c) || (c <= a && a <= b)) {
            return a;
        } else if ((a <= b && b <= c) || (c <= b && b <= a)) {
            return b;
        } else {
            return c;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int num1 = scanner.nextInt();

        System.out.print("Digite o segundo número: ");
        int num2 = scanner.nextInt();

        System.out.print("Digite o terceiro número: ");
        int num3 = scanner.nextInt();

        scanner.close();

        int median = findMedian(num1, num2, num3);

        System.out.println("A mediana dos números é: " + median);
    }
}