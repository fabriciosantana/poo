public class ReservaSala {
    private final String sala;
    private final int horarioInicial;
    private final int horarioFinal;

    public ReservaSala(String sala, int horarioInicial, int horarioFinal) throws ReservaInvalidaException {
        if (sala == null || sala.isBlank()) {
            throw new ReservaInvalidaException("Sala não informada.");
        }
        if (horarioInicial < 0 || horarioFinal < 0) {
            throw new ReservaInvalidaException("Horário não pode ser negativo.");
        }
        if (horarioFinal <= horarioInicial) {
            throw new ReservaInvalidaException("Horário final deve ser maior que o inicial.");
        }

        this.sala = sala.trim();
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
    }

    public static ReservaSala reservar(String sala, int horarioInicial, int horarioFinal,
                                       ReservaSala reservaExistente) throws ReservaInvalidaException {
        ReservaSala nova = new ReservaSala(sala, horarioInicial, horarioFinal);
        if (reservaExistente != null && nova.conflitaCom(reservaExistente)) {
            throw new ReservaInvalidaException("Sala já ocupada nesse horário.");
        }
        return nova;
    }

    private boolean conflitaCom(ReservaSala outra) {
        return sala.equalsIgnoreCase(outra.sala)
                && horarioInicial < outra.horarioFinal
                && horarioFinal > outra.horarioInicial;
    }

    public String getSala() {
        return sala;
    }

    public int getHorarioInicial() {
        return horarioInicial;
    }

    public int getHorarioFinal() {
        return horarioFinal;
    }

    @Override
    public String toString() {
        return String.format("Sala %s - %d às %d", sala, horarioInicial, horarioFinal);
    }
}
