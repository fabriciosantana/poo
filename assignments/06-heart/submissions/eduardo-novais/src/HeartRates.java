import java.util.Scanner;

public class HeartRates {
    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    public HeartRates(String firstName, String lastName, int day, int month, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = day;
        this.monthOfBirth = month;
        this.yearOfBirth = year;
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
        int age = currentYear - yearOfBirth;

        return age;
    }

    public int calculateMaxHeartRate() {
        int age = calculateAge(2025);

        return 220 - age;
    }

    public String calculateTargetHeartRate() {
        int maxHeartRate = calculateMaxHeartRate();

        int min = (int) (maxHeartRate * 0.50);
        int max = (int) (maxHeartRate * 0.85);
        
        return String.format("%d bpm - %d bpm", min, max);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite seu primeiro nome: ");
        String firstName = input.nextLine();

        System.out.println("Digite seu sobrenome: ");
        String lastName = input.nextLine();

        System.out.println("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();

        HeartRates person = new HeartRates(firstName, lastName, day, month, year);

        System.out.printf("Nome: %s %s%n", person.getFirstName(), person.getLastName());

        System.out.printf("Data de nascimento: %d/%d/%d%n", person.getDayOfBirth(), person.getMonthOfBirth(), person.getYearOfBirth());

        System.out.printf("Idade: %d anos%n", person.calculateAge(2025));

        System.out.printf("Frequência cardíaca máxima: %d bpm%n", person.calculateMaxHeartRate());

        System.out.printf("Faixa de frequência cardíaca alvo: %s%n", person.calculateTargetHeartRate());

        input.close();
    }
}
