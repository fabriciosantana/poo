public class GestaoServicosApp {
    public static void main(String[] argumentos) {
        AssinaturaAcademia academia = new AssinaturaAcademia(129.90);
        ReservaEspaco reserva = new ReservaEspaco(4, 75.0);

        GestorServicos gestor = new GestorServicos();

        gestor.cobrar(academia);
        gestor.solicitarCancelamento(academia);
        gestor.solicitarCancelamento(academia);

        gestor.cobrar(reserva);
        reserva.registrarUtilizacao();
        gestor.solicitarCancelamento(reserva);
    }
}
