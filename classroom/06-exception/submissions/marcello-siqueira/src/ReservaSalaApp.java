public class ReservaSalaApp {

    public static void main(String[] argumentos) {
        ReservaSala confirmada = null;

        try {
            confirmada = new ReservaSala("Lab 01", 14, 16);
            System.out.println("Reserva confirmada.");
        } catch (ReservaInvalidaException erro) {
            System.out.println("Reserva recusada: " + erro.getMessage());
        }

        try {
            new ReservaSala("Lab 02", 18, 18);
            System.out.println("Reserva confirmada.");
        } catch (ReservaInvalidaException erro) {
            System.out.println("Reserva recusada: " + erro.getMessage());
        }

        try {
            new ReservaSala("Lab 01", 9, 11);
            System.out.println("Reserva confirmada.");
        } catch (ReservaInvalidaException erro) {
            System.out.println("Reserva recusada: " + erro.getMessage());
        }

        // a variavel confirmada nunca e reatribuida nas tentativas recusadas,
        // porque a excecao interrompe o new antes da atribuicao
        if (confirmada == null) {
            System.out.println("Nenhuma reserva confirmada.");
        } else {
            System.out.println("Reserva mantida: " + confirmada.obterDescricao());
        }
    }
}
