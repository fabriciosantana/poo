public class OrcamentoPiso {
    private double comprimento;
    private double largura;
    private double precoPorMetroQuadrado;

    public OrcamentoPiso(double comprimento, double largura, double precoPorMetroQuadrado) {
        if (comprimento > 0.0) {
            this.comprimento = comprimento;
        } else {
            this.comprimento = 1.0;
        }

        if (largura > 0.0) {
            this.largura = largura;
        } else {
            this.largura = 1.0;
        }

        if (precoPorMetroQuadrado >= 0.0) {
            this.precoPorMetroQuadrado = precoPorMetroQuadrado;
        } else {
            this.precoPorMetroQuadrado = 0.0;
        }
    }

    public double obterComprimento() {
        return this.comprimento;
    }

    public double obterLargura() {
        return this.largura;
    }

    public double obterPrecoPorMetroQuadrado() {
        return this.precoPorMetroQuadrado;
    }

    public double calcularArea() {
        return this.comprimento * this.largura;
    }

    public double calcularComprimentoRodaPe() {
        return 2.0 * (this.comprimento + this.largura);
    }

    public double calcularPrecoTotal() {
        return this.calcularArea() * this.precoPorMetroQuadrado;
    }
}