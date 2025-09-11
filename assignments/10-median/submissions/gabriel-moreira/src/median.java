import java.util.Scanner;

public class MedianCalculator {

    public static int encontrarMediana(int num1, int num2, int num3) {
        if ((num1 >= num2 && num1 <= num3) || (num1 <= num2 && num1 >= num3)) {
            return num1;
        } else if ((num2 >= num1 && num2 <= num3) || (num2 <= num1 && num2 >= num3)) {
            return num2;
        } else {
            return num3;
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Digite o primeiro número: ");
        int primeiroNumero = entrada.nextInt();

        System.out.print("Digite o segundo número: ");
        int segundoNumero = entrada.nextInt();
        
        System.out.print("Digite o terceiro número: ");
        int terceiroNumero = entrada.nextInt();

        int mediana = encontrarMediana(primeiroNumero, segundoNumero, terceiroNumero);
        
        System.out.println("A mediana dos números é: " + mediana);

        entrada.close();
    }
}