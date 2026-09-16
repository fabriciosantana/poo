public class Motor {

    private String combustivel;
    private double potencia;

    // visibilidade de pacote: so o VeiculoFrota, dono do motor, constroi a parte
    Motor(String combustivel, double potencia) {
        this.combustivel = (combustivel == null || combustivel.isBlank()) ? "Combustível não informado" : combustivel;
        this.potencia = potencia < 0 ? 0 : potencia;
    }

    public String obterDescricao() {
        return String.format("motor %s de %.1f cv", combustivel, potencia);
    }
}
