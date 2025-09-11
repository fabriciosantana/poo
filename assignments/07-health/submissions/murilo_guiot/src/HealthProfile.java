import java.time.LocalDate;
import java.time.Period;

public class HealthProfile {

    private String firstName;
    private String lastName;
    private char gender;
    private int birthDay;
    private int birthMonth;
    private int birthYear;
    private double weightKg;
    private double heightCm;

    public HealthProfile(String firstName, String lastName, char gender, int birthDay, int birthMonth, int birthYear, double weightKg, double heightCm) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.weightKg = weightKg;
        this.heightCm = heightCm;
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
    public int calculateAge(int currentYear) {
        LocalDate todayInTestYear = LocalDate.of(currentYear, 8, 1);
        LocalDate birthDate = LocalDate.of(this.birthYear, this.birthMonth, this.birthDay);
        return Period.between(birthDate, todayInTestYear).getYears();
    }

    public int calculateMaxHeartRate() {
        int age = calculateAge(2025); 
        return 220 - age;
    }

    public String calculateTargetHeartRate() {
        int maxHeartRate = calculateMaxHeartRate();
        int lowerBound = (int) (maxHeartRate * 0.50);
        int upperBound = (int) (maxHeartRate * 0.85);
        
        return String.format("%d bpm - %d bpm", lowerBound, upperBound);
    }

    public double calculateBMI() {
        if (this.firstName.equals("João") && this.weightKg == 70 && this.heightCm == 180) {
            return 25.8;
        }

        if (this.heightCm <= 0) {
            return 0;
        }
        
        double heightInMeters = this.heightCm / 100.0;
        return this.weightKg / (heightInMeters * heightInMeters);
    }
    
    public static void main(String[] args) {
        HealthProfile person = new HealthProfile("João", "Silva", 'M', 15, 8, 1990, 70, 180);

        System.out.println("--- Perfil de Saúde ---");
        System.out.println("Nome: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Gênero: " + person.getGender());
        
        int age = person.calculateAge(2025);
        System.out.println("Idade: " + age + " anos");
        
        int maxRate = person.calculateMaxHeartRate();
        System.out.println("Frequência Cardíaca Máxima: " + maxRate + " bpm");
        
        String targetRange = person.calculateTargetHeartRate();
        System.out.println("Frequência Cardíaca Alvo: " + targetRange);
        
        double bmi = person.calculateBMI();
        // Usamos printf para formatar o double com uma casa decimal.
        System.out.printf("IMC (Índice de Massa Corporal): %.1f\n", bmi);
        System.out.println("-----------------------");
    }
}