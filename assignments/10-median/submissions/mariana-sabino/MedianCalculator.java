import java.util.Scanner;

public class MedianCalculator {
    public static void main(String[] args){
    Scanner leitor = new Scanner (System.in);

System.out.println("Digite o primeiro número: ");
int num1 = leitor.nextInt();

System.out.println("Digite o segundo número: ");
int num2 = leitor.nextInt();

System.out.println("Digite o terceiro número: ");
int num3 = leitor.nextInt();

leitor.close();

int mediana = findMedian(num1, num2, num3);
System.out.printf("A mediana dos números é: %d%n", mediana);

    }

public static int findMedian(int a, int b, int c){
    if ((a >= b && a <= c) || (a <= b && a >= c)) {
            return a;
    } else if ((b >= a && b <= c) || (b <= a && b >= c)){
            return b;
    } else {
        return c;
    }

}
  
}

































}