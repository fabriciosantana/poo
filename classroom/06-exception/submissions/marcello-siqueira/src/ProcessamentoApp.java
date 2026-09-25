public class ProcessamentoApp {

    public static void main(String[] argumentos) {
        processar(10, 2);
        System.out.println();
        processar(10, 0);
    }

    static void processar(int numerador, int denominador) {
        System.out.println("INICIO");

        try {
            System.out.println("Resultado: " + (numerador / denominador));
        } catch (ArithmeticException erro) {
            System.out.println("Não foi possível dividir por zero.");
        } finally {
            // executa nos dois caminhos, depois do try quando da certo e depois do catch quando falha
            System.out.println("FIM DO PROCESSAMENTO");
        }
    }
}
