import java.util.Locale;

public class OrcamentoPisoApp {
    public static void main(String[] args) {
        OrcamentoPiso comodo1 = new OrcamentoPiso(5.0, 3.0, 80.0);
        OrcamentoPiso comodo2 = new OrcamentoPiso(-2.0, 4.0, 50.0);

        System.out.println("--- Orçamento 1 ---");
        exibir(comodo1);

        System.out.println();

        System.out.println("--- Orçamento 2 ---");
        exibir(comodo2);
    }

    private static void exibir(OrcamentoPiso orcamento) {
        System.out.printf(Locale.US, "Comprimento: %.2f m%n", orcamento.obterComprimento());
        System.out.printf(Locale.US, "Largura: %.2f m%n", orcamento.obterLargura());
        System.out.printf(Locale.US, "Preço por m²: R$ %.2f%n", orcamento.obterPrecoPorMetroQuadrado());
        System.out.printf(Locale.US, "Área: %.2f m²%n", orcamento.calcularArea());
        System.out.printf(Locale.US, "Rodapé: %.2f m%n", orcamento.calcularComprimentoRodaPe());
        System.out.printf(Locale.US, "Preço Total: R$ %.2f%n", orcamento.calcularPrecoTotal());
    }
}