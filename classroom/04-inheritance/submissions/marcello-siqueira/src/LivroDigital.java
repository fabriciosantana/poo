public class LivroDigital extends ConteudoDigital {

    private double taxaEditorial;

    public LivroDigital(String titulo, double precoBase, double taxaEditorial) {
        super(titulo, precoBase);
        this.taxaEditorial = taxaEditorial < 0 ? 0 : taxaEditorial;
    }

    @Override
    public double calcularPreco() {
        return obterPrecoBase() + taxaEditorial;
    }
}
