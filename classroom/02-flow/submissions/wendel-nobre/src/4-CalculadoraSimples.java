import java.util.Scanner;

public class CalculadoraSimples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double n1 = scanner.nextDouble();
        char operador = scanner.next().charAt(0);
        double n2 = scanner.nextDouble();

        switch (operador) {
            case '+' -> System.out.println(n1 + n2);
            case '-' -> System.out.println(n1 - n2);
            case '*' -> System.out.println(n1 * n2);
            case '/' -> {
                if (n2 == 0) {
                    System.out.println("Erro: Divisão por zero");
                } else {
                    System.out.println(n1 / n2);
                }
            }
            default -> System.out.println("OPERADOR INVALIDO");
        }

        scanner.close();
    }
}