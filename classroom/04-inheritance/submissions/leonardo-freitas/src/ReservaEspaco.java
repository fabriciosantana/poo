public class ReservaEspaco implements Cobravel, Cancelavel {
    private int quantidadeHoras;
    private double valorPorHora;
    private boolean utilizada;
    private boolean cancelada;

    public ReservaEspaco(int quantidadeHoras, double valorPorHora) {
        this.quantidadeHoras = Math.max(0, quantidadeHoras);
        this.valorPorHora = Math.max(0.0, valorPorHora);
        this.utilizada = false;
        this.cancelada = false;
    }

    @Override
    public double calcularValorDevido() {
        return cancelada ? 0.0 : quantidadeHoras * valorPorHora;
    }

    @Override
    public boolean cancelar() {
        if (utilizada || cancelada) {
            return false;
        }
        cancelada = true;
        return true;
    }

    public void registrarUtilizacao() {
        if (!cancelada) {
            utilizada = true;
        }
    }
}
