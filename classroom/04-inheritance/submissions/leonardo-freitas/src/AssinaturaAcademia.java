public class AssinaturaAcademia implements Cobravel, Cancelavel {
    private double mensalidade;
    private boolean ativa;

    public AssinaturaAcademia(double mensalidade) {
        this.mensalidade = Math.max(0.0, mensalidade);
        this.ativa = true;
    }

    @Override
    public double calcularValorDevido() {
        return ativa ? mensalidade : 0.0;
    }

    @Override
    public boolean cancelar() {
        if (!ativa) {
            return false;
        }
        ativa = false;
        return true;
    }
}
