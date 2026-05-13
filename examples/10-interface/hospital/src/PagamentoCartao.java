public class PagamentoCartao extends Pagamento {

    public PagamentoCartao(){
        this.taxa = 0.03D;
    }

    public PagamentoCartao(double percentualPagamento){
        this();
        this.percentualPagamento = percentualPagamento;
    }

    @Override
    public String toString(){
        return "\n - Cartão: " + super.toString();
    }
}