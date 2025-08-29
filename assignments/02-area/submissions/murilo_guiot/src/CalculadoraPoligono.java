import java.text.DecimalFormat;

public class CalculadoraPoligono {

    public static double calcularArea(int numeroLados, double comprimentoLado) {
        if (numeroLados < 3 || comprimentoLado <= 0) {
            throw new IllegalArgumentException("O número de lados precisa ser maior ou igual à 3 e seu comprimento do lado deve ser positivo.");
        }

        double n = (double) numeroLados;

        double area = (n * Math.pow(comprimentoLado, 2)) / (4 * Math.tan(Math.PI / n));

        return Math.round(area * 1000.0) / 1000.0;
    }

    public static String formatarSaida(double area) {
        DecimalFormat df = new DecimalFormat("0.00");
        return "A área do polígono é: " + df.format(area).replace(",", ".") + " metros quadrados";
    }

    public static void main(String[] args) {
        int nLados = 6;
        double cLado = 5.0;

        System.out.println("Calculando a área de um polígono com:");
        System.out.println("Número de lados: " + nLados);
        System.out.println("Comprimento do lado: " + cLado + " m");
        System.out.println("----------------------------------------");
        
        try {
            double areaCalculada = calcularArea(nLados, cLado);
            String saidaFormatada = formatarSaida(areaCalculada);
            System.out.println(saidaFormatada);
        } catch (IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
        }

        int nLadosInvalido = 2;
        double cLadoValido = 10.0;

        System.out.println("\n----------------------------------------");
        System.out.println("Tentando calcular com valores inválidos:");
        System.out.println("Número de lados: " + nLadosInvalido);
        System.out.println("Comprimento do lado: " + cLadoValido + " m");
        
        try {
            calcularArea(nLadosInvalido, cLadoValido);
        } catch (IllegalArgumentException e) {
            System.err.println("Erro esperado: " + e.getMessage());
        }
    }
}