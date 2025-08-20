import java.util.Scanner;

public class CalculadoraPoligono {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in); //CRIA SCANNER

        System.out.print("Digite o número de lados do polígono: ");  //SCANNER NUMERO DE LADOS
        int n  = scanner.nextInt();

        System.out.print("Digite o comprimento do lado em metros: "); //SCANNER COMPRIMENTO LADOS
        double s  = scanner.nextDouble(); 


        if (n < 3 || s <= 0){

            System.out.println("Valores inválidos");
            scanner.close();
            return;
        }

        double area = calcularArea (n, s);
        String saida = formatarSaida (area);


        System.out.println(saida);

        scanner.close();
    }

    //Formula area de poligono regular --> A = (n * s^2) / (4 * tan(pi/n))

    public static double calcularArea(int n, double s){
        return (n * s * s) / (4.0 * Math.tan(Math.PI / n));
    }

    public static String formatarSaida (double area){
        return String.format("A área do polígono é: %.2f metros quadrados", area);
    }
}
