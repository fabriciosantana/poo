public class Cliente {
    private final String nome;
    private final double limiteOrcamento;

    public Cliente(String nome, double limiteOrcamento) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do cliente é obrigatório.");
        }
        if (limiteOrcamento <= 0) {
            throw new IllegalArgumentException("O limite de orçamento deve ser positivo.");
        }
        this.nome = nome;
        this.limiteOrcamento = limiteOrcamento;
    }

    public String getNome() { return nome; }
    public double getLimiteOrcamento() { return limiteOrcamento; }

    @Override
    public String toString() {
        return String.format("Cliente: %s | limite: R$ %.2f", nome, limiteOrcamento);
    }
}
