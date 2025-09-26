import java.util.Arrays;

public class ArrayElipsis {

    public static void main(String... args){

        if (args[0].equals("-n"))
            System.out.println("Hello, " + args[1]);
        else
            System.out.println("Help");

        String[] nomes = {"Fabricio", "Felipe", "Pietro", "Luan"};

        metodoTestArray(nomes);
        System.out.println(Arrays.toString(nomes));

        metodoTestElipsis("Fabricio", "Felipe", "Luan");
        metodoTestElipsis(nomes);

        System.out.println(Arrays.toString(nomes));

        metodoTestSobrecarregado("Fabricio");
        metodoTestSobrecarregado("Fabricio", "Felipe");

        System.out.println("------------");

        Arrays.sort(nomes);
        System.out.println(Arrays.toString(nomes));
    }

    public static void metodoTestElipsis(String... nomes){
        
        System.out.println(nomes[0] + ", " + nomes[1] + ", " + nomes[2]);

        nomes[0] = "Mariana";
    
    }

    public static void metodoTestArray(String[] nomes){

        System.out.println(nomes[0] + ", " + nomes[1] + ", " + nomes[2]);

        nomes[0] = "André";
    
    }

     public static void metodoTestSobrecarregado(String nome1){

        System.out.println(nome1);
    
    }

    public static void metodoTestSobrecarregado(String nome1, String nome2){

        System.out.println(nome1 + ", " + nome2);
    
    }
}