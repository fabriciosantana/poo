public class CollatzSequence {

    public static long nextCollatz(long n) {
        return (n % 2 == 0) ? n / 2 : (3 * n + 1);
    }

    public static long calculateCollatzSum(long n) {
        long sum = 0;
        long current = n;

        while (true) {
            sum += current;

            if (current == 1) {
                break;
            }

            current = nextCollatz(current);
        }

        return sum;
    }
}