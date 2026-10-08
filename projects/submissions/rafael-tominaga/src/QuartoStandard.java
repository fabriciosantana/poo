public class QuartoStandard extends Acomodacao {
    private final boolean frigobarIncluso;

    public QuartoStandard(int numero, double valorDiariaBase, int capacidadeMaxima, boolean frigobarIncluso) {
        super(numero, valorDiariaBase, capacidadeMaxima);
        this.frigobarIncluso = frigobarIncluso;
    }

    @Override
    public double calcularPrecoTotal(int noites) {
        if (noites <= 0) {
            throw new IllegalArgumentException("O número de noites deve ser estritamente maior que zero.");
        }
        
        double adicionalFrigobar = this.frigobarIncluso ? 15.0 : 0.0;
        return (getValorDiariaBase() + adicionalFrigobar) * noites;
    }

    public boolean isFrigobarIncluso() {
        return frigobarIncluso;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Tipo: Standard [Frigobar Incluso: %s]", frigobarIncluso ? "Sim" : "Não");
    }
}