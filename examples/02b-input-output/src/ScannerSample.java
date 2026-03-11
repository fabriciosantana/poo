
import java.util.Scanner;

public class ScannerSample {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        System.out.print("Informe um inteiro: ");
        int i = input.nextInt();
        System.out.printf("Valor informado: %d%n", i); // %d inteiros

        System.out.print("Informe um double: ");
        double d = input.nextDouble();
        System.out.printf("Valor informado: %.3f%n", d); // %f números reais com X casas decimais 

        System.out.print("Informe um float: ");
        float f = input.nextFloat();
        System.out.printf("Valor informado: %.5f%n", f); // %f números reais com X casas decimais 

        System.out.print("Informe um boolean: ");
        boolean b = input.nextBoolean();
        System.out.printf("Valor informado: %b%n", b); // %b boleanos

        System.out.print("Informe um texto: ");
        String s = input.next();
        System.out.printf("Valor informado: %s%n", s); // %s String

        input.nextLine();
        
        System.out.print("Informe um texto: ");
        s = input.nextLine();
        System.out.printf("Valor informado: %s%n", s); // %s String

        input.close();
        System.out.print("Fim");
    }
    
}
