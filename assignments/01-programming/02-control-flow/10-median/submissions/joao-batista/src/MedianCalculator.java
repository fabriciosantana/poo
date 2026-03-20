import java.util.Scanner;

public class MedianCalculator {

    public static int findMedian(int a, int b, int c) {
        if ((a <= b && b <= c) || (c <= b && b <= a)) {
            return b;
        } else if ((a <= c && c <= b) || (b <= c && c <= a)) {
            return c;
        } else {
            return a;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int num1 = input.nextInt();

        System.out.print("Digite o segundo número: ");
        int num2 = input.nextInt();

        System.out.print("Digite o terceiro número: ");
        int num3 = input.nextInt();

        int median = findMedian(num1, num2, num3);
        System.out.println("A mediana dos números é: " + median);

        input.close();
    }
}