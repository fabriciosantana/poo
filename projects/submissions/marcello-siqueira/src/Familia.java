public class Familia {
    private final String nome;

    public Familia(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome da família é obrigatório.");
        }
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
