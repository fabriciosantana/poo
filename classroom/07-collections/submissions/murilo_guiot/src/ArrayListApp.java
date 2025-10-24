package submissions.murilo_guiot.src;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListApp {

    public static void main(String[] args) {

        ArrayList<String> cores = new ArrayList<>();
        cores.add("Verde");
        cores.add("Amarelo");
        cores.add("Azul");
        cores.add("Branco");
        cores.add("Preto");
        System.out.println("Lista de Cores: " + cores);
        
        for (String cor : cores) {
            System.out.println(cor);
        }
        
        cores.add(0, "Vermelho");
        System.out.println("Lista após inserção na 1ª posição: " + cores);
        System.out.println("-------------------------------------");

        int indice = 2;
        if (indice >= 0 && indice < cores.size()) {
            String elemento = cores.get(indice);
            System.out.println("Elemento no índice " + indice + ": " + elemento);
        } else {
            System.out.println("Índice " + indice + " fora dos limites da lista.");
        }
        
        String novoValor = "Laranja";
        String elementoAntigo = cores.set(4, novoValor); 
        System.out.println("Elemento substituído (antigo): " + elementoAntigo);
        System.out.println("Lista após atualização: " + cores);
        
        int indiceRemover = 2;
        if (indiceRemover >= 0 && indiceRemover < cores.size()) {
            String removido = cores.remove(indiceRemover);
            System.out.println("Elemento removido (índice " + indiceRemover + "): " + removido);
        } else {
            System.out.println("Não foi possível remover, índice " + indiceRemover + " fora dos limites.");
        }
        System.out.println("Lista após remoção: " + cores);
        
        String elementoBusca = "Azul";
        boolean estaPresente = cores.contains(elementoBusca);
        System.out.println("O elemento \"" + elementoBusca + "\" está presente? " + estaPresente);
        System.out.println("-------------------------------------");

        Collections.sort(cores);
        System.out.println("Lista ordenada: " + cores);
        System.out.println("-------------------------------------");

        ArrayList<String> coresCopia = new ArrayList<>(cores);
        System.out.println("Nova lista (Cópia): " + coresCopia);
        
        Collections.shuffle(cores);
        System.out.println("Lista embaralhada: " + cores);
        
        Collections.reverse(cores);
        System.out.println("Lista invertida: " + cores);
        
        int fromIndex = 1;
        int toIndex = 4;
        if (fromIndex >= 0 && toIndex <= cores.size() && fromIndex <= toIndex) {
            List<String> subLista = cores.subList(fromIndex, toIndex);
            System.out.println("Sublista (índices " + fromIndex + " a " + (toIndex - 1) + "): " + subLista);
        } else {
            System.out.println("Índices inválidos para sublista.");
        }
        
        ArrayList<String> lista1 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        ArrayList<String> lista2 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        ArrayList<String> lista3 = new ArrayList<>(Arrays.asList("C", "B", "A"));
        System.out.println("Lista 1: " + lista1);
        System.out.println("Lista 2: " + lista2);
        System.out.println("Lista 3: " + lista3);
        System.out.println("Lista 1 é igual à Lista 2? " + lista1.equals(lista2));
        System.out.println("Lista 1 é igual à Lista 3? " + lista1.equals(lista3));
        
        System.out.println("Lista antes da troca: " + cores);
        int indiceTroca1 = 1;
        int indiceTroca2 = 4;
        if (indiceTroca1 >= 0 && indiceTroca1 < cores.size() && indiceTroca2 >= 0 && indiceTroca2 < cores.size()) {
            Collections.swap(cores, indiceTroca1, indiceTroca2);
            System.out.println("Lista após troca (índices " + indiceTroca1 + " e " + indiceTroca2 + "): " + cores);
        } else {
            System.out.println("Índices inválidos para a troca.");
        }
        System.out.println("-------------------------------------");

        ArrayList<String> coresAdicionais = new ArrayList<>(Arrays.asList("Roxo", "Cinza"));
        ArrayList<String> coresUnidas = new ArrayList<>(cores);
        coresUnidas.addAll(coresAdicionais);
        System.out.println("Lista Original (cores): " + cores);
        System.out.println("Lista Adicional: " + coresAdicionais);
        System.out.println("Lista Unida: " + coresUnidas);
        
        @SuppressWarnings("unchecked")
        ArrayList<String> coresClonadas = (ArrayList<String>) cores.clone();
        System.out.println("Lista Clonada: " + coresClonadas);
        System.out.println("-------------------------------------");

        ArrayList<String> coresParaLimpar = new ArrayList<>(Arrays.asList("A", "B", "C"));
        System.out.println("Lista antes de limpar: " + coresParaLimpar);
        coresParaLimpar.clear();
        System.out.println("Lista após limpar: " + coresParaLimpar);
        System.out.println("-------------------------------------");

        boolean vazia = coresParaLimpar.isEmpty();
        System.out.println("A lista está vazia? " + vazia);
        System.out.println("-------------------------------------");

        coresClonadas.trimToSize();
        System.out.println("Lista após trimToSize (capacidade reduzida ao tamanho atual): " + coresClonadas);
        System.out.println("-------------------------------------");

        
        coresClonadas.ensureCapacity(20);
        System.out.println("Lista após ensureCapacity (capacidade mínima garantida de 20): " + coresClonadas);
        System.out.println("-------------------------------------");

        int indiceSubstituir = 1;
        String novoElemento = "Ciano";
        if (indiceSubstituir >= 0 && indiceSubstituir < cores.size()) {
            cores.set(indiceSubstituir, novoElemento);
            System.out.println("Lista após substituição do 2º elemento (índice " + indiceSubstituir + "): " + cores);
        } else {
            System.out.println("Não foi possível substituir, índice " + indiceSubstituir + " fora dos limites.");
        }
        System.out.println("-------------------------------------");

        // 22. Print Elements by Position
        System.out.println("--- 22. Print Elements by Position ---");
        for (int i = 0; i < cores.size(); i++) {
            System.out.println(i + " -> " + cores.get(i));
        }
    }
}