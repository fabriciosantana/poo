import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Reserva {
    public static final int MAX_CRIANCAS = 3;
    public static final int MIN_HORAS = 3;
    public static final int MAX_HORAS = 12;
    public static final int ANTECEDENCIA_CANCELAMENTO_HORAS = 24;
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM HH:mm");

    private static int totalCriadas = 0;

    private final int id;
    private final Familia familia;
    private final Baba baba;
    private final Crianca[] criancas;
    private final LocalDateTime inicio;
    private final LocalDateTime fim;
    private boolean cancelada;
    private double multa;

    protected Reserva(Familia familia, Baba baba, Crianca[] criancas, LocalDateTime inicio, LocalDateTime fim) {
        if (familia == null || baba == null) {
            throw new IllegalArgumentException("A reserva precisa de uma família e de uma babá.");
        }
        if (criancas == null || criancas.length == 0 || criancas.length > MAX_CRIANCAS) {
            throw new IllegalArgumentException("A reserva deve ter de 1 a " + MAX_CRIANCAS + " crianças.");
        }
        if (inicio == null || fim == null || !fim.isAfter(inicio)) {
            throw new IllegalArgumentException("O fim da reserva deve ser depois do início.");
        }
        long minutos = Duration.between(inicio, fim).toMinutes();
        if (minutos < MIN_HORAS * 60 || minutos > MAX_HORAS * 60) {
            throw new IllegalArgumentException("A reserva deve durar entre " + MIN_HORAS + " e " + MAX_HORAS + " horas.");
        }
        this.familia = familia;
        this.baba = baba;
        this.criancas = criancas.clone();
        this.inicio = inicio;
        this.fim = fim;
        this.id = ++totalCriadas;
    }

    public abstract double calcularValor();

    public abstract String getTipo();

    public boolean conflitaCom(Reserva outra) {
        return !cancelada && !outra.cancelada
                && baba == outra.baba
                && inicio.isBefore(outra.fim)
                && outra.inicio.isBefore(fim);
    }

    public double cancelar(LocalDateTime agora) {
        if (cancelada) {
            throw new IllegalStateException("A reserva #" + id + " já está cancelada.");
        }
        if (!agora.isBefore(inicio)) {
            throw new IllegalStateException("A reserva #" + id + " já começou e não pode ser cancelada.");
        }
        long horasAntes = Duration.between(agora, inicio).toHours();
        multa = horasAntes < ANTECEDENCIA_CANCELAMENTO_HORAS ? calcularValor() * 0.5 : 0;
        cancelada = true;
        return multa;
    }

    public double getHoras() {
        return Duration.between(inicio, fim).toMinutes() / 60.0;
    }

    public int getQuantidadeCriancas() {
        return criancas.length;
    }

    public int getId() {
        return id;
    }

    public Baba getBaba() {
        return baba;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public double getMulta() {
        return multa;
    }

    public static int getTotalCriadas() {
        return totalCriadas;
    }

    @Override
    public String toString() {
        String situacao = cancelada ? String.format("CANCELADA, multa R$ %.2f", multa) : String.format("R$ %.2f", calcularValor());
        return String.format("#%d %-8s | %s | %s | %s a %s (%.1fh) | %d criança(s) | %s",
                id, getTipo(), familia.getNome(), baba.getNome(),
                inicio.format(FORMATO), fim.format(FORMATO), getHoras(), criancas.length, situacao);
    }
}
