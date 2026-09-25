public class ReservaSala {

    // registra a sala ja reservada; sem coleção, um membro de classe basta para o exercício
    private static String salaOcupada = "";

    private String sala;
    private int horarioInicial;
    private int horarioFinal;

    // o construtor valida antes de atribuir, entao um objeto so existe em estado valido
    public ReservaSala(String sala, int horarioInicial, int horarioFinal) throws ReservaInvalidaException {
        if (sala == null || sala.isBlank()) {
            throw new ReservaInvalidaException("sala não informada");
        }

        if (horarioInicial < 0 || horarioFinal < 0) {
            throw new ReservaInvalidaException("horário não pode ser negativo");
        }

        if (horarioFinal <= horarioInicial) {
            throw new ReservaInvalidaException("horário final precisa ser maior que o inicial");
        }

        if (sala.equals(salaOcupada)) {
            throw new ReservaInvalidaException("a sala " + sala + " já está ocupada");
        }

        this.sala = sala;
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
        salaOcupada = sala;
    }

    public String obterDescricao() {
        return "Sala " + sala + ", das " + horarioInicial + "h às " + horarioFinal + "h";
    }
}
