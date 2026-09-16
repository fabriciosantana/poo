import java.util.Scanner;

public class MaquinaVendasApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MaquinaVendas maquina = new MaquinaVendas("Refrigerante", 5.0, 2);

        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\n--- MÁQUINA DE VENDAS ---");
            System.out.println("Produto: " + maquina.getProduto());
            System.out.println("Preço: R$ " + maquina.getPreco());
            System.out.println("Estoque: " + maquina.getEstoque());
            System.out.println("Crédito: R$ " + maquina.getCredito());
            System.out.println("1 - Inserir dinheiro");
            System.out.println("2 - Comprar");
            System.out.println("3 - Cancelar");
            System.out.println("4 - Encerrar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.print("Digite o valor: R$ ");
                double valor = scanner.nextDouble();
                maquina.inserirDinheiro(valor);
            } else if (opcao == 2) {
                boolean sucesso = maquina.comprar();
                if (sucesso) {
                    System.out.println("Compra realizada com sucesso!");
                } else {
                    System.out.println("Falha na compra (sem saldo ou sem estoque).");
                }
            } else if (opcao == 3) {
                double troco = maquina.cancelar();
                System.out.println("Operação cancelada. Valor devolvido: R$ " + troco);
            } else if (opcao == 4) {
                double trocoFinal = maquina.cancelar();
                System.out.println("Programa encerrado. Troco devolvido: R$ " + trocoFinal);
            } else {
                System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}