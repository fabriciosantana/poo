import java.util.Scanner;

class AprovacaoEstud {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("\nDigite a primeira nota: ");
            double primeiraNota = input.nextDouble();

            System.out.print("Digite a segunda nota: ");
            double segundaNota = input.nextDouble();

            double nota = (primeiraNota + segundaNota) / 2;

            if (nota >= 7){
                System.out.println("Aprovado. Sua média foi: " + nota); 
            } else if (nota >= 5 && nota < 7) {
                System.out.println("Recuperação. Sua média foi: " + nota);
            } else {
                System.out.println("Reprovado. Sua média foi: " + nota);
            }
        }
    }
}
