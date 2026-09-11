public abstract class ConteudoDigital {
    private String titulo;
    private double precoBase;

    public ConteudoDigital(String titulo, double precoBase) {
        this.titulo = (titulo == null || titulo.isBlank())
                ? "Conteúdo sem título"
                : titulo;
        this.precoBase = Math.max(0.0, precoBase);
    }

    public String obterTitulo() {
        return titulo;
    }

    public double obterPrecoBase() {
        return precoBase;
    }

    public abstract double calcularPreco();
}
