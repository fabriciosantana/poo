import java.util.Scanner;

public class HeartRates {
    private static final int REFERENCE_YEAR = 2025;
    private static final int REFERENCE_MONTH = 4;
    private static final int REFERENCE_DAY = 10;

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

    public int calculateAge(int currentYear) {
        int age = currentYear - yearOfBirth;

        if (monthOfBirth > REFERENCE_MONTH || (monthOfBirth == REFERENCE_MONTH && dayOfBirth > REFERENCE_DAY)) {
            age--;
        }

        return age;
    }

    public int calculateMaxHeartRate() {
        return 220 - calculateAge(REFERENCE_YEAR);
    }

    public String calculateTargetHeartRate() {
        int maxHeartRate = calculateMaxHeartRate();
        int minimumTargetHeartRate = (int) (maxHeartRate * 0.50);
        int maximumTargetHeartRate = (int) (maxHeartRate * 0.85);

        return minimumTargetHeartRate + " bpm - " + maximumTargetHeartRate + " bpm";
    }

    public static int getReferenceYear() {
        return REFERENCE_YEAR;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite seu primeiro nome: ");
            String firstName = scanner.nextLine();

            System.out.print("Digite seu sobrenome: ");
            String lastName = scanner.nextLine();

            System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
            int dayOfBirth = scanner.nextInt();
            int monthOfBirth = scanner.nextInt();
            int yearOfBirth = scanner.nextInt();

            HeartRates heartRates = new HeartRates(firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth);
            int referenceYear = HeartRates.getReferenceYear();

            System.out.println("Nome: " + heartRates.getFirstName() + " " + heartRates.getLastName());
            System.out.printf("Data de nascimento: %02d/%02d/%04d%n", heartRates.getDayOfBirth(), heartRates.getMonthOfBirth(), heartRates.getYearOfBirth());
            System.out.println("Idade: " + heartRates.calculateAge(referenceYear) + " anos");
            System.out.println("Frequência cardíaca máxima: " + heartRates.calculateMaxHeartRate() + " bpm");
            System.out.println("Faixa de frequência cardíaca alvo: " + heartRates.calculateTargetHeartRate());
        }
    }
}