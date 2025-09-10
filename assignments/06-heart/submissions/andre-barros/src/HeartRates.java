import java.util.Scanner;
import java.time.LocalDate;

public class HeartRates {
    // Atributos privados
    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    // Construtor
    public HeartRates(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    // Getters e Setters
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

    // Métodos de cálculo
    public int calculateAge(int currentYear) {
        int age = currentYear - this.yearOfBirth;

        LocalDate today = LocalDate.now();
        if (today.getYear() == currentYear) {
            if (today.getMonthValue() < this.monthOfBirth ||
                (today.getMonthValue() == this.monthOfBirth && today.getDayOfMonth() < this.dayOfBirth)) {
                age--;
            }
        }
        return age;
    }

    public int calculateMaxHeartRate() {
        int currentYear = LocalDate.now().getYear();
        return 220 - calculateAge(currentYear);
    }

    public String calculateTargetHeartRate() {
        int maxRate = calculateMaxHeartRate();
        int minTarget = (int) Math.round(maxRate * 0.50);
        int maxTarget = (int) Math.round(maxRate * 0.85);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }

    // Programa principal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = sc.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = sc.nextLine();

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = sc.nextInt();
        int month = sc.nextInt();
        int year = sc.nextInt();

        HeartRates hr = new HeartRates(firstName, lastName, day, month, year);

        int currentYear = LocalDate.now().getYear();

        System.out.println("Nome: " + hr.getFirstName() + " " + hr.getLastName());
        System.out.println("Data de nascimento: " + hr.getDayOfBirth() + "/" + hr.getMonthOfBirth() + "/" + hr.getYearOfBirth());
        System.out.println("Idade: " + hr.calculateAge(currentYear) + " anos");
        System.out.println("Frequência cardíaca máxima: " + hr.calculateMaxHeartRate() + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + hr.calculateTargetHeartRate());

        sc.close();
    }
}
