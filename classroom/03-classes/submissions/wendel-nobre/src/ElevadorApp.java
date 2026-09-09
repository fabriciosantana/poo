public class ElevadorApp {
    public static void main(String[] args) {
        Elevador elevador = new Elevador(3, 5);

        System.out.println("--- Testando entrada de pessoas ---");
        boolean entrou1 = elevador.entrar(4);
        System.out.println("Entrar 4 pessoas: " + resultado(entrou1) + " (Pessoas: " + elevador.obterQuantidadePessoas() + ")");

        boolean entrou2 = elevador.entrar(3);
        System.out.println("Entrar 3 pessoas (excede capacidade): " + resultado(entrou2) + " (Pessoas: " + elevador.obterQuantidadePessoas() + ")");

        System.out.println("\n--- Subindo até o topo ---");
        for (int i = 0; i < 4; i++) {
            boolean subiu = elevador.subir();
            System.out.println("Tentando subir para o andar " + (elevador.obterAndarAtual() + 1) + ": " + resultado(subiu) + " (Andar atual: " + elevador.obterAndarAtual() + ")");
        }

        System.out.println("\n--- Testando saída de pessoas ---");
        boolean saiu1 = elevador.sair(2);
        System.out.println("Sair 2 pessoas: " + resultado(saiu1) + " (Pessoas: " + elevador.obterQuantidadePessoas() + ")");

        boolean saiu2 = elevador.sair(5);
        System.out.println("Sair 5 pessoas (excede ocupação): " + resultado(saiu2) + " (Pessoas: " + elevador.obterQuantidadePessoas() + ")");

        System.out.println("\n--- Descendo até o térreo ---");
        for (int i = 0; i < 4; i++) {
            boolean desceu = elevador.descer();
            System.out.println("Tentando descer: " + resultado(desceu) + " (Andar atual: " + elevador.obterAndarAtual() + ")");
        }
    }

    private static String resultado(boolean sucesso) {
        if (sucesso) {
            return "Sucesso";
        }
        return "Recusado";
    }
}