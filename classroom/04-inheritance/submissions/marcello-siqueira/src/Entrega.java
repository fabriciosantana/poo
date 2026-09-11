public class Entrega {

    private double distanciaEmKm;
    private double pesoEmKg;

    public Entrega(double distanciaEmKm, double pesoEmKg) {
        this.distanciaEmKm = distanciaEmKm < 0 ? 0 : distanciaEmKm;
        this.pesoEmKg = pesoEmKg < 0 ? 0 : pesoEmKg;
    }

    public double obterDistanciaEmKm() { return distanciaEmKm; }

    public double obterPesoEmKg() { return pesoEmKg; }

    public double calcularFrete() {
        return distanciaEmKm * 0.50 + pesoEmKg * 1.00;
    }

    public int calcularPrazoEmDias() {
        int dias = (int) Math.ceil(distanciaEmKm / 100.0);
        return dias < 1 ? 1 : dias;
    }

    public String obterDescricao() {
        return "Entrega convencional";
    }
}
