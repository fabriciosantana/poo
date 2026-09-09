public class ExpositorRefrigerado {
    private static final double ZERO_ABSOLUTO = -273.15;
    private static final double TEMPERATURA_MINIMA_SEGURA = 2.0;
    private static final double TEMPERATURA_MAXIMA_SEGURA = 8.0;

    private double temperatura;

    public ExpositorRefrigerado() {
        this(4.0);
    }

    public ExpositorRefrigerado(double temperatura) {
        if (temperatura < ZERO_ABSOLUTO) {
            this.temperatura = 4.0;
        } else {
            this.temperatura = temperatura;
        }
    }

    public void definirTemperatura(double temperatura) {
        if (temperatura >= ZERO_ABSOLUTO) {
            this.temperatura = temperatura;
        }
    }

    public double obterTemperatura() {
        return this.temperatura;
    }

    public boolean estaNaFaixaSegura() {
        return this.temperatura >= TEMPERATURA_MINIMA_SEGURA && this.temperatura <= TEMPERATURA_MAXIMA_SEGURA;
    }
}