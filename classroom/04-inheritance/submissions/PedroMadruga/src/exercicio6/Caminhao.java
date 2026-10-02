public class Caminhao extends Veiculo { // Herança: "é um"
    private double capacidadeCargaToneladas;

    public Caminhao(String placa, String combustivel, int potenciaCv, double capacidadeCargaToneladas) {
        super(placa, combustivel, potenciaCv);
        this.capacidadeCargaToneladas = Math.max(0.0, capacidadeCargaToneladas);
    }

    @Override
    public String getDescricao() {
        return String.format("%s, Carga Máx: %.1f ton", super.getDescricao(), capacidadeCargaToneladas);
    }
}