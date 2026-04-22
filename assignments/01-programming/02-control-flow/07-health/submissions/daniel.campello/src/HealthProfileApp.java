import java.util.Scanner;

public class HealthProfileApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("First name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Gender (M/F): ");
        char gender = scanner.nextLine().trim().toUpperCase().charAt(0);

        System.out.print("Birth date (day month year): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        System.out.print("Height in inches: ");
        double height = scanner.nextDouble();

        System.out.print("Weight in pounds: ");
        double weight = scanner.nextDouble();

        HealthProfile profile = new HealthProfile(firstName, lastName, gender, day, month, year, height, weight);

        System.out.println("Name: " + profile.getFirstName() + " " + profile.getLastName());
        System.out.println("Gender: " + profile.getGender());
        System.out.println("Age: " + profile.calculateAge(2025));
        System.out.println("BMI: " + String.format("%.1f", profile.calculateBMI()));
        System.out.println("Max heart rate: " + profile.calculateMaxHeartRate());
        System.out.println("Target heart rate: " + profile.calculateTargetHeartRate());

        scanner.close();
    }
}
