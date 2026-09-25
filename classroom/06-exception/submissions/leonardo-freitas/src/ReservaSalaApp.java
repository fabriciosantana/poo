public class ReservaSalaApp {
    public static void main(String[] args) {
        ReservaSala reservaConfirmada = null;

        try {
            reservaConfirmada = ReservaSala.reservar("A101", 9, 11, null);
            System.out.println("RESERVA CONFIRMADA");
        } catch (ReservaInvalidaException e) {
            System.out.println("RESERVA RECUSADA: " + e.getMessage());
        }

        try {
            ReservaSala.reservar("B202", 14, 13, reservaConfirmada);
        } catch (ReservaInvalidaException e) {
            System.out.println("RESERVA RECUSADA: " + e.getMessage());
        }

        try {
            ReservaSala.reservar("A101", 10, 12, reservaConfirmada);
        } catch (ReservaInvalidaException e) {
            System.out.println("RESERVA RECUSADA: " + e.getMessage());
        }

        if (reservaConfirmada != null) {
            System.out.println("Reserva mantida: " + reservaConfirmada);
        }
    }
}
