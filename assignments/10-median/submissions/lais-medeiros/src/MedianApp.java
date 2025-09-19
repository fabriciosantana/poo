import java.util.Scanner;

public class MedianApp { 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int num1 = scanner.nextInt();

        System.out.print("Digite o segundo número: ");
        int num2 = scanner.nextInt();

        System.out.print("Digite o terceiro número: ");
        int num3 = scanner.nextInt();

        int median = MedianCalculator.findMedian(num1, num2, num3);

        System.out.println("A mediana dos números é: " + median);

        scanner.close();
    }
}
