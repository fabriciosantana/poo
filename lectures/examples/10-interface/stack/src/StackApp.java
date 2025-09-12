public class StackApp {
    public static void main(String[] args) {
        SafeStack  safeStackRef  = new SafeStack(10);

        Stack      stackRef      = safeStackRef;
        ISafeStack isafeStackRef = safeStackRef;
        IStack     istackRef     = safeStackRef;
        //Object     objRef        = safeStackRef;

        safeStackRef.push("Dollars");
        stackRef.push("Kroner");
        isafeStackRef.push("Real");
        istackRef.push("Peso");
        
        System.out.println(isafeStackRef.pop());
        System.out.println(istackRef.pop());
        //System.out.println(objRef.getClass());
    } 
} 