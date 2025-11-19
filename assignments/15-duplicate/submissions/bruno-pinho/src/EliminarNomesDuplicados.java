import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Solução para a atividade "Eliminar Nomes Duplicados".
 * * Este programa cadastra nomes sem permitir duplicatas e tratando "Ana" e "ana"
 * como iguais (case-insensitive). Em seguida, permite a busca na coleção.
 */
public class EliminarNomesDuplicados {

    public static void main(String[] args) {

        // --- 1. Inicialização ---

        // Inicializa o Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Cria um Set usando a implementação TreeSet.
        // Passamos String.CASE_INSENSITIVE_ORDER ao construtor para que
        // o Set ignore maiúsculas/minúsculas ao comparar e armazenar os nomes.
        // Isso também garante que a lista final será ordenada.
        Set<String> nomes = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        // --- 2. Fase de Cadastro de Nomes ---

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");

        while (true) {
            System.out.print("> ");
            String nomeInput = scanner.nextLine();

            // Verifica a condição de parada (ignorando case)
            if (nomeInput.equalsIgnoreCase("fim")) {
                break;
            }

            // Adiciona o nome ao Set.
            // O próprio Set (com o comparador) cuidará de:
            // 1. Ignorar o nome se um "igual" (ignorando case) já existir.
            // 2. Manter a ordem alfabética.
            // Nota: Se "Ana" for adicionado primeiro e depois "ana", o Set manterá "Ana".
            nomes.add(nomeInput);
        }

        System.out.println(); // Adiciona uma linha em branco para formatação

        // --- 3. Exibição dos Nomes Cadastrados ---

        System.out.println("Nomes cadastrados:");
        // O método toString() do Set já formata como [Nome1, Nome2, ...]
        System.out.println(nomes);

        System.out.println(); // Linha em branco

        // --- 4. Fase de Pesquisa ---

        System.out.println("Pesquisar nomes (digite 'sair' para encerrar):");

        while (true) {
            System.out.print("> ");
            String nomeBusca = scanner.nextLine();

            // Verifica a condição de parada
            if (nomeBusca.equalsIgnoreCase("sair")) {
                break;
            }

            // O método .contains() também usará o comparador case-insensitive
            // que definimos na criação do TreeSet.
            if (nomes.contains(nomeBusca)) {
                System.out.println("Nome encontrado.");
            } else {
                System.out.println("Nome não encontrado.");
            }
        }

        // --- 5. Encerramento ---

        System.out.println("\nPrograma encerrado.");
        // Fecha o scanner para liberar os recursos
        scanner.close();
    }
}