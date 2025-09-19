import java.util.Scanner;

public class MedianCalculator {

    // Método que encontra a mediana de três números usando if/else
    public static int findMedian(int a, int b, int c) {
        // Caso 1: a é a mediana
        if ((a >= b && a <= c) || (a <= b && a >= c)) {
            return a;
        }
        // Caso 2: b é a mediana
        else if ((b >= a && b <= c) || (b <= a && b >= c)) {
            return b;
        }
        // Caso 3: c é a mediana
        else {
            return c;
        }
    }

    // Método principal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Entrada dos três números
        System.out.print("Digite o primeiro número: ");
        int num1 = sc.nextInt();

        System.out.print("Digite o segundo número: ");
        int num2 = sc.nextInt();

        System.out.print("Digite o terceiro número: ");
        int num3 = sc.nextInt();

        // Calcula a mediana
        int mediana = findMedian(num1, num2, num3);

        // Saída
        System.out.println("A mediana dos números é: " + mediana);

        sc.close();
    }
}
