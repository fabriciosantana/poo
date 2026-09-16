public abstract class ConteudoDigital {

    private String titulo;
    private double precoBase;

    public ConteudoDigital(String titulo, double precoBase) {
        this.titulo = titulo;
        this.precoBase = precoBase < 0 ? 0 : precoBase;
    }

    public String obterTitulo() { return titulo; }

    public double obterPrecoBase() { return precoBase; }

    public abstract double calcularPreco();
}
