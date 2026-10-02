import java.util.Scanner;

public class DiasDoMes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mes = scanner.nextInt();
        int ano = scanner.nextInt();

        int dias = switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> {
                boolean bissexto = ano % 400 == 0 || (ano % 4 == 0 && ano % 100 != 0);
                if (bissexto) {
                    yield 29;
                }
                yield 28;
            }
            // 0 marca mes fora do intervalo de 1 a 12
            default -> 0;
        };

        if (dias == 0) {
            System.out.println("MES INVALIDO");
        } else {
            System.out.println(dias + " dias");
        }

        scanner.close();
    }
}
