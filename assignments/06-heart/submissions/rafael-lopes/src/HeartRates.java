import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class HeartRates {
    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    public HeartRates(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    public int calculateAge() {
        LocalDate birthDate = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public int calculateMaxHeartRate() {
        return 220 - calculateAge();
    }

    public String calculateTargetHeartRate() {
        int maxHeartRate = calculateMaxHeartRate();
        int minTarget = (int) (maxHeartRate * 0.50);
        int maxTarget = (int) (maxHeartRate * 0.85);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getBirthDate() {
        return dayOfBirth + "/" + monthOfBirth + "/" + yearOfBirth;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.nextLine();

        System.out.print("Digite sua data de nascimento (dia mês ano): ");
        String birthDateInput = scanner.nextLine();
        String[] birthDateParts = birthDateInput.split(" ");

        if (birthDateParts.length != 3) {
            System.out.println("Erro: Você deve inserir a data no formato correto (dia mês ano). ");
            return;
        }

        int day = Integer.parseInt(birthDateParts[0]);
        int month = Integer.parseInt(birthDateParts[1]);
        int year = Integer.parseInt(birthDateParts[2]);

        HeartRates person = new HeartRates(firstName, lastName, day, month, year);

        System.out.println("\nNome: " + person.getFullName());
        System.out.println("Data de nascimento: " + person.getBirthDate());
        System.out.println("Idade: " + person.calculateAge() + " anos");
        System.out.println("Frequência cardíaca máxima: " + person.calculateMaxHeartRate() + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + person.calculateTargetHeartRate());

        scanner.close();
    }
}
