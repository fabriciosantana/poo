public class GestaoServicosApp {
    public static void main(String[] args) {
        GestorServicos gestor = new GestorServicos();

        AssinaturaAcademia academia = new AssinaturaAcademia(120.0);
        ReservaEspaco salaReuniao = new ReservaEspaco(4, 50.0, false);
        ReservaEspaco salaUtilizada = new ReservaEspaco(2, 60.0, true);

        System.out.println("--- Academia ---");
        gestor.processarCobranca(academia);
        gestor.processarCancelamento(academia);
        gestor.processarCancelamento(academia); 

        System.out.println("\n--- Reserva Disponível ---");
        gestor.processarCobranca(salaReuniao);
        gestor.processarCancelamento(salaReuniao);

        System.out.println("\n--- Reserva Já Utilizada ---");
        gestor.processarCobranca(salaUtilizada);
        gestor.processarCancelamento(salaUtilizada); 
    }
}