import java.util.Scanner;

public class DiasDoMes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int mes = scanner.nextInt();
        int ano = scanner.nextInt();

        switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12 -> System.out.println("31 dias");
            case 4, 6, 9, 11 -> System.out.println("30 dias");
            case 2 -> {
                if ((ano % 400 == 0) || (ano % 4 == 0 && ano % 100 != 0)) {
                    System.out.println("29 dias");
                } else {
                    System.out.println("28 dias");
                }
            }
            default -> System.out.println("MES INVALIDO");
        }

        scanner.close();
    }
}