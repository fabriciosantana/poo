public class ClienteFidelidadeReferenciaApp {
    public static void main(String[] args) {
        ClienteFidelidade referenciaOriginal = new ClienteFidelidade("Carlos");
        ClienteFidelidade outraReferencia = referenciaOriginal;

        Promocao promo = new Promocao();

        System.out.println("Pontos iniciais (original): " + referenciaOriginal.getPontos());
        System.out.println("Pontos iniciais (outra): " + outraReferencia.getPontos());

        promo.concederBonus(referenciaOriginal, 50);

        System.out.println("Após bônus (original): " + referenciaOriginal.getPontos());
        System.out.println("Após bônus (outra): " + outraReferencia.getPontos());

        ClienteFidelidade outroCliente = new ClienteFidelidade("Mariana");
        promo.tentarTrocarCliente(referenciaOriginal, outroCliente);

        System.out.println("Nome após tentar trocar: " + referenciaOriginal.getNome());
    }
}