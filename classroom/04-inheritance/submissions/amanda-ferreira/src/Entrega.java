public class Entrega {
    private double distanciaEmKm;
    private double pesoEmKg;

    public Entrega(double distanciaEmKm, double pesoEmKg){
        if(distanciaEmKm < 0){
            this.distanciaEmKm = 0.0;
        } else{
            this.distanciaEmKm = distanciaEmKm;
        }

        if(pesoEmKg < 0){
            this.pesoEmKg = 0.0;
        } else{
            this.pesoEmKg = pesoEmKg;
        }
    }

    public double obterDistanciaEmKm(){
        return this.distanciaEmKm;
    }

    public double obterPesoEmKg(){
        return this.pesoEmKg;
    }

    public double calcularFrete(){
        return (0.50 * this.distanciaEmKm) + (1.0 * this.pesoEmKg);
    }

    public int calcularPrazoEmDias(){
        int dias = (int) Math.ceil(this.distanciaEmKm / 100.0);
        return Math.max(1, dias);
    }

    public String obterDescricao(){
        return this.distanciaEmKm + "KM " + this.pesoEmKg + "KG";
    }
}