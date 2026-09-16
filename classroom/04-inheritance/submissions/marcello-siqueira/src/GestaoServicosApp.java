public class GestaoServicosApp {

    public static void main(String[] argumentos) {
        GestorServicos gestor = new GestorServicos();

        AssinaturaAcademia academia = new AssinaturaAcademia(129.90);
        gestor.cobrar(academia);
        gestor.solicitarCancelamento(academia);
        gestor.solicitarCancelamento(academia);

        ReservaEspaco reserva = new ReservaEspaco(4, 60.00);
        gestor.cobrar(reserva);
        gestor.solicitarCancelamento(reserva);

        ReservaEspaco utilizada = new ReservaEspaco(2, 60.00);
        utilizada.registrarUtilizacao();
        gestor.solicitarCancelamento(utilizada);

        gestor.cobrar(new ReservaEspaco(-3, -10.00));
    }
}
