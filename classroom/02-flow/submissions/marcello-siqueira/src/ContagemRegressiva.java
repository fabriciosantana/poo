import java.util.Scanner;

public class ContagemRegressiva {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int contador = scanner.nextInt();

        if (contador <= 0) {
            System.out.println("VALOR INVALIDO");
        } else {
            while (contador >= 0) {
                System.out.print(contador + " ");
                contador--;
            }
            System.out.println("FIM");
        }

        scanner.close();
    }
}
