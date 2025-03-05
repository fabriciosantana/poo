import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class FibonacciSequence {
    private static final Map<Integer, Long> cache = new HashMap<>();

    public static void main(String[] args) {
        var input = new Scanner(System.in);

        System.out.print("Informe um número inteiro não negativo: ");
        int valor = input.nextInt();

        if (valor >= 0) {
            long resultado = obterFibonacci(valor);
            System.out.println(gerarMensagem(valor, resultado));
        } else {
            System.out.println("O número precisa ser positivo.");
        }

        input.close();
    }

    public static long obterFibonacci(int num) {
        if (num == 0) return 0;
        if (num == 1) return 1;
        if (cache.containsKey(num)) return cache.get(num);

        long anterior = 1, atual = 1, prox = 0;
        for (int i = 2; i < num; i++) {
            prox = anterior + atual;
            anterior = atual;
            atual = prox;
        }

        cache.put(num, atual);
        return atual;
    }

    public static String gerarMensagem(int posicao, long valor) {
        return "O " + posicao + "º número de Fibonacci é: " + valor;
    }
}
