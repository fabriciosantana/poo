public class EntregasApp {
    private static void exibir(Entrega entrega){
        System.out.println("Descrição: " + entrega.obterDescricao());
        System.out.println("Frete: " + entrega.calcularFrete());
        System.out.println("Prazo: " + entrega.calcularPrazoEmDias() + " dias");
        System.out.println();
    }
    public static void main(String[] args){
        Entrega EntregaNormal = new Entrega(200.0, 50.0);
        exibir(EntregaNormal);

        EntregaExpressa EntregaExpress = new EntregaExpressa(200.0, 50.0);
        exibir(EntregaExpress);
    }
}