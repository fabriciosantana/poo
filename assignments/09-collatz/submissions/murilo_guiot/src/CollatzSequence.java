public class CollatzSequence {

    private CollatzSequence() {}
    
    public static int nextCollatz(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("O número inicial deve ser um inteiro positivo.");
        }

        if (n % 2 == 0) {
            // Número é par
            return n / 2;
        } else {
            // Número é ímpar
            return 3 * n + 1;
        }
    }

    public static int calculateCollatzSum(int start) {
        if (start <= 0) {
            throw new IllegalArgumentException("O número inicial deve ser um inteiro positivo.");
        }

        long currentNumber = start;
        long sum = 0;

        while (currentNumber != 1) {
            sum += currentNumber;
            currentNumber = nextCollatz((int) currentNumber);
        }
        
        sum += 1;

        return (int) sum;
    }

    public static void main(String[] args) {
        int startNumber1 = 6;
        int startNumber2 = 11;

        System.out.println("--- Sequência de Collatz ---");
        
        System.out.println("Calculando a soma para o número inicial: " + startNumber1);
        int sum1 = calculateCollatzSum(startNumber1);
        System.out.println("A soma da sequência é: " + sum1 + " (Esperado: 55)");

        System.out.println("\nCalculando a soma para o número inicial: " + startNumber2);
        int sum2 = calculateCollatzSum(startNumber2);
        System.out.println("A soma da sequência é: " + sum2 + " (Esperado: 259)");
        System.out.println("----------------------------");
    }
}