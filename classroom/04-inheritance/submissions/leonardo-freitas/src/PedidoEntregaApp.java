public class PedidoEntregaApp {
    public static void main(String[] argumentos) {
        PedidoEntrega primeiro = new PedidoEntrega(
                "PED-001", 299.90, "SQN 210 Bloco A", "Brasília", "70862-010");
        PedidoEntrega segundo = new PedidoEntrega(
                "PED-002", 159.50, "Rua das Flores, 100", "Goiânia", "74000-000");

        exibir(primeiro);
        exibir(segundo);
    }

    private static void exibir(PedidoEntrega pedido) {
        System.out.printf("%s | R$ %.2f | %s%n",
                pedido.obterNumero(),
                pedido.obterValorTotal(),
                pedido.obterEnderecoFormatado());
    }
}
