import java.time.LocalDateTime;

public class ReservaDiurna extends Reserva {

    public ReservaDiurna(Familia familia, Baba baba, Crianca[] criancas, LocalDateTime inicio, LocalDateTime fim) {
        super(familia, baba, criancas, inicio, fim);
    }

    @Override
    public double calcularValor() {
        double fator = switch (getQuantidadeCriancas()) {
            case 1 -> 1.0;
            case 2 -> 1.2;
            default -> 1.4;
        };
        return getHoras() * getBaba().getValorHora() * fator;
    }

    @Override
    public String getTipo() {
        return "Diurna";
    }
}
