public class MedianCalculator {

     // Método estático que retorna a mediana de três inteiros usando if/else
    public static int findMedian(int a, int b, int c) {
          // Se a está entre b e c, ou igual a um deles
        if ((a >= b && a <= c) || (a <= b && a >= c)) {
            return a;
        }
           // Se b está entre a e c, ou igual a um deles
        else if ((b >= a && b <= c) || (b <= a && b >= c)) {
            return b;
        }
            // Se não for a nem b, então é c
        else {
            return c;
        }
    }

        // Método principal para interação com o usuário
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int num1 = sc.nextInt();

        System.out.print("Digite o segundo número: ");
        int num2 = sc.nextInt();

        System.out.print("Digite o terceiro número: ");
        int num3 = sc.nextInt();

        int mediana = findMedian(num1, num2, num3);

        System.out.println("A mediana dos números é: " + mediana);
    }
}