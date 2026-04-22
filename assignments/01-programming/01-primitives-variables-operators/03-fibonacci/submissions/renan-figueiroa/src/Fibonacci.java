import java.util.Scanner;

public class Fibonacci{
    public static void main(String[] args) {
        System.out.print("Digite um número inteiro não negativo: ");
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long numero_fibonacci = calcularFibonacci(n);

        String saida = formatarSaida(numero_fibonacci,n );

        System.out.println(saida);

    }

    public static long calcularFibonacci(int n){
            if (n <= 1) return n;
        
            long anterior = 0, atual = 1;

            for (int i = 2; i <= n; i++) {

                long proximo = anterior + atual;
                anterior = atual;
                atual = proximo;
               
            }

        return atual;
    }
    public static String formatarSaida(long f, int n){

        String texto_exibicao = String.format("O %dº número de Fibonacci é: %d",n,f);
    
        return texto_exibicao;
    }
}