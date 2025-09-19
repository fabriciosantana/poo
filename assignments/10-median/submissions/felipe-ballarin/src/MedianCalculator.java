import java.util.Scanner;

public class MedianCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int a = scanner.nextInt();
        System.out.print("Digite o primeiro número: ");
        int b = scanner.nextInt();
        System.out.print("Digite o primeiro número: ");
        int c = scanner.nextInt();

        int Mediana = findMedian(a, b, c);

        System.out.println("A mediana dos números é: " + Mediana);

        scanner.close();
    }

    public static int findMedian(int a, int b, int c){

        if(a>b){
            if (b>c){
                return b;
            }else{
                if(a>c){
                    return c;
                }else{
                    return a;
                }
            }
        }else{
            if(b<c){
                return b;
            }else{
                if(a>c){
                    return a;
                }else{
                    return c;
                }
            }
        }

    }


    
}
