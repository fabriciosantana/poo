public class Baba {
    private final String nome;
    private final double valorHora;
    private final boolean habilitadaPernoite;

    public Baba(String nome, double valorHora, boolean habilitadaPernoite) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome da babá é obrigatório.");
        }
        if (valorHora <= 0) {
            throw new IllegalArgumentException("Valor da hora deve ser maior que zero.");
        }
        this.nome = nome;
        this.valorHora = valorHora;
        this.habilitadaPernoite = habilitadaPernoite;
    }

    public String getNome() {
        return nome;
    }

    public double getValorHora() {
        return valorHora;
    }

    public boolean isHabilitadaPernoite() {
        return habilitadaPernoite;
    }

    @Override
    public String toString() {
        return String.format("%s (R$ %.2f/h%s)", nome, valorHora, habilitadaPernoite ? ", faz pernoite" : "");
    }
}
