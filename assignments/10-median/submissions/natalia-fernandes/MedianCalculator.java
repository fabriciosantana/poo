import java.util.Scanner;

public class MedianCalculator {

    // Método para encontrar a mediana de três inteiros
    public static int findMedian(int a, int b, int c) {
        // Se a está no meio
        if ((a >= b && a <= c) || (a <= b && a >= c)) {
            return a;
        }
        // Se b está no meio
        else if ((b >= a && b <= c) || (b <= a && b >= c)) {
            return b;
        }
        // Se não for a nem b, a mediana só pode ser c
        else {
            return c;
        }
    }

    // Programa principal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int num1 = sc.nextInt();

        System.out.print("Digite o segundo número: ");
        int num2 = sc.nextInt();

        System.out.print("Digite o terceiro número: ");
        int num3 = sc.nextInt();

        int mediana = findMedian(num1, num2, num3);

        System.out.println("A mediana dos números é: " + mediana);

        sc.close();
    }
}
