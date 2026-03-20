import java.util.Scanner;

public class MedianCalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro numero: ");
        int num1 = scanner.nextInt();

        System.out.print("Digite o segundo numero: ");
        int num2 = scanner.nextInt();

        System.out.print("Digite o terceiro numero: ");
        int num3 = scanner.nextInt();

        int median = MedianCalculator.findMedian(num1, num2, num3);

        System.out.println("A mediana dos numeros e: " + median);

        scanner.close();
    }
}
