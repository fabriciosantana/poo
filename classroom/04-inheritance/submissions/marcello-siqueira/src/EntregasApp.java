public class EntregasApp {

    public static void main(String[] argumentos) {
        exibir(new Entrega(250.0, 8.0));
        exibir(new EntregaExpressa(250.0, 8.0));

        exibir(new Entrega(-50.0, -3.0));

        exibir(new Entrega(100.0, 0.0));
        exibir(new EntregaExpressa(100.0, 0.0));
    }

    private static void exibir(Entrega entrega) {
        System.out.printf("%s: %.1f km, %.1f kg, frete R$ %.2f, prazo %d dia(s)%n",
                entrega.obterDescricao(), entrega.obterDistanciaEmKm(), entrega.obterPesoEmKg(),
                entrega.calcularFrete(), entrega.calcularPrazoEmDias());
    }
}
