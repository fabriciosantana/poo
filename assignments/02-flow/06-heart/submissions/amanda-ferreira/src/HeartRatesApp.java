import java.time.LocalDate;
import java.util.Scanner;

public class HeartRatesApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu primeiro nome: ");
        String name = scanner.next();
        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.next();
        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        HeartRates person = new HeartRates(name, lastName, day, month, year);
        int age = person.calculateAge(LocalDate.now().getYear());
        int max = person.calculateMaxHeartRate();
        int[] target = person.calculateTargetHeartRate();

        System.out.println("Nome: " + person.getFirstName() + " " + person.getLastName());
        System.out.printf("Data de nascimento: %02d/%02d/%d%n", person.getDayOfBirth(), person.getMonthOfBirth(), person.getYearOfBirth());
        System.out.println("Idade: " + age + " anos");
        System.out.println("Frequência cardíaca máxima: " + max + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + target[0] + " bpm - " + target[1] + " bpm");
        scanner.close();
    }
}