public class ProcessamentoApp {
    static void processar(int numerador, int denominador) {
        System.out.println("INICIO");
        try {
            System.out.println("Resultado: " + (numerador / denominador));
        } catch (ArithmeticException e) {
            System.out.println("DENOMINADOR INVALIDO");
        } finally {
            System.out.println("FIM DO PROCESSAMENTO");
        }
    }

    public static void main(String[] args) {
        processar(10, 2);
        processar(10, 0);
    }
}
