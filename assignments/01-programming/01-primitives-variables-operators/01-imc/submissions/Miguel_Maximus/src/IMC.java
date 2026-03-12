
import java.util.Scanner;

public class IMC {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite seu peso (kg): ");
            double peso = scanner.nextDouble();
            
            System.out.print("Digite sua altura (m): ");
            double altura = scanner.nextDouble();
            
            double imc = peso / (altura * altura);
            
            System.out.printf("Seu IMC: %.2f%n", imc);
        }
    }
}

