import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Números perfeitos entre 1 e 1000:");
        for(int i = 2; i < 1000; i++) {
            if(isPerfect(i)) {
                List<Integer> fatores = new ArrayList<Integer>();
                fatores = getFactors(i);
                System.out.print(i + " é um número perfeito. Fatores: ");
                for(int j = 0; j < fatores.size(); j++) {
                    System.out.print(fatores.get(j));
                    if(j < fatores.size() - 1) System.out.print(", ");
                }
                System.out.println();
            }
        }

        System.out.println("\nTeste Adicional: ");
        System.out.print("Digite um número para verificar se é perfeito: ");
        int num = scanner.nextInt();
        if(isPerfect(num) && num > 1000) {
            List<Integer> fatores = new ArrayList<Integer>();
            fatores = getFactors(num);

            System.out.printf("%d é um número perfeito. Fatores: ", num);
            for (int j = 0; j < fatores.size(); j++) {
                System.out.print(fatores.get(j));
                if (j < fatores.size() - 1)
                    System.out.print(", ");
            }
            System.out.println();
        }
        else if (num < 1000) System.out.println("O número deve ser maior do que 1000");
        else System.out.printf("%d não é um número perfeito.", num);
        scanner.close();
    }

        public static boolean isPerfect(int number) {
            int adicao = 0;
            for(int i = 1; i < number; i++) {
                if(number % i == 0) adicao += i;
            }
            if(adicao == number) return true;
            else return false;
        }

        public static List<Integer> getFactors(int number) {
            List<Integer> fatores = new ArrayList<Integer>();
            for(int i = 1; i < number; i++) {
                if(number % i == 0) fatores.add(i);
            }
            return fatores;
        }
}