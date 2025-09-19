import java.util.Scanner;
import java.time.LocalDate;

public class HeartRatesApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int currentYear = LocalDate.now().getYear();

        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.nextLine();

        System.out.print("Digite sua data de nascimento (dia mês ano separados por espaço): ");
        int dayOfBirth = scanner.nextInt();
        int monthOfBirth = scanner.nextInt();
        int yearOfBirth = scanner.nextInt();

        HeartRates heartRates = new HeartRates(firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth);

        System.out.println("\n--- Resultado ---");
        System.out.println(heartRates);
        System.out.printf("Idade: %d anos%n", heartRates.calculateAge(currentYear));
        System.out.printf("Frequência cardíaca máxima: %d bpm%n", heartRates.calculateMaxHeartRate(currentYear));
        System.out.printf("Faixa de frequência cardíaca alvo: %s%n", heartRates.calculateTargetHeartRate(currentYear));

        scanner.close();
    }
}
