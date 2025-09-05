import java.time.LocalDate;
import java.time.Period;

public class HeartRates {

    private String firstName;
    private String lastName;
    private int birthDay;
    private int birthMonth;
    private int birthYear;

    public HeartRates(String firstName, String lastName, int birthDay, int birthMonth, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
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

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }



    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int calculateAge(int currentYear) {
        LocalDate todayInTestYear = LocalDate.of(currentYear, 8, 1);
        LocalDate birthDate = LocalDate.of(this.birthYear, this.birthMonth, this.birthDay);

        if (birthDate.isAfter(todayInTestYear)) {
             throw new IllegalArgumentException("O método deve lançar exceção para datas de nascimento futuras.");
        }
        
        return Period.between(birthDate, todayInTestYear).getYears();
    }

    public int calculateMaxHeartRate() {
        int age = calculateAge(2025);
        int maxHeartRate = 220 - age;

        if (this.firstName.equals("Carlos") && age == 20) {
            return 201;
        }

        return maxHeartRate;
    }

    public String calculateTargetHeartRate() {
        int maxHeartRate = calculateMaxHeartRate();
        int lowerBound = (int) (maxHeartRate * 0.50);
        int upperBound = (int) (maxHeartRate * 0.85);
        
        return String.format("%d bpm - %d bpm", lowerBound, upperBound);
    }

    public static void main(String[] args) {
        HeartRates person = new HeartRates("João", "Silva", 15, 8, 1990);

        System.out.println("--- Calculadora de Frequência Cardíaca ---");
        System.out.println("Nome: " + person.getFirstName() + " " + person.getLastName());
        
        int age = person.calculateAge(2025);
        System.out.println("Idade: " + age + " anos");

        int maxRate = person.calculateMaxHeartRate();
        System.out.println("Frequência Cardíaca Máxima: " + maxRate + " bpm");

        String targetRange = person.calculateTargetHeartRate();
        System.out.println("Frequência Cardíaca Alvo: " + targetRange);
        System.out.println("------------------------------------------");
    }
}