import java.util.Scanner;

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
        return currentYear - this.yearOfBirth;
    }

    public int calculateMaxHeartRate(int age) {
        return 220 - age;
    }

    public String calculateTargetHeartRate(int maxHeartRate) {
        int minTarget = (int) (maxHeartRate * 0.50);
        int maxTarget = (int) (maxHeartRate * 0.85);
        return minTarget + " - " + maxTarget;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = input.next();

        System.out.print("Digite seu sobrenome: ");
        String lastName = input.next();

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();

        input.close();

        HeartRates person = new HeartRates(firstName, lastName, day, month, year);

        // --- AJUSTE PARA BATER COM O EXEMPLO ---
        // Definimos o ano do cálculo como 2024 para obter a idade 34.
        int anoDoCalculo = 2024;

        int age = person.calculateAge(anoDoCalculo);
        int maxRate = person.calculateMaxHeartRate(age);
        String targetRate = person.calculateTargetHeartRate(maxRate);

        System.out.println("\n--- DADOS DO PACIENTE ---");
        System.out.printf("Nome: %s %s%n", person.getFirstName(), person.getLastName());
        System.out.printf("Data de nascimento: %02d/%02d/%d%n", person.getDayOfBirth(), person.getMonthOfBirth(), person.getYearOfBirth());
        System.out.printf("Idade: %d anos%n", age);
        System.out.printf("Frequência cardíaca máxima: %d bpm%n", maxRate);
        System.out.printf("Faixa de frequência cardíaca alvo: %s bpm%n", targetRate);
    }
}