public abstract class Acomodacao {
    private static int totalAcomodacoesCriadas = 0;

    private final int numero;
    private final double valorDiariaBase;
    private final int capacidadeMaxima;
    private boolean ocupada;

    public Acomodacao(int numero, double valorDiariaBase, int capacidadeMaxima) {
        if (numero <= 0) {
            throw new IllegalArgumentException("O número da acomodação deve ser positivo.");
        }
        if (valorDiariaBase <= 0.0) {
            throw new IllegalArgumentException("O valor da diária base deve ser maior que zero.");
        }
        if (capacidadeMaxima <= 0) {
            throw new IllegalArgumentException("A capacidade máxima deve ser de pelo menos 1 pessoa.");
        }

        this.numero = numero;
        this.valorDiariaBase = valorDiariaBase;
        this.capacidadeMaxima = capacidadeMaxima;
        this.ocupada = false;

        totalAcomodacoesCriadas++;
    }

    public static int getTotalAcomodacoesCriadas() {
        return totalAcomodacoesCriadas;
    }

    public abstract double calcularPrecoTotal(int noites);

    public void ocupar() {
        if (this.ocupada) {
            throw new IllegalStateException("Acomodação " + this.numero + " já se encontra ocupada.");
        }
        this.ocupada = true;
    }

    public void desocupar() {
        this.ocupada = false;
    }

    public int getNumero() {
        return numero;
    }

    public double getValorDiariaBase() {
        return valorDiariaBase;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    @Override
    public String toString() {
        String status = this.ocupada ? "OCUPADA" : "DISPONÍVEL"; // Operador ternário ?:
        return String.format("Acomodação Nº %d | Diária Base: R$ %.2f | Capacidade: %d pessoas | Status: %s",
                numero, valorDiariaBase, capacidadeMaxima, status);
    }
}
