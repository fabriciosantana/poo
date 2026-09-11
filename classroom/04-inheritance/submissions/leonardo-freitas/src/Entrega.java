public class Entrega {
    private double distanciaEmKm;
    private double pesoEmKg;

    public Entrega(double distanciaEmKm, double pesoEmKg) {
        this.distanciaEmKm = Math.max(0.0, distanciaEmKm);
        this.pesoEmKg = Math.max(0.0, pesoEmKg);
    }

    public double obterDistanciaEmKm() {
        return distanciaEmKm;
    }

    public double obterPesoEmKg() {
        return pesoEmKg;
    }

    public double calcularFrete() {
        return distanciaEmKm * 0.50 + pesoEmKg * 1.00;
    }

    public int calcularPrazoEmDias() {
        return Math.max(1, (int) Math.ceil(distanciaEmKm / 100.0));
    }

    public String obterDescricao() {
        return "Entrega convencional";
    }
}
