import java.time.LocalDateTime;

public class ReservaNoturna extends Reserva {
    private static final double ADICIONAL_NOTURNO = 0.25;

    public ReservaNoturna(Familia familia, Baba baba, Crianca[] criancas, LocalDateTime inicio, LocalDateTime fim) {
        super(familia, exigirPernoite(baba), criancas, inicio, fim);
    }

    private static Baba exigirPernoite(Baba baba) {
        if (baba != null && !baba.isHabilitadaPernoite()) {
            throw new IllegalArgumentException(baba.getNome() + " não é habilitada para reservas noturnas.");
        }
        return baba;
    }

    @Override
    public double calcularValor() {
        return getHoras() * getBaba().getValorHora() * (1 + ADICIONAL_NOTURNO);
    }

    @Override
    public String getTipo() {
        return "Noturna";
    }
}
