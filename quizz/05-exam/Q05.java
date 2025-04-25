public class Q05 {
    static int start = 2;
    final int end;
    
    public Q05(int x) {
        x = 4;
        end = x;
    }

    public void fly(int distance) {
        System.out.print(end-start+" ");
        System.out.print(distance);
    }

    public static void main(String... start) {
        new Q05(10).fly(5);
    } 
} 
