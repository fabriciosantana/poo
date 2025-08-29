import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculadoraIMC {

    public static double calcularIMC(double peso, double altura) {
        if (peso <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Peso e altura devem ser valores positivos.");
        }

        double imc = peso / (altura * altura);
        
        BigDecimal bd = new BigDecimal(Double.toString(imc));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static String classificarIMC(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc >= 18.5 && imc < 25) {
            return "Eutrófico"; 
        } else if (imc >= 25 && imc < 30) {
            return "Sobrepeso";
        } else if (imc >= 30 && imc < 35) {
            return "Obesidade grau I";
        } else if (imc >= 35 && imc < 40) {
            return "Obesidade grau II";
        } else { // imc >= 40
            return "Obesidade grau III";
        }
    }

    public static void main(String[] args) {
        double peso = 75.5; 
        double altura = 1.80; 

        System.out.println("Calculando IMC para:");
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Altura: " + altura + " m");
        System.out.println("--------------------------");

        double imcCalculado = calcularIMC(peso, altura);
        System.out.println("IMC Calculado: " + imcCalculado);

        String classificacao = classificarIMC(imcCalculado);
        System.out.println("Classificação: " + classificacao);
    }
}