public class Q05 {
    public static void main(String[] args) {
        int k = 0;

        for (int i = 10; i > 0; i--) {
            while (i > 3) i -= 3;
            k += 1;
        }
        System.out.println(k);
    }
}
