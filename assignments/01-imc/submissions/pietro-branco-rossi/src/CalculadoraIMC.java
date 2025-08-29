import java.util.Scanner;

class CalculadoraIMC {

    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        double altura, peso, resultado_imc;
        String class_imc;

        System.out.print("Digite seu peso em quilogramas: ");
        peso = ler.nextDouble();
        
        System.out.print("Digite sua altura em metros: ");
        altura = ler.nextDouble();

        // chamada da função para calcular
        resultado_imc = calcularIMC(peso, altura);
        
        // chamada da função classificar
        class_imc = classificarIMC(resultado_imc);

        System.out.printf("\nSeu IMC é: %.2f", resultado_imc);
        System.out.printf("\nClassificacao: %s\n", class_imc);

        ler.close();
    }

    public static double calcularIMC(double peso, double altura) {
        double imc = (peso / (altura * altura));
        return imc;
    }

    public static String classificarIMC(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc >= 18.5 && imc < 24.99) {
            return "Eutrófico";
        } else if (imc >= 25 && imc < 29.99) {
            return "Sobrepeso";
        } else if (imc >= 30 && imc < 34.99) {
            return "Obesidade grau I";
        } else if (imc >= 35 && imc < 39.99) {
            return "Obesidade grau II";
        } else {
            return "Obesidade grau III";
        }
    }
}

