public class Q06 {
    public static void main(String[] args) {
        int count = 0;

        do {
            do {
                count++;
            } while (count < 2);
            break;
        } while (true);
        System.out.println(count);
    }
}
