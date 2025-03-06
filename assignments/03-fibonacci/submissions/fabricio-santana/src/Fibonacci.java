import java.util.Scanner;

public class Fibonacci {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Digite um número inteiro não negativo: ");
    int n = scanner.nextInt();
    scanner.close();
    Long ans = calcularFibonacci(n);
    String resposta = formatarSaida(ans, n);
    System.out.println(resposta);
  }

  public static Long calcularFibonacci(int n){
    if (n==0) return 0l;
    long a = 0l;
    long b = 1l;
    Long soma = 0l;
    for (int i = 0; i < n; i++) {
      soma = (a + b);
      a = b;
      b = soma;
      System.out.print(a + " ");
    }
    System.out.println(" ");
    return a;
  }

  public static String formatarSaida(long ans,int n){
      return "O " + n + "º número de Fibonacci é: " + ans;
  }
}
