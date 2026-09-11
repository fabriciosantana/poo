public class GestorServicos {

    public void cobrar(Cobravel servico) {
        System.out.printf("Valor devido: R$ %.2f%n", servico.calcularValorDevido());
    }

    public void solicitarCancelamento(Cancelavel servico) {
        System.out.println("Cancelamento: " + (servico.cancelar() ? "aceito" : "recusado"));
    }
}
