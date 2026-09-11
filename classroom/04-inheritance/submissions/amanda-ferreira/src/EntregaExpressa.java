public class EntregaExpressa extends Entrega{
    public EntregaExpressa(double distanciaEmKm, double pesoEmKg){
        super(distanciaEmKm, pesoEmKg);
    }

    @Override
    public double calcularFrete(){
        return super.calcularFrete() + 20.0;
    }

    @Override
    public int calcularPrazoEmDias(){
        return Math.max(1, (int) Math.ceil(super.calcularPrazoEmDias() / 2));
    }

    @Override 
    public String obterDescricao(){
        return "Entrega Expressa: " + super.obterDescricao();
    }
}