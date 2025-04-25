import java.util.Scanner;

public class CollatzSequence {

public static int calcularProximo(int numero) {
return (numero % 2 == 0) ? numero / 2 : (numero * 3) + 1;
}

public static void exibirSequenciaCollatz(int numero) {
int soma = 0;
System.out.print("Sequência de Collatz: ");

while (numero != 1) {
System.out.print(numero + " → ");
soma += numero;
numero = calcularProximo(numero);
        }
soma += 1;  // Adiciona o 1 final à soma
System.out.println("1");
System.out.println("Soma dos termos: " + soma);
}

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
int numero;

do {
System.out.print("Digite um número inteiro positivo: ");
while (!scanner.hasNextInt()) {
System.out.println("Erro: Entrada inválida. Por favor, digite um número inteiro.");
scanner.next(); 
}
numero = scanner.nextInt();
if (numero <= 0) {
System.out.println("Erro: O número deve ser um inteiro positivo.");
}
} while (numero <= 0);

    exibirSequenciaCollatz(numero);

        scanner.close();
    }
}
