public class ClienteFidelidade {
    private String nome;
    private int pontos;
    private boolean ativo;

    public ClienteFidelidade(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            this.nome = "Cliente não identificado";
        } else {
            this.nome = nome;
        }
        this.pontos = 0;
        this.ativo = true;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void acumularPontos(int quantidade) {
        if (ativo && quantidade > 0) {
            pontos = pontos + quantidade;
        }
    }

    public boolean resgatarPontos(int quantidade) {
        if (ativo && quantidade > 0 && pontos >= quantidade) {
            pontos = pontos - quantidade;
            return true;
        }
        return false;
    }

    public void desativar() {
        ativo = false;
    }
}