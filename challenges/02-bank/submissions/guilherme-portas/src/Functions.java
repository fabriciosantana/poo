import java.util.Random;
import java.util.Scanner;

public class Functions {
    public static void imprimeMenuInicial() {
        System.out.println("1. Abrir conta\n" +
                           "2. Consultar cliente\n" +
                           "3. Depositar\n" +
                           "4. Sacar\n" +
                           "5. Sair\n");
        
        System.out.print("Digite o número correspondente à opção desejada: ");
    }

    public final static void clearTerminal() {
        for(int i = 0; i < 50; i ++) {
            System.out.println();
        }
    }

    public static String shuffleString(String string) {
        String res = "";
        Random random = new Random();
        for(int i = 0; i < string.length() - 1; i++) {
            int randPos = random.nextInt(string.length() - 1);
            res += string.charAt(randPos);
        }

        return res;
    }

    public static void clearScanner(Scanner scanner) {
        if(scanner.hasNextLine()) scanner.nextLine();
    }
}
