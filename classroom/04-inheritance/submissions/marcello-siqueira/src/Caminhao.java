public class Caminhao extends VeiculoFrota {

    private double capacidadeCargaEmKg;

    public Caminhao(String placa, String combustivel, double potencia, double capacidadeCargaEmKg) {
        super(placa, combustivel, potencia);
        this.capacidadeCargaEmKg = capacidadeCargaEmKg < 0 ? 0 : capacidadeCargaEmKg;
    }

    public double obterCapacidadeCargaEmKg() { return capacidadeCargaEmKg; }

    @Override
    public String obterDescricao() {
        return String.format("%s, carga de %.1f kg", super.obterDescricao(), capacidadeCargaEmKg);
    }
}
