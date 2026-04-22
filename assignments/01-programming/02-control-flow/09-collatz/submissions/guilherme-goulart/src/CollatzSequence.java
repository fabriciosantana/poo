import java.util.Scanner;

public class CollatzSequence {
    
    public static int nextCollatz(int n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return (n * 3) + 1;
        }
    }

    public static int calculateCollatzSum(int n) {
        int sum = 0;
        StringBuilder sequence = new StringBuilder();
        
        while (n != 1) {
            sum += n;
            sequence.append(n).append(" -> ");
            n = nextCollatz(n);
        }
        
        sum += 1;
        sequence.append(1);
        
        System.out.println("Sequência de Collatz: " + sequence.toString());
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite um número inteiro positivo: ");
        
        int n = scanner.nextInt();
        
        if (n < 1) {
            System.out.println("Erro: O número deve ser um inteiro positivo.");
            return;
        }
        
        int sum = calculateCollatzSum(n);
        
        System.out.println("Soma dos termos: " + sum);
    }
}
