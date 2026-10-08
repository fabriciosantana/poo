public class SuitePresidencial extends Acomodacao {
    private final boolean servicoMordomo;

    public SuitePresidencial(int numero, double valorDiariaBase, int capacidadeMaxima, boolean servicoMordomo) {
        super(numero, valorDiariaBase, capacidadeMaxima);
        this.servicoMordomo = servicoMordomo;
    }

    @Override
    public double calcularPrecoTotal(int noites) {
        if (noites <= 0) {
            throw new IllegalArgumentException("O número de noites deve ser estritamente maior que zero.");
        }
        double multiplicador = this.servicoMordomo ? 1.20 : 1.0;
        return (getValorDiariaBase() * multiplicador) * noites;
    }

    public boolean isServicoMordomo() {
        return servicoMordomo;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Tipo: Suíte Presidencial [Mordomo 24h: %s]", servicoMordomo ? "Sim" : "Não");
    }
}