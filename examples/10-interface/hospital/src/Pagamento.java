public abstract class Pagamento implements MeioPagamento {
 
    protected double taxa;
    protected double valor;
    protected double percentualPagamento = 100.0D;

    @Override
    public double pagar(double valor){
        this.valor = valor*(1.0+this.taxa)*this.percentualPagamento/100.0D;
        return this.valor;
    }

    @Override
    public String toString(){
        return "R$ " + this.valor + " ( Taxa: " + this.taxa + " | Percentual do Total: " + this.percentualPagamento + "% )";
    }
  
}
