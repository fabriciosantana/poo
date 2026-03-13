import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número inteiro não negativo:  ");
        int n = scanner.nextInt();
        if( n < 0){
            System.out.println("Número inválido. Por favor, digite um número inteiro não negativo.");
            return;
        }

        long resultado = calcularFibonacci(n);
        formatarSaida(n, resultado);

    }
    public static int calcularFibonacci(int n){

        long a = 0;
        long b = 1;
        long proximo = 0;

        if( n == 0){
            return 0;
        } else 
        if (n == 1){
            return 1;
        } else {
            for(int i = 2; i <= n; i++){
                proximo = a + b;
                a = b;
                b = proximo;
            }
            return (int) b;
        }
    }
    public static long formatarSaida(int n, long resultado){
        System.out.printf("O %dº da sequencia de Fibbonaci: %d\n", n, resultado);
        return resultado;
    }
    
}
/*
 A sequência de Fibonacci é definida da seguinte forma:
 F(0) = 0
 F(1) = 1
 F(n) = F(n-1) + F(n-2) para n > 1
 Exemplos:
 F(2) = F(1) + F(0) = 1 + 0 = 1
 F(3) = F(2) + F(1) = 1 + 1 = 2
 F(4) = F(3) + F(2) = 2 + 1 = 3
 F(5) = F(4) + F(3) = 3 + 2 = 5
 F(6) = F(5) + F(4) = 5 + 3 = 8
 F(7) = F(6) + F(5) = 8 + 5 = 13
 charlie
*/
