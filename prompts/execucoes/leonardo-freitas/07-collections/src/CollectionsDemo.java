import java.util.*;

/**
 * Demonstrações de Java Collections Framework, compiladas com JDK 21.
 * Todos os exemplos usam apenas a biblioteca padrão Java.
 */
public class CollectionsDemo {
    public record Produto(int codigo, String nome, int quantidade) {}
    public record Atendimento(String paciente, int gravidade, int chegada) {}

    public static List<String> operarLista() {
        List<String> nomes = new ArrayList<>(List.of("Ana", "Bia", "Ana"));
        nomes.set(1, "Beatriz");
        nomes.remove("Ana");
        Iterator<String> it = nomes.iterator();
        while (it.hasNext()) {
            if (it.next().equals("Beatriz")) it.remove();
        }
        return nomes;
    }

    public static List<String> operarLinkedList() {
        LinkedList<String> nomes = new LinkedList<>();
        nomes.addFirst("Bia");
        nomes.addLast("Caio");
        nomes.addFirst("Ana");
        nomes.removeLast();
        return nomes;
    }

    public static String pilhaLifo() {
        Deque<String> pilha = new ArrayDeque<>();
        pilha.push("base");
        pilha.push("topo");
        return pilha.pop();
    }

    public static String filaFifo() {
        Deque<String> fila = new ArrayDeque<>();
        fila.offerLast("primeiro");
        fila.offerLast("segundo");
        return fila.pollFirst();
    }

    public static List<String> filaPrioridades() {
        Comparator<Atendimento> prioridade =
            Comparator.comparingInt(Atendimento::gravidade).reversed()
                      .thenComparingInt(Atendimento::chegada);
        Queue<Atendimento> fila = new PriorityQueue<>(prioridade);
        fila.offer(new Atendimento("A", 2, 1));
        fila.offer(new Atendimento("B", 5, 2));
        fila.offer(new Atendimento("C", 5, 3));
        List<String> saida = new ArrayList<>();
        while (!fila.isEmpty()) saida.add(fila.poll().paciente());
        return saida;
    }

    public static Set<Integer> conjuntoUnico() {
        return new HashSet<>(List.of(4, 2, 4, 3, 2));
    }

    public static List<String> conjuntoInsercao() {
        Set<String> tags = new LinkedHashSet<>(List.of("java", "poo", "java", "colecoes"));
        return new ArrayList<>(tags);
    }

    public static NavigableSet<Integer> conjuntoOrdenado() {
        return new TreeSet<>(List.of(20, 18, 20, 25));
    }

    public static Map<String, Integer> estoque() {
        Map<String, Integer> estoque = new HashMap<>();
        estoque.merge("A", 2, Integer::sum);
        estoque.merge("B", 3, Integer::sum);
        estoque.merge("A", 4, Integer::sum);
        return estoque;
    }

    public static List<String> mapaInsercao() {
        Map<String, Integer> mapa = new LinkedHashMap<>();
        mapa.put("B", 2);
        mapa.put("A", 1);
        mapa.put("B", 4);
        return new ArrayList<>(mapa.keySet());
    }

    public static NavigableMap<Integer, String> mapaOrdenado() {
        NavigableMap<Integer, String> mapa = new TreeMap<>();
        mapa.put(30, "C");
        mapa.put(10, "A");
        mapa.put(20, "B");
        return mapa;
    }

    public static List<Integer> ordenarNotas() {
        List<Integer> notas = new ArrayList<>(List.of(8, 5, 8, 10));
        Collections.sort(notas);
        return notas;
    }

    public static List<String> sequencedReverso() {
        SequencedCollection<String> colecao = new ArrayList<>(List.of("A", "B", "C"));
        return new ArrayList<>(colecao.reversed());
    }

    public static int exemploComparatorEquivalente() {
        Set<Produto> produtos = new TreeSet<>(Comparator.comparingInt(Produto::codigo));
        produtos.add(new Produto(1, "Caderno", 3));
        produtos.add(new Produto(1, "Caneta", 10));
        return produtos.size();
    }

    public static List<String> nomesDeProdutos() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(1, "Caderno", 3));
        produtos.add(new Produto(2, "Caneta", 7));
        produtos.set(1, new Produto(2, "Caneta azul", 8));
        Iterator<Produto> it = produtos.iterator();
        while (it.hasNext()) if (it.next().codigo() == 1) it.remove();
        List<String> nomes = new ArrayList<>();
        for (Produto produto : produtos) nomes.add(produto.nome());
        return nomes;
    }

    public static void main(String[] args) {
        System.out.println("ArrayList: " + operarLista());
        System.out.println("LinkedList: " + operarLinkedList());
        System.out.println("ArrayDeque LIFO: " + pilhaLifo());
        System.out.println("ArrayDeque FIFO: " + filaFifo());
        System.out.println("PriorityQueue (poll): " + filaPrioridades());
        System.out.println("HashSet (ordem não garantida): " + conjuntoUnico());
        System.out.println("LinkedHashSet: " + conjuntoInsercao());
        System.out.println("TreeSet: " + conjuntoOrdenado());
        System.out.println("HashMap (ordem não garantida): " + estoque());
        System.out.println("LinkedHashMap: " + mapaInsercao());
        System.out.println("TreeMap: " + mapaOrdenado());
        System.out.println("Collections.sort: " + ordenarNotas());
        System.out.println("SequencedCollection.reversed: " + sequencedReverso());
        System.out.println("TreeSet por codigo (equivalentes): " + exemploComparatorEquivalente());
        System.out.println("Produtos: " + nomesDeProdutos());
    }
}
