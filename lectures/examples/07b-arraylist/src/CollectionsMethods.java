import java.util.ArrayList;
import java.util.Collections;

public class CollectionsMethods {
    public static void main(String[] args){
        ArrayList<String> cidades = new ArrayList<>();
        
        cidades.add("Rio de Janeiro");
        cidades.add("Goiânia");
        cidades.add("Recife");
        cidades.add("Brasília");
        
        Collections.sort(cidades);

        System.out.println("Imprimindo cidades na ordem natural");
        for (String c : cidades)
            System.out.println(c);

        int index = Collections.binarySearch(cidades, "Brasília");

        if (index >= 0)
            System.out.printf("Elemento %s encontado na posição %d%n", cidades.get(index), index);
        
        System.out.println("Imprimindo cidades na ordem reversa");
        Collections.reverse(cidades);
        for (String c : cidades)
            System.out.println(c);

        Collections.addAll(cidades, "Florianópolis", "Porto Alegre",  "Caxias do Sul");

        System.out.println("Imprimindo mais cidades");
        for (String c : cidades)
            System.out.println(c);
        
    }
}
