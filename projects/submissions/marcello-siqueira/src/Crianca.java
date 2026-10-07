public class Crianca {
    public static final int IDADE_MAXIMA = 12;

    private final String nome;
    private final int idade;

    public Crianca(String nome, int idade) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome da criança é obrigatório.");
        }
        if (idade < 0 || idade > IDADE_MAXIMA) {
            throw new IllegalArgumentException("Idade de " + nome + " inválida: atendemos crianças de 0 a " + IDADE_MAXIMA + " anos.");
        }
        this.nome = nome;
        this.idade = idade;
    }
}
