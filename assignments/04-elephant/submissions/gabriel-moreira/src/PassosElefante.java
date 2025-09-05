import java.util.Scanner;

public class PassosElefante {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite a posição da casa do amigo: ");
        int destino = entrada.nextInt();

        if (destino < 1 || destino > 1_000_000) {
            System.out.println("Erro: a posição deve estar entre 1 e 1.000.000.");
            return;
        }

        int passosMinimos = calcularPassosMinimos(destino);
        String mensagem = formatarSaida(passosMinimos);
        System.out.println(mensagem);
    }

    public static int calcularPassosMinimos(int destino) {
