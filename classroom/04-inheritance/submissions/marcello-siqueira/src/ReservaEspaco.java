public class ReservaEspaco implements Cobravel, Cancelavel {

    private int quantidadeHoras;
    private double valorPorHora;
    private boolean utilizada;
    private boolean cancelada;

    public ReservaEspaco(int quantidadeHoras, double valorPorHora) {
        this.quantidadeHoras = quantidadeHoras < 0 ? 0 : quantidadeHoras;
        this.valorPorHora = valorPorHora < 0 ? 0 : valorPorHora;
    }

    @Override
    public double calcularValorDevido() {
        return quantidadeHoras * valorPorHora;
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
        utilizada = true;
    }
}
