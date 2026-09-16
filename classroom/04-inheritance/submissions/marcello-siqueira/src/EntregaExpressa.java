public class EntregaExpressa extends Entrega {

    public EntregaExpressa(double distanciaEmKm, double pesoEmKg) {
        super(distanciaEmKm, pesoEmKg);
    }

    @Override
    public double calcularFrete() {
        return super.calcularFrete() + 20.00;
    }

    @Override
    public int calcularPrazoEmDias() {
        // (n + 1) / 2 e o teto da metade; como o prazo convencional nunca e menor que 1, o minimo ja esta garantido
        return (super.calcularPrazoEmDias() + 1) / 2;
    }

    @Override
    public String obterDescricao() {
        return "Entrega expressa";
    }
}
