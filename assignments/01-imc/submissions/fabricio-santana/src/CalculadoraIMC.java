import java.util.Scanner;

public class CalculadoraIMC {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Digite seu peso em quilogramas: ");
    Double peso = scanner.nextDouble();
    System.out.println("Digite sua altura em metros: ");
    Double altura = scanner.nextDouble();
    scanner.close();
    Double imc = calcularIMC(peso, altura);
    String classificacao = classificarIMC(imc);
    System.out.println("seu IMC é: " + imc);
    System.out.println("Classificação: " + classificacao);
  }

  public static Double calcularIMC(Double peso, Double altura){
    return peso/Math.pow(altura, 2);
  }

  public static String classificarIMC(Double imc){
    String classificacao = new String();
    if (imc < 18.5) {
      classificacao = "Abaixo do peso";
    }
    else if (imc < 24.99) {
      classificacao = "Eutrófico";
    }
    else if (imc < 29.99){
      classificacao = "Sobrepeso";
    }
    else if (imc < 34.99) {
      classificacao = "Obesidade grau I";
    }
    else if (imc < 39.99) {
      classificacao = "Obesidade grau II";
    }
    else{
      classificacao = "Obesidade grau III";
    }
    return classificacao;
  }
}