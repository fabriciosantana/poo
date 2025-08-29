import java.util.Scanner;

class PassosElefante {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int x;
        int passos;
        String saidaFormatada;

        System.out.print("Digite a posição da casa do amigo: ");
        x = ler.nextInt();

        if (x >= 1 && x <= 1000000) {
            // chamada da função para calcular os passos
            passos = calcularPassosMinimos(x);

            // chamada da função para formatar a saída
            saidaFormatada = formatarSaida(passos);

            System.out.println(saidaFormatada);
        } else {
            System.out.println("A posição deve ser um número entre 1 e 1.000.000.");
        }

        ler.close();
    }

    public static int calcularPassosMinimos(int x) {
        return (x + 4) / 5;
    }

    public static String formatarSaida(int passos) {
        return "O número mínimo de passos necessários é: " + passos;
    }
}