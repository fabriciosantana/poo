public class Hospedagem {
    public static final double TAXA_HIGIENIZACAO_MINIMA = 80.0;

    private final Hospede hospede;
    private final Acomodacao acomodacao;
    private final int quantidadeHospedes;
    private final int noitesContratadas;
    private boolean checkOutRealizado;

    public Hospedagem(Hospede hospede, Acomodacao acomodacao, int quantidadeHospedes, int noitesContratadas) {
        if (hospede == null) {
            throw new IllegalArgumentException("Hóspede titular não pode ser nulo.");
        }
        if (acomodacao == null) {
            throw new IllegalArgumentException("Acomodação vinculada não pode ser nula.");
        }
        if (noitesContratadas <= 0) {
            throw new IllegalArgumentException("O número de noites contratadas deve ser superior a zero.");
        }
        if (quantidadeHospedes <= 0 || quantidadeHospedes > acomodacao.getCapacidadeMaxima()) {
            throw new IllegalArgumentException(String.format(
                    "Capacidade excedida: A acomodação %d comporta até %d pessoas (informado: %d).",
                    acomodacao.getNumero(), acomodacao.getCapacidadeMaxima(), quantidadeHospedes));
        }

        acomodacao.ocupar();

        this.hospede = hospede;
        this.acomodacao = acomodacao;
        this.quantidadeHospedes = quantidadeHospedes;
        this.noitesContratadas = noitesContratadas;
        this.checkOutRealizado = false;
    }

    public double fecharHospedagem(int noitesEfetivas) {
        if (checkOutRealizado) {
            throw new IllegalStateException("O check-out desta hospedagem já foi concluído anteriormente.");
        }
        if (noitesEfetivas < 0) {
            throw new IllegalArgumentException("Noites efetivas não podem ser negativas.");
        }

        double total;

        if (noitesEfetivas == 0) {
            total = TAXA_HIGIENIZACAO_MINIMA;
        } else {
            total = acomodacao.calcularPrecoTotal(noitesEfetivas);
        }

        acomodacao.desocupar();
        this.checkOutRealizado = true;
        return total;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public Acomodacao getAcomodacao() {
        return acomodacao;
    }

    public int getQuantidadeHospedes() {
        return quantidadeHospedes;
    }

    public int getNoitesContratadas() {
        return noitesContratadas;
    }

    public boolean isCheckOutRealizado() {
        return checkOutRealizado;
    }

    @Override
    public String toString() {
        return String.format("Reserva [%s] | %s | Noites Previstas: %d | Finalizada: %s",
                hospede.getNome(), acomodacao.toString(), noitesContratadas, checkOutRealizado ? "Sim" : "Não");
    }
}
