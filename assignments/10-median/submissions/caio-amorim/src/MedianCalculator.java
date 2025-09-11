import java.util.Scanner;

public class MedianCalculator {

 
    public static int findMedian(int a, int b, int c) {
        // Caso 1: a está no meio
        if ((a >= b && a <= c) || (a >= c && a <= b)) {
            return a;
        }
        // Caso 2: b está no meio
        else if ((b >= a && b <= c) || (b >= c && b <= a)) {
            return b;
        }
        // Caso 3: se não foi nenhum dos dois, então c é o do meio
        else {
            return c;
        }
    }

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
