import java.util.Scanner;

public class MedianCalculator {
    
    public static int findMedian(int a, int b, int c) {
        int num1 = a, num2 = b, num3= c;
            
            if((num1 >= num2 && num1 <= num3) || (num1 <= num2 && num1 >= num3)) {
                return num1;

            }else if((num2 >= num1 && num2 <= num3) || (num2 <= num1 && num2 >= num3)){  
                return num2;
        
            }else{
                return num3;

            }
        }
    

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        System.out.printf("Digite o primeiro número: ");
        int num1 = ler.nextInt();
        System.out.printf("Digite o segundo número: ");
        int num2 = ler.nextInt();
        System.out.printf("Digite o terceiro número: ");
        int num3 = ler.nextInt();

        int mediana = findMedian(num1, num2, num3);

        System.out.printf("A mediana dos números é: %d", mediana);

    }


}
