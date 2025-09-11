import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite um número inteiro não negativo: ");
        int numero = entrada.nextInt();

        long fib = calcular(numero);

        String msg = formatar(fib, numero);
        System.out.println(msg);

        entrada.close();
    }

    
    public static long calcular(int num) {
        if (num == 0) return 0;
        if (num == 1) return 1;

        long anterior = 0;
        long atual = 1;
        long proximo = 0;

        for (int i = 2; i <= num; i++) {
            proximo = anterior + atual;
            anterior = atual;
            atual = proximo;
        }

        return proximo;
    }

    
    public static String formatar(long valor, int posicao) {
        return "O " + posicao + "º número de Fibonacci é: " + valor;
    }
}
