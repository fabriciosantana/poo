import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListApp {
    public static void main(String[] args) {
        ArrayList<String> cores = new ArrayList<>();
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");

        System.out.println("1 Create and Print ArrayList: " + cores);

        System.out.println("2 Iterate ArrayList Elements:");
        for (String cor : cores) {
            System.out.println(cor);
        }

        cores.add(0, "Preto");
        System.out.println("3 Insert at First Position: " + cores);

        String indice2 = cores.size() > 2 ? cores.get(2) : null;
        System.out.println("4 Retrieve Element by Index: " + indice2);

        int idx = cores.indexOf("Azul");
        if (idx >= 0) {
            cores.set(idx, "Azul Claro");
        }
        System.out.println("5 Update ArrayList Element: " + cores);

        if (cores.size() > 2) {
            cores.remove(2);
        }
        System.out.println("6 Remove Third Element: " + cores);

        boolean contemVerde = cores.contains("Verde");
        System.out.println("7 Search Element in ArrayList: " + contemVerde);

        Collections.sort(cores);
        System.out.println("8 Sort ArrayList: " + cores);

        ArrayList<String> copia = new ArrayList<>(cores);
        System.out.println("9 Copy ArrayList: " + copia);

        Collections.shuffle(cores);
        System.out.println("10 Shuffle ArrayList: " + cores);

        Collections.reverse(cores);
        System.out.println("11 Reverse ArrayList: " + cores);

        int toIndex = Math.min(2, cores.size());
        List<String> sublista = cores.subList(0, toIndex);
        System.out.println("12 Extract Sublist from ArrayList: " + sublista);

        boolean compara = cores.equals(copia);
        System.out.println("13 Compare Two ArrayLists: " + compara);

        if (cores.size() > 1) {
            Collections.swap(cores, 0, 1);
        }
        System.out.println("14 Swap ArrayList Elements: " + cores);

        ArrayList<String> uniao = new ArrayList<>(cores);
        uniao.addAll(copia);
        System.out.println("15 Join Two ArrayLists: " + uniao);

        Object clone = cores.clone();
        System.out.println("16 Clone ArrayList: " + clone);

        cores.clear();
        System.out.println("17 Clear ArrayList: " + cores);

        boolean vazia = cores.isEmpty();
        System.out.println("18 Check if ArrayList is Empty: " + vazia);

        ArrayList<String> capacidade = new ArrayList<>();
        capacidade.add("A");
        capacidade.add("B");
        capacidade.ensureCapacity(10);
        capacidade.trimToSize();
        System.out.println("19 Trim ArrayList Capacity and 20 Increase ArrayList Capacity: " + capacidade);

        capacidade.set(1, "C");
        System.out.println("21 Replace Second Element: " + capacidade);

        System.out.println("22 Print Elements by Position:");
        for (int i = 0; i < capacidade.size(); i++) {
            System.out.println(i + " -> " + capacidade.get(i));
        }
    }
}

