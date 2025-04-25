public class Q10 {
    public static void main(String[] args) {
        try {
            System.out.printf("Input: %s%n", args[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.printf("Exception: %s%n", e);
        } finally {
            System.out.printf("Follow execution%n");
        }
    } 
} 
