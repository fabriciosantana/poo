public class CollatzSequence {

    // Retorna o próximo termo da sequência de Collatz
    public static int nextCollatz(int n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return n * 3 + 1;
        }
    }

    // Gera a sequência de Collatz e retorna a soma dos termos
    public static int calculateCollatzSum(int n) {
        int sum = 0;
        while (n != 1) {
            sum += n;
            n = nextCollatz(n);
        }
        sum += 1; // Adiciona o último termo (1)
        return sum;
    }

    // Gera a sequência como uma String para exibição
    public static String generateCollatzSequence(int n) {
        StringBuilder sequence = new StringBuilder();
        while (n != 1) {
            sequence.append(n).append(" → ");
            n = nextCollatz(n);
        }
        sequence.append("1");
        return sequence.toString();
    }
}