import java.util.Scanner;

public class PassosElefante {

    // método main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // entrada do usuário
        System.out.print("Digite a posição da casa do amigo: ");
        int x = scanner.nextInt();

        // validação do intervalo
        if (x < 1 || x > 1_000_000) {
            System.out.println("Valor inválido! x deve estar entre 1 e 1.000.000.");
        } else {
            // cálculo
            int passos = calcularPassosMinimos(x);

            // saída formatada
            String resultado = formatarSaida(passos);
            System.out.println(resultado);
        }

        scanner.close();
    }

    // método que calcula o número mínimo de passos
    public static int calcularPassosMinimos(int x) {
        // divide por 5 e verifica se sobra resto
        return (x + 4) / 5; 
        // mesma lógica que Math.ceil(x / 5.0)
    }

    // método que formata a saída
    public static String formatarSaida(int passos) {
        return String.format("O número mínimo de passos necessários é: %d", passos);
    }
}
