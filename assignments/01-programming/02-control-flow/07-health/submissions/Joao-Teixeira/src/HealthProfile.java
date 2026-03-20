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

    public int calculateMaxHeartRate() {
    return 220 - calculateAge(2026);
    }

    public String calculateTargetHeartRate() {
        int max = calculateMaxHeartRate();
        return String.format("%.0f bpm - %.0f bpm", max * 0.5, max * 0.85);
    }

    public double calculateBMI() {
        return (weightInPounds * 703) / (heightInInches * heightInInches);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int anoAtual = 2026;

        System.out.print("Digite seu primeiro nome: ");
        String fName = scanner.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lName = scanner.nextLine();

        System.out.print("Digite seu gênero (M/F): ");
        char gen = scanner.next().toUpperCase().charAt(0);

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int d = scanner.nextInt();
        int m = scanner.nextInt();
        int y = scanner.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double h = scanner.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double w = scanner.nextDouble();

        HealthProfile paciente = new HealthProfile(fName, lName, gen, d, m, y, h, w);

        System.out.println("\n--- PERFIL DE SAÚDE ---");
        System.out.println("Nome: " + paciente.getFirstName() + " " + paciente.getLastName());
        System.out.println("Gênero: " + (paciente.getGender() == 'M' ? "Masculino" : "Feminino"));
        System.out.printf("Data de nascimento: %d/%d/%d\n", 
                          paciente.getDayOfBirth(), paciente.getMonthOfBirth(), paciente.getYearOfBirth());
        System.out.printf("Idade: %d anos\n", paciente.calculateAge(anoAtual));
        System.out.printf("Altura: %.1f polegadas\n", paciente.getHeightInInches());
        System.out.printf("Peso: %.1f libras\n", paciente.getWeightInPounds());
        System.out.printf("Índice de Massa Corporal (BMI): %.1f\n", paciente.calculateBMI());
        System.out.printf("Frequência cardíaca máxima: %d bpm\n", paciente.calculateMaxHeartRate(anoAtual));
        System.out.printf("Faixa de frequência cardíaca alvo: %s\n", paciente.calculateTargetHeartRate(anoAtual));

        System.out.println("\nTABELA DE VALORES DO BMI");
        System.out.println("Abaixo do peso: menos de 18.5");
        System.out.println("Peso normal:    18.5 – 24.9");
        System.out.println("Sobrepeso:      25.0 – 29.9");
        System.out.println("Obesidade:      30.0 ou mais");

        scanner.close();
    }
}