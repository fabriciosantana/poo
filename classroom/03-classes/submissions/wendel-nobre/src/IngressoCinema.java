public class IngressoCinema {
    private String filme;
    private double precoInteira;
    private boolean vendido;

    public IngressoCinema(String filme, double precoInteira) {
        if (filme == null || filme.isBlank()) {
            this.filme = "Filme não informado";
        } else {
            this.filme = filme;
        }

        if (precoInteira > 0.0) {
            this.precoInteira = precoInteira;
        } else {
            this.precoInteira = 1.0;
        }

        this.vendido = false;
    }

    public double venderInteira() {
        if (!this.vendido) {
            this.vendido = true;
            return this.precoInteira;
        }
        return 0.0;
    }

    public double venderMeia() {
        if (!this.vendido) {
            this.vendido = true;
            return this.precoInteira / 2.0;
        }
        return 0.0;
    }

    public String obterFilme() {
        return this.filme;
    }

    public double obterPrecoInteira() {
        return this.precoInteira;
    }

    public boolean estaVendido() {
        return this.vendido;
    }
}