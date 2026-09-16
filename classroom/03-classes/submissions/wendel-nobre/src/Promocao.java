public class Promocao {
    public void concederBonus(ClienteFidelidade cliente, int bonus) {
        if (cliente != null && bonus > 0) {
            cliente.acumularPontos(bonus);
        }
    }

    public void tentarTrocarCliente(ClienteFidelidade cliente, ClienteFidelidade novoCliente) {
        cliente = novoCliente;
    }
}