import java.util.Scanner;
import java.time.Year;

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

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getDayOfBirth() { return dayOfBirth; }
    public void setDayOfBirth(int dayOfBirth) { this.dayOfBirth = dayOfBirth; }

    public int getMonthOfBirth() { return monthOfBirth; }
    public void setMonthOfBirth(int monthOfBirth) { this.monthOfBirth = monthOfBirth; }

    public int getYearOfBirth() { return yearOfBirth; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }

    public int calculateAge(int currentYear) {
        return currentYear - yearOfBirth;
    }

    public int calculateMaxHeartRate() {
        int currentYear = Year.now().getValue();
        return 220 - (currentYear - yearOfBirth);
    }

    public double[] calculateTargetHeartRate() {
        int maxRate = calculateMaxHeartRate();
        double minTarget = maxRate * 0.50;
        double maxTarget = maxRate * 0.85;
        return new double[]{minTarget, maxTarget};
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = leitor.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = leitor.nextLine();

        System.out.print("Digite sua data de nascimento (dia mês ano): ");
        int day = leitor.nextInt();
        int month = leitor.nextInt();
        int year = leitor.nextInt();

        int currentYear = Year.now().getValue();

        HeartRates pessoa = new HeartRates(firstName, lastName, day, month, year);

        System.out.println("\nNome: " + pessoa.getFirstName() + " " + pessoa.getLastName());
        System.out.printf("Data de nascimento: %02d/%02d/%d%n", pessoa.getDayOfBirth(), pessoa.getMonthOfBirth(), pessoa.getYearOfBirth());

        int idade = pessoa.calculateAge(currentYear);
        System.out.println("Idade: " + idade + " anos");

        int maxHeartRate = pessoa.calculateMaxHeartRate();
        System.out.println("Frequência cardíaca máxima: " + maxHeartRate + " bpm");

        double[] targetRange = pessoa.calculateTargetHeartRate();
        System.out.println("Faixa alvo: " + Math.round(targetRange[0]) + " bpm - " + Math.round(targetRange[1]) + " bpm");

        leitor.close();
    }
}
