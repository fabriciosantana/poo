import java.time.Year;
import java.util.Scanner;

public class HealthProfile {
    private String firstName;
    private String lastName;
    private char gender;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private double heightInInches;
    private double weightInPounds;

    public HealthProfile(String firstName, String lastName, char gender,
                         int dayOfBirth, int monthOfBirth, int yearOfBirth,
                         double heightInInches, double weightInPounds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = Character.toUpperCase(gender);
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(char gender) {
        this.gender = Character.toUpperCase(gender);
    }

    public void setDayOfBirth(int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public void setMonthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setHeightInInches(double heightInInches) {
        this.heightInInches = heightInInches;
    }

    public void setWeightInPounds(double weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public char getGender() {
        return gender;
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public double getHeightInInches() {
        return heightInInches;
    }

    public double getWeightInPounds() {
        return weightInPounds;
    }

    public int calculateAge() {
        int currentYear = Year.now().getValue();
        return currentYear - yearOfBirth;
    }

    public int calculateMaxHeartRate() {
        return 220 - calculateAge();
    }

    public String calculateTargetHeartRate() {
        int maxHeartRate = calculateMaxHeartRate();
        int targetMin = (int) (maxHeartRate * 0.50);
        int targetMax = (int) (maxHeartRate * 0.85);
        return targetMin + " bpm - " + targetMax + " bpm";
    }

    public double calculateBMI() {
        return (weightInPounds * 703) / (heightInInches * heightInInches);
    }


    public String getBMIClassification() {
        double bmi = calculateBMI();
        if (bmi < 18.5) {
            return "Abaixo do peso";
        } else if (bmi < 25.0) {
            return "Peso normal";
        } else if (bmi < 30.0) {
            return "Sobrepeso";
        } else {
            return "Obesidade";
        }
    }

    public void displayProfile() {
        System.out.println("Nome: " + firstName + " " + lastName);
        System.out.println("Gênero: " + (gender == 'M' ? "Masculino" : "Feminino"));
        System.out.printf("Data de nascimento: %02d/%02d/%d%n",
                dayOfBirth, monthOfBirth, yearOfBirth);
        System.out.println("Idade: " + calculateAge() + " anos");
        System.out.printf("Altura: %.1f polegadas%n", heightInInches);
        System.out.printf("Peso: %.1f libras%n", weightInPounds);
        System.out.printf("Índice de Massa Corporal (BMI): %.1f%n", calculateBMI());
        System.out.println("Frequência cardíaca máxima: " + calculateMaxHeartRate() + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + calculateTargetHeartRate());
        System.out.println();
    }

    public static void displayBMITable() {
        System.out.println("=== Tabela de Referência BMI ===");
        System.out.println("BMI              Classificação");
        System.out.println("< 18.5           Abaixo do peso");
        System.out.println("18.5 - 24.9      Peso normal");
        System.out.println("25.0 - 29.9      Sobrepeso");
        System.out.println(">= 30.0          Obesidade");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = input.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = input.nextLine();

        System.out.print("Digite seu gênero (M/F): ");
        char gender = input.next().charAt(0);

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double height = input.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weight = input.nextDouble();

        HealthProfile patient = new HealthProfile(firstName, lastName, gender,
                day, month, year, height, weight);

        patient.displayProfile();
        patient.displayBMITable();

        input.close();
    }
}