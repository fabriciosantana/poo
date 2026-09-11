public class Caminhao extends VeiculoFrota {
    private double capacidadeCargaEmKg;

    public Caminhao(String placa, String combustivel, double potencia,
                    double capacidadeCargaEmKg) {
        super(placa, combustivel, potencia);
        this.capacidadeCargaEmKg = Math.max(0.0, capacidadeCargaEmKg);
    }

    public double obterCapacidadeCargaEmKg() {
        return capacidadeCargaEmKg;
    }

    @Override
    public String obterDescricao() {
        return super.obterDescricao()
                + String.format(" | Capacidade: %.1f kg", capacidadeCargaEmKg);
    }
}
