public class VeiculoFrota {

    private String placa;
    private Motor motor;

    public VeiculoFrota(String placa, String combustivel, double potencia) {
        this.placa = (placa == null || placa.isBlank()) ? "Placa não informada" : placa;
        this.motor = new Motor(combustivel, potencia);
    }

    public String obterPlaca() { return placa; }

    public String obterDescricao() {
        return "Veículo " + placa + ", " + motor.obterDescricao();
    }
}
