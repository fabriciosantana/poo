public class Fibonacci {

    public static long calcularFibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("O número deve ser não negativo.");
        }
        
        if (n == 0) {
            return 0;
        }
        
        if (n == 1) {
            return 1;
        }

        long a = 0;
        long b = 1;
        long resultado = 0;

        for (int i = 2; i <= n; i++) {
            resultado = a + b;
            a = b;
            b = resultado;
        }

        return resultado;
    }

    public static String formatarSaida(long valor, int n) {
        return "O " + n + "º número de Fibonacci é: " + valor;
    }

    public static void main(String[] args) {
        System.out.println("Calculando alguns números da sequência de Fibonacci:");
        System.out.println("---------------------------------------------------");
        
        int n1 = 15;
        long fib1 = calcularFibonacci(n1);
        System.out.println(formatarSaida(fib1, n1)); 

        int n2 = 65;
        long fib2 = calcularFibonacci(n2);
        System.out.println(formatarSaida(fib2, n2)); 

        System.out.println("\n---------------------------------------------------");
        // System.out.println("Tentando calcular com um valor negativo:");
        try {
            int nInvalido = -5;
            calcularFibonacci(nInvalido);
        } catch (IllegalArgumentException e) {
            System.err.println("Erro esperado: " + e.getMessage());
        }
    }
}