import java.util.Arrays;

public class Projeto {
    public static final int CAPACIDADE_MAXIMA = 5;

    private final String nome;
    private final Cliente cliente;
    private final Servico[] servicos;
    private int quantidadeServicos;
    private String status;

    public Projeto(String nome, Cliente cliente) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do projeto é obrigatório.");
        }
        if (cliente == null) {
            throw new IllegalArgumentException("O projeto precisa de um cliente.");
        }
        this.nome = nome;
        this.cliente = cliente;
        this.servicos = new Servico[CAPACIDADE_MAXIMA];
        this.quantidadeServicos = 0;
        this.status = "PLANEJAMENTO";
    }

    public boolean adicionarServico(Servico servico) {
        if (servico == null || quantidadeServicos >= CAPACIDADE_MAXIMA || "CONCLUIDO".equals(status)) {
            return false;
        }
        if (calcularTotal() + servico.calcularValorFinal() > cliente.getLimiteOrcamento()) {
            return false;
        }
        servicos[quantidadeServicos++] = servico;
        status = "EM_EXECUCAO";
        return true;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Servico servico : servicos) {
            if (servico != null) {
                total += servico.calcularValorFinal();
            }
        }
        return total;
    }

    public Servico buscarServicoPorId(int id) {
        int i = 0;
        while (i < quantidadeServicos) {
            if (servicos[i].getId() == id) {
                return servicos[i];
            }
            i++;
        }
        return null;
    }

    public boolean concluirServico(int id) {
        Servico servico = buscarServicoPorId(id);
        if (servico == null) return false;
        servico.concluir();
        return true;
    }

    public boolean concluirProjeto() {
        if (quantidadeServicos == 0) return false;
        for (int i = 0; i < quantidadeServicos; i++) {
            if (!servicos[i].isConcluido()) return false;
        }
        status = "CONCLUIDO";
        return true;
    }

    public Servico[] listarServicos() {
        return Arrays.copyOf(servicos, quantidadeServicos);
    }

    public int getQuantidadeServicos() { return quantidadeServicos; }
    public String getStatus() { return status; }
    public String getNome() { return nome; }
    public Cliente getCliente() { return cliente; }

    @Override
    public String toString() {
        return String.format("Projeto: %s | %s | serviços: %d/%d | total: R$ %.2f",
                nome, status, quantidadeServicos, CAPACIDADE_MAXIMA, calcularTotal());
    }
}
