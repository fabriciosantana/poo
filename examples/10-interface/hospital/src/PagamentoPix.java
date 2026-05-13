public class PagamentoPix extends Pagamento {
        
    public PagamentoPix() {
        this.taxa = 0.01D;
    }

    public PagamentoPix(double percentualPagamento){
        this();
        this.percentualPagamento = percentualPagamento;
    }

    @Override
    public String toString(){
        return "\n - Pix" + super.toString();
    }
}