import java.util.Scanner;

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

public class MedianApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int num1 = sc.nextInt();

        System.out.print("Digite o segundo número: ");
        int num2 = sc.nextInt();

        System.out.print("Digite o terceiro número: ");
        int num3 = sc.nextInt();

        int mediana = MedianCalculator.findMedian(num1, num2, num3);

        System.out.println("A mediana dos números é: " + mediana);
    }
}
