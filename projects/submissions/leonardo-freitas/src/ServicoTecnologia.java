public class ServicoTecnologia extends Servico {
    private final int horasEstimadas;
    private final String complexidade;

    public ServicoTecnologia(String descricao, double valorBase, int horasEstimadas, String complexidade) {
        super(descricao, valorBase);
        if (horasEstimadas <= 0) {
            throw new IllegalArgumentException("As horas estimadas devem ser positivas.");
        }
        this.horasEstimadas = horasEstimadas;
        this.complexidade = normalizarComplexidade(complexidade);
    }

    private String normalizarComplexidade(String complexidade) {
        if (complexidade == null) {
            throw new IllegalArgumentException("A complexidade é obrigatória.");
        }
        String valor = complexidade.trim().toUpperCase();
        return switch (valor) {
            case "BASICA", "MEDIA", "ALTA" -> valor;
            default -> throw new IllegalArgumentException("Complexidade deve ser BASICA, MEDIA ou ALTA.");
        };
    }

    @Override
    public double calcularValorFinal() {
        double fator = switch (complexidade) {
            case "BASICA" -> 1.00;
            case "MEDIA" -> 1.25;
            case "ALTA" -> 1.50;
            default -> 1.00;
        };
        return (getValorBase() + horasEstimadas * 80.0) * fator;
    }

    @Override
    public String getTipo() {
        return "Tecnologia";
    }

    public int getHorasEstimadas() { return horasEstimadas; }
    public String getComplexidade() { return complexidade; }
}
