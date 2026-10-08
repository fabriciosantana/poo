public class Hospede {
    private final String nome;
    private final String documento;

    public Hospede(String nome, String documento) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do hóspede não pode ser vazio.");
        }
        if (documento == null || documento.trim().length() < 5) {
            throw new IllegalArgumentException("Documento do hóspede inválido.");
        }
        this.nome = nome.trim();
        this.documento = documento.trim();
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    @Override
    public String toString() {
        return String.format("Hóspede: %s (Doc: %s)", nome, documento);
    }
}
