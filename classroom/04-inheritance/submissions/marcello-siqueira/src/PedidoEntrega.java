public class PedidoEntrega {

    private String numero;
    private double valorTotal;
    private EnderecoEntrega endereco;

    public PedidoEntrega(String numero, double valorTotal, String logradouro, String cidade, String cep) {
        this.numero = (numero == null || numero.isBlank()) ? "Pedido sem número" : numero;
        this.valorTotal = valorTotal < 0 ? 0 : valorTotal;
        this.endereco = new EnderecoEntrega(logradouro, cidade, cep);
    }

    public String obterNumero() { return numero; }

    public double obterValorTotal() { return valorTotal; }

    public String obterEnderecoFormatado() { return endereco.formatar(); }
}
