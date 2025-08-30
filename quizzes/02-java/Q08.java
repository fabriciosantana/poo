public class Q08 {
    public void main(String[] args) {
        op(false, false);
        op(true, false);
        op(false, true);
        op(true, true);
    }

    static void op(boolean a, boolean b) {
        boolean c = a != b;
        boolean d = a ^ b;
        boolean e = c == d;
        System.out.println(e);
    }
}
