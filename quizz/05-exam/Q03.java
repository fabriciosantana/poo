class Base {
    public Base() {
        System.out.print("Base ");
    }
    public Base(String s) {
        System.out.print("Base: " + s);
    }
}

class Derived extends Base {
    public Derived(String s) {
        //super(); // Stmt-1
        //super(s); // Stmt-2
        System.out.print("Derived ");
    }
}

public class Q03 {
    public static void main(String []args) {
        Base a = new Derived("Hello ");
    }
}
