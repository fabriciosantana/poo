import java.util.Scanner;
//02-05
public class MedianCalculator{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n1, n2, n3;

        System.out.println("Digite o primeiro número: ");
        n1 = scanner.nextInt();

        System.out.println("Digite o segundo número: ");
        n2 = scanner.nextInt();

        System.out.println("Digite o terceiro número: ");
        n3 = scanner.nextInt();

        int mediana = findMedian(n1, n2, n3);
        System.out.println("A mediana dos números é: " + mediana);
    }

    public static int findMedian(int n1, int n2, int n3){
    // Mediana Maior que 1 e menor do que o outro
        if (n1 >= n2 && n1 <= n3 || n1>= n3 && n1 <= n2){
            return n1;
        } else if (n2 >= n1 && n2 <= n3 || n2 >= n3 && n2 <= n1){
            return n2;
        } else if (n3 >= n2 && n3 <= n1 || n3 >= n1 && n3 <= n2){
            return n3;
        }
        return 0;
    }

}