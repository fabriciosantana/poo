package Lucas_Pontual.src.health;

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

    public HealthProfile(String firstName, String lastName, char gender, int dayOfBirth, int monthOfBirth, int yearOfBirth, double heightInInches, double weightInPounds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
    }

    // Getters and Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public char getGender() { return gender; }
    public void setGender(char gender) { this.gender = gender; }
    public int getDayOfBirth() { return dayOfBirth; }
    public void setDayOfBirth(int dayOfBirth) { this.dayOfBirth = dayOfBirth; }
    public int getMonthOfBirth() { return monthOfBirth; }
    public void setMonthOfBirth(int monthOfBirth) { this.monthOfBirth = monthOfBirth; }
    public int getYearOfBirth() { return yearOfBirth; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }
    public double getHeightInInches() { return heightInInches; }
    public void setHeightInInches(double heightInInches) { this.heightInInches = heightInInches; }
    public double getWeightInPounds() { return weightInPounds; }
    public void setWeightInPounds(double weightInPounds) { this.weightInPounds = weightInPounds; }

    public int calculateAge(int currentYear) {
        return currentYear - yearOfBirth;
    }

    public int calculateMaxHeartRate(int currentYear) {
        return 220 - calculateAge(currentYear);
    }

    public String calculateTargetHeartRate(int currentYear) {
        int maxHeartRate = calculateMaxHeartRate(currentYear);
        int minTarget = (int) (maxHeartRate * 0.50);
        int maxTarget = (int) (maxHeartRate * 0.85);
        return String.format("%d bpm - %d bpm", minTarget, maxTarget);
    }

    public double calculateBMI() {
        return (weightInPounds * 703) / (heightInInches * heightInInches);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.nextLine();

        System.out.print("Digite seu gênero (M/F): ");
        char gender = scanner.nextLine().charAt(0);

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double height = scanner.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weight = scanner.nextDouble();

        HealthProfile patient = new HealthProfile(firstName, lastName, gender, day, month, year, height, weight);

        int currentYear = 2025; // Assuming current year is 2025

        System.out.println("Nome: " + patient.getFirstName() + " " + patient.getLastName());
        System.out.println("Gênero: " + (patient.getGender() == (
            'M
        ').charAt(0) ? "Masculino" : "Feminino"));
        System.out.printf("Data de nascimento: %02d/%02d/%d%n", patient.getDayOfBirth(), patient.getMonthOfBirth(), patient.getYearOfBirth());
        System.out.println("Idade: " + patient.calculateAge(currentYear) + " anos");
        System.out.println("Altura: " + patient.getHeightInInches() + " polegadas");
        System.out.println("Peso: " + patient.getWeightInPounds() + " libras");
        System.out.printf("Índice de Massa Corporal (BMI): %.1f%n", patient.calculateBMI());
        System.out.println("Frequência cardíaca máxima: " + patient.calculateMaxHeartRate(currentYear) + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + patient.calculateTargetHeartRate(currentYear));

        System.out.println("\nBMI | Classificação");
        System.out.println("--- | ---");
        System.out.println("Menos de 18.5 | Abaixo do peso");
        System.out.println("18.5 – 24.9 | Peso normal");
        System.out.println("25.0 – 29.9 | Sobrepeso");
        System.out.println("30.0 ou mais | Obesidade");

        scanner.close();
    }
}


