import java.util.Scanner;
public class CalculadoraIMC {
    public static void main(String[] args) {
        //Cria um objeto Scanner chamado scanner para ler entradas do usuário
        Scanner scanner = new Scanner (System.in);
        
        //Peso usuario
        System.out.println("Digite seu peso em quilogramas: ");
        double peso = scanner.nextDouble();
        
        //altura usuario
        System.out.println("Digite sua altura em metros: ");
        double altura = scanner.nextDouble();
        // receber os valores de imc e classificacao
        double imc = calcularIMC(peso, altura);
        String classificacao = classificarIMC(imc);

        //resultado IMC
        System.out.printf("Seu IMC é %.2f% \n", imc);
        //classificação
        System.out.printf("Classificação: %s", classificacao);

        scanner.close();
    }

    public static double calcularIMC(double peso, double altura){
            double imc = peso/(altura*altura);
            return imc;
    }

    public static String classificarIMC(double imc) {
        if (imc < 18.50) {
            return "Abaixo do peso";
        } else if (imc >= 18.50 && imc < 24.99) {
            return "Eutrófico";
        } else if (imc >= 25.0 && imc < 29.99) {
            return "Sobrepeso";
        } else if (imc >= 30.0 && imc < 34.99) {
            return "Obesidade grau I";
        } else if (imc >= 35.0 && imc < 39.99) {
            return "Obesidade grau II";
        } else { // IMC >= 40.0
            return "Obesidade grau III";
        }
    }
}

// adicionando comentario para ficar no mesmo comit que os outros