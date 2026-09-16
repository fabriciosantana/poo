public class CursoOnline extends ConteudoDigital {
    private double duracaoEmHoras;
    private double valorPorHora;

    public CursoOnline(String titulo, double precoBase,
                       double duracaoEmHoras, double valorPorHora) {
        super(titulo, precoBase);
        this.duracaoEmHoras = (!Double.isFinite(duracaoEmHoras) || duracaoEmHoras < 0.0) ? 0.0 : duracaoEmHoras;
        this.valorPorHora = (!Double.isFinite(valorPorHora) || valorPorHora < 0.0) ? 0.0 : valorPorHora;
    }

    @Override
    public double calcularPreco() {
        return obterPrecoBase() + duracaoEmHoras * valorPorHora;
    }
}
