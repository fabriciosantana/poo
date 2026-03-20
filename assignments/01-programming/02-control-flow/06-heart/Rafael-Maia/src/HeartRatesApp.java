import java.time.LocalDate;
import java.util.Scanner;

public class HeartRatesApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.next();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.next();

        System.out.print("Digite sua data de nascimento (dia, mes e ano separados por espaco): ");
        int dayOfBirth = scanner.nextInt();
        int monthOfBirth = scanner.nextInt();
        int yearOfBirth = scanner.nextInt();

        HeartRates person = new HeartRates(firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth);

        int currentYear = LocalDate.now().getYear();
        int age = person.calculateAge(currentYear);
        int maxHeartRate = person.calculateMaxHeartRate(currentYear);
        int[] targetHeartRate = person.calculateTargetHeartRate(currentYear);

        System.out.println();
        System.out.println("Nome: " + person.getFirstName() + " " + person.getLastName());
        System.out.printf("Data de nascimento: %02d/%02d/%04d%n",
            person.getDayOfBirth(), person.getMonthOfBirth(), person.getYearOfBirth());
        System.out.println("Idade: " + age + " anos");
        System.out.println("Frequencia cardiaca maxima: " + maxHeartRate + " bpm");
        System.out.println("Faixa de frequencia cardiaca alvo: " +
            targetHeartRate[0] + " bpm - " + targetHeartRate[1] + " bpm");

        scanner.close();
    }
}
