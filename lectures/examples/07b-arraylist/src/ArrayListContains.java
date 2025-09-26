import java.util.ArrayList;

public class ArrayListContains {
    public static void main(String... args){
        ArrayList<String> names = new ArrayList<>();
        String name = "João";

        names.add("Fabricio Santana");
        names.add("Marta");
        names.add("Yuri");
        names.add("Roberta");
        names.add("André");
        names.add("Maria");
        names.add("João");
        
        if (names.contains(name))
            System.out.printf("Achou %s", name);
        else
            System.out.printf("Não achou %s", name);
    }
}
