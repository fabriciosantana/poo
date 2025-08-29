import java.util.Scanner;

class Fibonacci{

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
    
        System.out.print("Digite um número inteiro não negativo: ");
        int n = ler.nextInt();

        if (n < 0){
            System.out.println("O número deve ser um inteiro não negativo.");
        } else {
            long resultadoFibonacci = calcular_Fibonacci(n);
            String saidaFormatada = formatarSaida(n, resultadoFibonacci);
            
            System.out.println(saidaFormatada);
        }

        ler.close();
    }

    public static long calcularFibonacci(int n){
        if (n <= 1){
            return n;            
        }
        long num_ante = 0;
        long num_atual = 1;

        for (int i = 2; i <= n; i++){
            long proximo = num_ante + num_atual;
            num_ante = num_atual;
            num_atual = proximo;
        }
        return num_atual;
    }

    public static String formatarSaida(int n, long fibonacci_calculado){
        return "O " + n + "º número de Fibonacci é: " + fibonacci_calculado;
    }
}