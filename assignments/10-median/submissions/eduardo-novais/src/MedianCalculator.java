import java.util.Scanner;

public class MedianCalculator {
    public static int findMedian(int a, int b, int c) {
        if ((a >= b && a <= c) || (a <= b && a >= c)) {
            return a;
        } else if ((b >= a && b <= c) || (b <= a && b >= c)) {
            return b;
        } else {
            return c;
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
