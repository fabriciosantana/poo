import java.util.*;

/** Testes unitários sem dependências para compilação direta com Java 21. */
public class CollectionsDemoTest {
    private static int verificacoes = 0;

    private static void igual(Object esperado, Object real, String nome) {
        verificacoes++;
        if (!Objects.equals(esperado, real)) {
            throw new AssertionError(nome + ": esperado " + esperado + ", recebido " + real);
        }
    }

    private static void deveFalhar(Class<? extends Throwable> tipo, Runnable operacao, String nome) {
        verificacoes++;
        try { operacao.run(); }
        catch (Throwable erro) {
            if (tipo.isInstance(erro)) return;
            throw new AssertionError(nome + ": exceção inesperada " + erro, erro);
        }
        throw new AssertionError(nome + ": exceção esperada " + tipo.getSimpleName());
    }

    public static void main(String[] args) {
        igual(List.of("Ana"), CollectionsDemo.operarLista(), "ArrayList iterator.remove");
        igual(List.of("Ana", "Bia"), CollectionsDemo.operarLinkedList(), "LinkedList");
        igual("topo", CollectionsDemo.pilhaLifo(), "LIFO");
        igual("primeiro", CollectionsDemo.filaFifo(), "FIFO");
        igual(List.of("B", "C", "A"), CollectionsDemo.filaPrioridades(), "Prioridades e empate");
        igual(Set.of(2, 3, 4), CollectionsDemo.conjuntoUnico(), "HashSet deduplica");
        igual(List.of("java", "poo", "colecoes"), CollectionsDemo.conjuntoInsercao(), "LinkedHashSet");
        igual(new TreeSet<>(List.of(18,20,25)), CollectionsDemo.conjuntoOrdenado(), "TreeSet ordena");
        igual(20, CollectionsDemo.conjuntoOrdenado().floor(22), "TreeSet floor");
        igual(2, CollectionsDemo.conjuntoOrdenado().size() - 1, "TreeSet tamanho relativo");
        igual(Map.of("A", 6, "B", 3), CollectionsDemo.estoque(), "HashMap merge");
        igual(List.of("B", "A"), CollectionsDemo.mapaInsercao(), "LinkedHashMap ordena inserção");
        igual(List.of(10,20,30), new ArrayList<>(CollectionsDemo.mapaOrdenado().keySet()), "TreeMap chaves");
        igual(Map.of(10,"A",20,"B"), CollectionsDemo.mapaOrdenado().subMap(10,true,30,false), "TreeMap faixa");
        igual(List.of(5,8,8,10), CollectionsDemo.ordenarNotas(), "Collections sort");
        igual(2, Collections.frequency(CollectionsDemo.ordenarNotas(), 8), "Collections frequency");
        igual(5, Collections.min(CollectionsDemo.ordenarNotas()), "Collections min");
        igual(10, Collections.max(CollectionsDemo.ordenarNotas()), "Collections max");
        igual(true, Collections.disjoint(List.of(1,2), List.of(3,4)), "Collections disjoint");
        igual(List.of("C","B","A"), CollectionsDemo.sequencedReverso(), "SequencedCollection Java 21");
        igual(1, CollectionsDemo.exemploComparatorEquivalente(), "Comparator zero");
        igual(List.of("Caneta azul"), CollectionsDemo.nomesDeProdutos(), "Produto");
        igual(3, List.of("A","B","C").size(), "List.of");
        deveFalhar(UnsupportedOperationException.class, () -> List.of("A").add("B"), "List.of imutável");
        deveFalhar(NullPointerException.class, () -> List.of("A",null), "List.of null");
        deveFalhar(IllegalArgumentException.class, () -> Set.of("A","A"), "Set.of duplicados");
        deveFalhar(IllegalArgumentException.class, () -> Map.of("A",1,"A",2), "Map.of chave duplicada");
        deveFalhar(NullPointerException.class, () -> new ArrayDeque<String>().add(null), "ArrayDeque null");
        deveFalhar(NullPointerException.class, () -> new PriorityQueue<Integer>().add(null), "PriorityQueue null");
        List<String> original = new ArrayList<>(List.of("A"));
        List<String> visao = Collections.unmodifiableList(original);
        original.add("B");
        igual(List.of("A","B"), visao, "unmodifiableList é visão");
        deveFalhar(UnsupportedOperationException.class, () -> visao.add("C"), "unmodifiableList bloqueia escrita");
        List<String> mutavel = new ArrayList<>(List.of("A"));
        mutavel.add("B");
        igual(List.of("A","B"), mutavel, "cópia modificável");
        Iterator<String> iterador = new ArrayList<>(List.of("A")).iterator();
        deveFalhar(IllegalStateException.class, iterador::remove, "Iterator.remove sem next");
        Queue<Integer> prioridade = new PriorityQueue<>(List.of(4,1,3,2));
        List<Integer> retirados = new ArrayList<>();
        while (!prioridade.isEmpty()) retirados.add(prioridade.poll());
        igual(List.of(1,2,3,4), retirados, "PriorityQueue poll ordenado");
        System.out.println("TESTES_OK: " + verificacoes + " verificações executadas");
    }
}
