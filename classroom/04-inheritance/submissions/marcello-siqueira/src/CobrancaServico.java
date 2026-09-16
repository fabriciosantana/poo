public class CobrancaServico extends Cobranca {

    public CobrancaServico(String descricao, double valorBase) {
        super(descricao, valorBase);
    }

    @Override
    public double calcularTotal() {
        return obterValorBase() * 1.05;
    }
}
