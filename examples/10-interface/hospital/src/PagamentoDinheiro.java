public class PagamentoDinheiro extends Pagamento {
            
    public PagamentoDinheiro(){
        this.taxa = 0.0D;
    }

    public PagamentoDinheiro(double percentualPagamento){
        this.percentualPagamento = percentualPagamento;
    }
   
    @Override
    public String toString(){
        return "\n - Dinheiro" + super.toString();
    }

}
