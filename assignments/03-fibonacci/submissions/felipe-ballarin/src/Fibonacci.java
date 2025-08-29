import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número inteiro não negativo: ");
        long n = scanner.nextInt();

        long Fibonacci = calcularFibonacci(n);

        formatarSaida(n, Fibonacci);
        scanner.close();
    }

    static long calcularFibonacci(long n){

        if( n == 0){
            return 0;
        }else if (n == 1) {
            return 1;
        }else{
            return calcularFibonacci(n-1) + calcularFibonacci(n-2);
        } 

    }

    static void formatarSaida(long n, long fibonacci) {

        System.out.printf("\nO  %d%nº número de Fibonacci é: %d%n", n, fibonacci);

    }

}
