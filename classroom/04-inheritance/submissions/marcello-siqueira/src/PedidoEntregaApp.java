public class PedidoEntregaApp {

    public static void main(String[] argumentos) {
        PedidoEntrega primeiro = new PedidoEntrega("PED-1001", 349.90,
                "SGAN 601", "Brasília", "70830-020");
        System.out.printf("%s, R$ %.2f, %s%n",
                primeiro.obterNumero(), primeiro.obterValorTotal(), primeiro.obterEnderecoFormatado());

        PedidoEntrega segundo = new PedidoEntrega("", -50.0, "  ", null, "74000-000");
        System.out.printf("%s, R$ %.2f, %s%n",
                segundo.obterNumero(), segundo.obterValorTotal(), segundo.obterEnderecoFormatado());
    }
}
