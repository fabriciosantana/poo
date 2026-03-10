import java.util.Scanner;

public class CalcularPoligono {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o numero de Lados do Poligono: ");
        int n = teclado.nextInt();

        System.out.printf("Digite o Comprimento do Lado em metros:  ");
        double s = teclado.nextDouble();

        double A = calcularArea(n,s);
        formatarSaida(A);

    }
    public static double calcularArea(int n, double s){
        double A = (1.0/4) * (s*s) * (n) * (1 / Math.tan(Math.PI / n));
        // (s^2 * n) / 4Tan(π/n)
        return A;
    }
    public static void formatarSaida(double A){
        System.out.printf("área do polígono é: %.2f metros quadrados", A);
    }
}
/*
A = \frac{1}{4} \times s^2 \times n \times \frac{1}{\tan(\pi / n)}
- `n` → número de lados do polígono;
- `s` → comprimento de um lado;
- `π` → constante matemática (π ≈ 3.14159)
*/
