import java.util.Arrays;

public class Agenda {
    private final Reserva[] reservas;
    private int quantidade;

    public Agenda(int capacidade) {
        reservas = new Reserva[capacidade];
    }

    public void adicionar(Reserva nova) {
        if (quantidade == reservas.length) {
            throw new IllegalStateException("Agenda cheia: capacidade de " + reservas.length + " reservas.");
        }
        for (int i = 0; i < quantidade; i++) {
            if (reservas[i].conflitaCom(nova)) {
                throw new IllegalStateException(nova.getBaba().getNome() + " já tem a reserva #" + reservas[i].getId() + " nesse horário.");
            }
        }
        reservas[quantidade++] = nova;
    }

    public Reserva buscar(int id) {
        for (Reserva r : todas()) {
            if (r.getId() == id) {
                return r;
            }
        }
        throw new IllegalArgumentException("Reserva #" + id + " não encontrada.");
    }

    public Reserva[] daBaba(Baba baba) {
        Reserva[] resultado = new Reserva[quantidade];
        int n = 0;
        for (Reserva r : todas()) {
            if (r.getBaba() == baba) {
                resultado[n++] = r;
            }
        }
        return Arrays.copyOf(resultado, n);
    }

    public double faturamentoTotal() {
        double total = 0;
        for (Reserva r : todas()) {
            total += r.isCancelada() ? r.getMulta() : r.calcularValor();
        }
        return total;
    }

    public Reserva[] todas() {
        return Arrays.copyOf(reservas, quantidade);
    }
}
