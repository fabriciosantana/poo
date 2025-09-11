import java.util.Scanner;

class App {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int num1 = entrada.nextInt();

        System.out.print("Digite o segundo número: ");
        int num2 = entrada.nextInt();

        System.out.print("Digite o terceiro número: ");
        int num3 = entrada.nextInt();

        entrada.close();

        int mediana = MedianCalculator.findMedian(num1, num2, num3);

        System.out.println("A mediana dos números é: " + mediana);
    }
}

public class MedianCalculator {

    public static int findMedian(int a, int b, int c) {
        //---- Verifica se 'a' é a mediana ----//
        if ((a >= b && a <= c) || (a <= b && a >= c)) {
            return a;
        }
        //---- Condição: 'b' está entre 'a' e 'c' (ou é igual a um deles) ----//
        else if ((b >= a && b <= c) || (b <= a && b >= c)) {
            return b;
        }
        //---- Se nem 'a' nem 'b' são a mediana, então 'c' deve ser ----//
        else {
            return c;
        }
    }
}
