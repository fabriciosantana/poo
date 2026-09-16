public class ClienteFidelidadeApp {
    public static void main(String[] args) {
        ClienteFidelidade c1 = new ClienteFidelidade("João");

        c1.acumularPontos(100);
        System.out.println("Pontos do " + c1.getNome() + ": " + c1.getPontos());

        boolean resgate1 = c1.resgatarPontos(40);
        System.out.println("Resgate de 40: " + resgate1);
        System.out.println("Pontos após resgate: " + c1.getPontos());

        boolean resgate2 = c1.resgatarPontos(200);
        System.out.println("Resgate de 200: " + resgate2);
        System.out.println("Pontos sem saldo: " + c1.getPontos());

        c1.desativar();

        c1.acumularPontos(50);
        boolean resgate3 = c1.resgatarPontos(10);
        System.out.println("Resgate após desativar: " + resgate3);
        System.out.println("Pontos finais: " + c1.getPontos());
        System.out.println("Cliente ativo: " + c1.isAtivo());
    }
}