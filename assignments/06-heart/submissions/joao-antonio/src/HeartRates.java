import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class HeartRates {
    private String firstName = "";
    private String lastName = "";
    private int dayOfBirth = 0;
    private int monthOfBirth = 0;
    private int yearOfBirth = 0;

    HeartRates(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.nextLine();

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        HeartRates person = new HeartRates(firstName, lastName, day, month, year);

        System.out.println("\nNome: " + person.getFirstName() + " " + person.getLastName());
        System.out.printf("Data de nascimento: %02d/%02d/%04d%n", person.getDayOfBirth(), person.getMonthOfBirth(), person.getYearOfBirth());

        int age = person.calculateAge();
        System.out.println("Idade: " + age + " anos");

        int maxHeartRate = person.calculateMaxHeartRate();
        System.out.println("Frequência cardíaca máxima: " + maxHeartRate + " bpm");

        double[] targetRate = person.calculateTargetHeartRate();
        System.out.printf("Faixa de frequência cardíaca alvo: %.0f bpm - %.0f bpm%n", targetRate[0], targetRate[1]);

        scanner.close();
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getDayOfBirth() {
        return dayOfBirth;
    }
    public void setDayOfBirth(int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }
    public int getMonthOfBirth() {
        return monthOfBirth;
    }
    public void setMonthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }
    public int getYearOfBirth() {
        return yearOfBirth;
    }
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
    public int calculateAge() {
        LocalDate birthDate = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }
    public int calculateMaxHeartRate() {
        return 220 - calculateAge();
    }
    public double[] calculateTargetHeartRate() {
        int maxHeartRate = calculateMaxHeartRate();
        double minTargetRate = maxHeartRate * 0.50;
        double maxTargetRate = maxHeartRate * 0.85;
        return new double[]{minTargetRate, maxTargetRate};
    }
}