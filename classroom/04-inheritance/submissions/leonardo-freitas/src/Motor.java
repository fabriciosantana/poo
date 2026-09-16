public class Motor {
    private String combustivel;
    private double potencia;

    Motor(String combustivel, double potencia) {
        this.combustivel = (combustivel == null || combustivel.isBlank())
                ? "Combustível não informado"
                : combustivel;
        this.potencia = (!Double.isFinite(potencia) || potencia < 0.0) ? 0.0 : potencia;
    }

    public String obterDescricao() {
        return String.format("Motor: %s, %.1f cv", combustivel, potencia);
    }
}
