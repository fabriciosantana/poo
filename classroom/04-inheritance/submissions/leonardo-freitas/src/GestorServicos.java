public class GestorServicos {
    public void cobrar(Cobravel servico) {
        System.out.printf("Valor devido: R$ %.2f%n", servico.calcularValorDevido());
    }

    public void solicitarCancelamento(Cancelavel servico) {
        System.out.println(servico.cancelar()
                ? "Cancelamento realizado."
                : "Cancelamento não realizado.");
    }
}
