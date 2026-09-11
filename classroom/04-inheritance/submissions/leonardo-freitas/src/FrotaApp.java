public class FrotaApp {
    public static void main(String[] argumentos) {
        // VeiculoFrota "tem um" Motor: composição.
        VeiculoFrota utilitario = new VeiculoFrota("ABC1D23", "Flex", 120.0);

        // Caminhao "é um" VeiculoFrota: herança.
        Caminhao caminhao = new Caminhao("DEF4G56", "Diesel", 420.0, 12000.0);

        System.out.println(utilitario.obterDescricao());
        System.out.println(caminhao.obterDescricao());
    }
}
