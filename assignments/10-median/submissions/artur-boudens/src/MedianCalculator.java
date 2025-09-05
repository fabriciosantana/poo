import java.util.Scanner;

public class MedianCalculator {
    public static int findMedian(int a, int b, int c){
        if((b <= a && a <= c) || (c <= a && a <= b)){
            return a;
        }
        else if((b <= c && c <= a) || (a <= c && c <= b)){
            return c;
        }
        else return b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = 0, num2 = 0, num3 = 0;

        System.out.print("Digite o primeiro número: ");
        num1 = scanner.nextInt();
        System.out.print("Digite o segundo número: ");
        num2 = scanner.nextInt();
        System.out.print("Digite o terceiro número: ");
        num3 = scanner.nextInt();

        System.out.println("A mediana dos números é: " + findMedian(num1, num2, num3));
    }
    
}
