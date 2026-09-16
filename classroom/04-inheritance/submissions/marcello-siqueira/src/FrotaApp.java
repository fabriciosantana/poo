public class FrotaApp {

    public static void main(String[] argumentos) {
        // "tem um": todo veiculo compoe o proprio Motor. "e um": Caminhao e um VeiculoFrota
        VeiculoFrota veiculo = new VeiculoFrota("JKL-1A23", "diesel", 150.0);
        System.out.println(veiculo.obterDescricao());

        VeiculoFrota caminhao = new Caminhao("MNO-4B56", "diesel", 320.0, 12000.0);
        System.out.println(caminhao.obterDescricao());

        System.out.println("Inválido: " + new VeiculoFrota("  ", null, -80.0).obterDescricao());
        System.out.println("Fronteira: " + new Caminhao("PQR-7C89", "elétrico", 0.0, 0.0).obterDescricao());
    }
}
