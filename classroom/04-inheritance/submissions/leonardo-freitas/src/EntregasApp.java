public class EntregasApp {
    public static void main(String[] argumentos) {
        Entrega convencional = new Entrega(350.0, 12.0);
        Entrega expressa = new EntregaExpressa(350.0, 12.0);

        exibir(convencional);
        exibir(expressa);
    }

    private static void exibir(Entrega entrega) {
        System.out.printf("%s | Frete: R$ %.2f | Prazo: %d dia(s)%n",
                entrega.obterDescricao(),
                entrega.calcularFrete(),
                entrega.calcularPrazoEmDias());
    }
}
