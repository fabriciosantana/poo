import java.util.Scanner;
import java.util.Arrays;

public class MedianCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[3];

        System.out.print("Digite o primeiro número: ");
        numbers[0] = scanner.nextInt();

        System.out.print("Digite o segundo número: ");
        numbers[1] = scanner.nextInt();

        System.out.print("Digite o terceiro número: ");
        numbers[2] = scanner.nextInt();

        int median = findMedian(numbers);
        System.out.println("A mediana dos números é: " + median);

        scanner.close();
    }

    public static int findMedian(int [] numbers) {
        Arrays.sort(numbers);
        return numbers[1];
    }
}