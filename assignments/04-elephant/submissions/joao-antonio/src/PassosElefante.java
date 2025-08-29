import java.util.Scanner;

public class PassosElefante {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the position of the friends house: ");
        int position = scanner.nextInt();

        scanner.close(); 

        int minSteps = calcularPassosMinimos(position);

        System.out.println(formatarSaida(minSteps));
    }
    public static int calcularPassosMinimos(int position) {
        int completedSteps = position / 5;
        if (position >= 1 && position <= 1000000) {

            if (position % 5 != 0) {
                completedSteps++;
            }
        }
        return completedSteps;
    }
    public static String formatarSaida(int steps) {
        return String.format("The elephant needs to do the minimum of %d steps.", steps);
    }
}