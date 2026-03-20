public class CollatzSequence {
    public static int nextCollatz(int n) {
        if (n % 2 == 0) {
            return n / 2;
        }
        return (n * 3) + 1;
    }

    public static long calculateCollatzSum(int n) {
        long sum = 0;
        int current = n;

        while (current != 1) {
            sum += current;
            current = nextCollatz(current);
        }

        sum += 1;
        return sum;
    }
}
