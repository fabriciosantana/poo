public abstract class Servico {
    private static int proximoId = 1;

    private final int id;
    private final String descricao;
    private final double valorBase;
    private boolean concluido;

    protected Servico(String descricao, double valorBase) {
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("A descrição do serviço é obrigatória.");
        }
        if (valorBase <= 0) {
            throw new IllegalArgumentException("O valor base deve ser positivo.");
        }
        this.id = proximoId++;
        this.descricao = descricao;
        this.valorBase = valorBase;
        this.concluido = false;
    }

    public abstract double calcularValorFinal();
    public abstract String getTipo();

    public void concluir() {
        concluido = true;
    }

    public int getId() { return id; }
    public String getDescricao() { return descricao; }
    public double getValorBase() { return valorBase; }
    public boolean isConcluido() { return concluido; }

    @Override
    public String toString() {
        return String.format("#%d %s - %s | R$ %.2f | %s",
                id, getTipo(), descricao, calcularValorFinal(), concluido ? "concluído" : "pendente");
    }
}
