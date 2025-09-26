import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class PerfectNumber {

    // verifica se um numero e perfeito
    public static boolean isPerfect(int number) {
        // numeros menores que 2 nao sao perfeitos
        if (number < 2) return false;

        // soma os divisores proprios
        int sum = 0;
        for (int f : getFactors(number)) {
            sum += f;
        }
        return sum == number;
    }

    // retorna lista de divisores proprios em ordem crescente
    public static List<Integer> getFactors(int number) {
        // divisores proprios incluem 1 e excluem o proprio numero
        List<Integer> factors = new ArrayList<>();
        if (number <= 1) {
            // sem divisores proprios relevantes
            return factors;
        }

        // 1 e sempre divisor proprio
        factors.add(1);
        // percorre de 2 ate a raiz quadrada do numero
        int limit = (int)Math.sqrt(number);
        for (int i = 2; i <= limit; i++) {
            if (number % i == 0) {
                // i e divisor
                factors.add(i);
                // par complementar n i
                int pair = number / i;
                // evita duplicar quando i * i == number
                // e garante que pair nao seja o proprio numero
                if (pair != i && pair != number) {
                    factors.add(pair);
                }
            }
        }
        // ordena crescente
        Collections.sort(factors);
        return factors;
    }
    // executa o programa
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // mostra perfeitos entre 1 e 1000
        System.out.println("Números perfeitos entre 1 e 1000:");
        for (int n = 1; n <= 1000; n++) {
            if (isPerfect(n)) {
                List<Integer> f = getFactors(n);
                System.out.println(n + " é um número perfeito. Fatores: " + join(f));
            }
        }
        // teste adicional com validacao de entrada
        System.out.println("\nTeste adicional:");
        int input = readPositiveInt(sc, "Digite um número para verificar se é perfeito: ");

        List<Integer> f = getFactors(input);
        if (isPerfect(input)) {
            System.out.println(input + " é um número perfeito. Fatores: " + join(f));
        } else {
            System.out.println(input + " não é um número perfeito. Fatores: " + join(f));
        }
        sc.close();
    }
    // le um inteiro positivo do usuário
    // repete enquanto a entrada for invalida
    private static int readPositiveInt(Scanner sc, String prompt) {
        // loop ate receber inteiro positivo
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                int val = sc.nextInt();
                if (val > 0) {
                    return val;
                } else {
                    System.out.println("Por favor, digite um inteiro positivo.");
                }
            } else {
                // descarta token invalido
                sc.next();
                System.out.println("Entrada inválida. Digite um inteiro positivo.");
            }
        }
    }
    // junta a listaa de inteiros com virgulas
    private static String join(List<Integer> list) {
        // constroi string separada por virgulas e espacos
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
