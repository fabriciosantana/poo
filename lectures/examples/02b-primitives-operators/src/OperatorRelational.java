import java.util.Scanner;

public class OperatorRelational {
    public static void main(String[] args){
        try (Scanner input = new Scanner(System.in)) {
        
            System.out.println("Enter first integer: ");
            int number1 = input.nextInt();

            System.out.println("Enter second integer: ");
            int number2 = input.nextInt();

            if (number1 == number2) {
                System.out.printf("%d == %d%n", number1, number2);
            }

            if (number1 != number2) {
                System.out.printf("%d != %d%n", number1, number2);
            }

            if (number1 < number2) {
                System.out.printf("%d < %d%n", number1, number2);
            }

            if (number1 > number2) {
                System.out.printf("%d > %d%n", number1, number2);
            }

            if (number1 <= number2) {
                System.out.printf("%d <= %d%n", number1, number2);
            }

            if (number1 >= number2) {
                System.out.printf("%d >= %d%n", number1, number2);
            }
        }
    }
}
