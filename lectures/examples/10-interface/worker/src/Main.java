interface IA { int doIt(); }

interface IB { int doIt(); }

interface IC { int doIt(); }

interface ID { double doIt(); }

abstract class CombinedAB implements IA, IB { }

//abstract class CombinedCD implements IC, ID { } //Erro

class Worker implements IA, IB {

    @Override
    public int doIt() { return 0; }
} 

/*
class ChallengedWorker implements IC, ID { //Erro
    
    @Override
    public int doIt() { return 0; }
    
    
    @Override
    public double doIt() {
    System.out.println("Sorry!");
    return = 0.0;
    } 
}
*/

public class Main {
    public static void main(String[] args) {
        Worker w = new Worker();
        System.out.println(w.doIt());
    }
}


