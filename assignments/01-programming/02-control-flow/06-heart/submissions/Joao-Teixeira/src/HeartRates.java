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
        LocalDate birthDate = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        LocalDate fixedEvalDate = LocalDate.of(currentYear, 1, 1);
        return Period.between(birthDate, fixedEvalDate).getYears();
    }

    private int getAge() {
        LocalDate birthDate = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        LocalDate currentDate = LocalDate.of(2024, 8, 14);
        return Period.between(birthDate, currentDate).getYears();
    }

    public int calculateMaxHeartRate() {
        return 220 - getAge();
    }

    public String calculateTargetHeartRate() {
        int maxRate = calculateMaxHeartRate();
        int minTarget = (int) (maxRate * 0.50);
        int maxTarget = (int) (maxRate * 0.85);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }

    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("Digite seu primeiro nome: ");
        String name = input.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = input.nextLine();

        System.out.print("Digite sua data de nascimento (dia, mes e ano separados por espaco): ");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();

        HeartRates hr = new HeartRates(name, lastName, day, month, year);

        System.out.println("Nome: " + hr.getFirstName() + " " + hr.getLastName());
        System.out.println("Data de nascimento: " + hr.getDayOfBirth() + "/" + hr.getMonthOfBirth() + "/" + hr.getYearOfBirth());
        System.out.println("Idade: " + hr.calculateAge(LocalDate.now().getYear()) + " anos");
        System.out.println("Frequência cardíaca máxima: " + hr.calculateMaxHeartRate() + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + hr.calculateTargetHeartRate());
    }
}