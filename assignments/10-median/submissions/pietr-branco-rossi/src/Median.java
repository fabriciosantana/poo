import java.util.Scanner;

public class Median {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int num1 = entrada.nextInt();

        System.out.print("Digite o segundo número: ");
        int num2 = entrada.nextInt();

        System.out.print("Digite o terceiro número: ");
        int num3 = entrada.nextInt();

        entrada.close();

        int mediana = MedianCalculator.findMedian(num1, num2, num3);

        System.out.println("A mediana dos números é: " + mediana);
    }
}

class MedianCalculator {

    public static int findMedian(int a, int b, int c) {
        
        if ((a >= b && a <= c) || (a <= b && a >= c)) {
            return a;
        } else if ((b >= a && b <= c) || (b <= a && b >= c)) {
            return b;
        } else {
            return c;
        }
    }
}