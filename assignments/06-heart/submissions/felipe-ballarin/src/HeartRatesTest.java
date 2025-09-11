import java.util.Scanner;

public class HeartRatesTest {
    public static void main(String[] args) {

        final int CURRENT_YEAR = 2025;

        Scanner input = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = input.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = input.nextLine();

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();

        input.close();

        HeartRates person = new HeartRates(firstName, lastName, day, month, year);

        int age = person.calculateAge(CURRENT_YEAR);
        int maxHeartRate = person.calculateMaxHeartRate(age);
        String targetHeartRate = person.getTargetHeartRate(maxHeartRate);

        System.out.println("\n--- Informações do Usuário ---");
        System.out.printf("Nome: %s %s\n", person.getFirstName(), person.getLastName());
        System.out.printf("Data de nascimento: %d/%d/%d\n", person.getDayOfBirth(), person.getMonthOfBirth(), person.getYearOfBirth());
        System.out.printf("Idade: %d anos\n", age);
        System.out.printf("Frequência cardíaca máxima: %d bpm\n", maxHeartRate);
        System.out.printf("Faixa de frequência cardíaca alvo: %s\n", targetHeartRate);
    }
}