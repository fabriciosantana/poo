import java.util.Scanner;

class CollatzSequence {

    public static int nextCollatz(int n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return 3 * n + 1;
        }
    }

    public static int calculateCollatzSum(int n) {
        int sum = n; 
        int current = n;

        System.out.print("Sequência de Collatz: " + current);

        while (current != 1) {
            current = nextCollatz(current);
            System.out.print(" → " + current);
            sum += current;
        }

        System.out.println(); 
        return sum;
    }
}
