import java.util.Arrays;

public class MedianCalculator {

    public static int findMedian(int a, int b, int c) {
        int[] numbers = {a, b, c};
        Arrays.sort(numbers);
        return numbers[1];
    }

    public static void main(String[] args) {
        System.out.println("Demonstrando o cálculo da mediana:");

        int a = 7, b = 2, c = 5;
        System.out.printf("A mediana entre %d, %d e %d é: %d%n", a, b, c, findMedian(a, b, c)); 

        int d = 2, e = 2, f = 7;
        System.out.printf("A mediana entre %d, %d e %d é: %d%n", d, e, f, findMedian(d, e, f)); 

        int g = -10, h = -5, i = -20;
        System.out.printf("A mediana entre %d, %d e %d é: %d%n", g, h, i, findMedian(g, h, i)); 

        int j = 7, k = 7, l = 7;
        System.out.printf("A mediana entre %d, %d e %d é: %d%n", j, k, l, findMedian(j, k, l)); 
        }
}