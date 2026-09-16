public class IluminacaoLojaApp {
    public static void main(String[] argumentos) {
        IluminacaoLoja vitrine = new IluminacaoLoja("Vitrine", 150.0);
        IluminacaoLoja estoque = new IluminacaoLoja("Estoque", 80.0);
        vitrine.ligar();

        exibir(vitrine);
        exibir(estoque);
    }

    private static void exibir(IluminacaoLoja iluminacao) {
        String status = iluminacao.estaLigada() ? "Ligada" : "Desligada";
        System.out.println("Setor: " + iluminacao.obterSetor() + 
                           " | Potência: " + iluminacao.obterPoteciawatts() + "W" +
                           " | Status: " + status);
    }
}