public class GestorServicos {
    public void processarCobranca(Cobravel cobravel) {
        System.out.printf("Cobrança realizada. Valor devido: R$ %.2f%n", cobravel.calcularValorDevido());
    }

    public void processarCancelamento(Cancelavel cancelavel) {
        boolean sucesso = cancelavel.cancelar();
        System.out.println("Cancelamento solicitado: " + (sucesso ? "Concluído com sucesso" : "Falha (operação não permitida)"));
    }
}