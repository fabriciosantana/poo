import java.util.Scanner;
import java.util.Calendar;

public class HeartRatesTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = input.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = input.nextLine();

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();

        HeartRates person = new HeartRates(firstName, lastName, day, month, year);

        int age = person.calculateAge(currentYear);
        int maxHR = person.calculateMaxHeartRate(age);
        String targetHR = person.calculateTargetHeartRate(maxHR);

        System.out.println("\n--- Resumo das Informações ---");
        System.out.printf("Nome: %s %s%n", person.getFirstName(), person.getLastName());
        System.out.printf("Data de nascimento: %02d/%02d/%d%n",
                person.getDayOfBirth(), person.getMonthOfBirth(), person.getYearOfBirth());
        System.out.printf("Idade: %d anos%n", age);
        System.out.printf("Frequência cardíaca máxima: %d bpm%n", maxHR);
        System.out.printf("Faixa de frequência cardíaca alvo: %s%n", targetHR);

        input.close();
    }
}