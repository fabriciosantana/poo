import java.util.Scanner;

public class HealthProfile {
    private static final int REFERENCE_YEAR = 2025;
    private static final int REFERENCE_MONTH = 4;
    private static final int REFERENCE_DAY = 10;

    private String firstName;
    private String lastName;
    private char gender;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private double heightInInches;
    private double weightInPounds;

    public HealthProfile(String firstName, String lastName, char gender, int dayOfBirth, int monthOfBirth,
            int yearOfBirth, double heightInInches, double weightInPounds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
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

    public double getHeightInInches() {
        return heightInInches;
    }

    public void setHeightInInches(double heightInInches) {
        this.heightInInches = heightInInches;
    }

    public double getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(double weightInPounds) {
        this.weightInPounds = weightInPounds;
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
        int minTarget = (int) (maxHeartRate * 0.50);
        int maxTarget = (int) (maxHeartRate * 0.85);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }

    public double calculateBMI() {
        return (weightInPounds * 703) / (heightInInches * heightInInches);
    }

    private String getGenderLabel() {
        char normalizedGender = Character.toUpperCase(gender);
        if (normalizedGender == 'M') {
            return "Masculino";
        }
        if (normalizedGender == 'F') {
            return "Feminino";
        }
        return "Nao informado";
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite seu primeiro nome: ");
            String firstName = scanner.nextLine();

            System.out.print("Digite seu sobrenome: ");
            String lastName = scanner.nextLine();

            System.out.print("Digite seu genero (M/F): ");
            char gender = scanner.next().charAt(0);

            System.out.print("Digite sua data de nascimento (dia, mes e ano separados por espaco): ");
            int dayOfBirth = scanner.nextInt();
            int monthOfBirth = scanner.nextInt();
            int yearOfBirth = scanner.nextInt();

            System.out.print("Digite sua altura em polegadas: ");
            double heightInInches = scanner.nextDouble();

            System.out.print("Digite seu peso em libras: ");
            double weightInPounds = scanner.nextDouble();

            HealthProfile profile = new HealthProfile(firstName, lastName, gender, dayOfBirth, monthOfBirth, yearOfBirth,
                    heightInInches, weightInPounds);

            System.out.println("Nome: " + profile.getFirstName() + " " + profile.getLastName());
            System.out.println("Genero: " + profile.getGenderLabel());
            System.out.printf("Data de nascimento: %02d/%02d/%04d%n", profile.getDayOfBirth(), profile.getMonthOfBirth(),
                    profile.getYearOfBirth());
            System.out.println("Idade: " + profile.calculateAge(REFERENCE_YEAR) + " anos");
            System.out.println("Altura: " + profile.getHeightInInches() + " polegadas");
            System.out.println("Peso: " + profile.getWeightInPounds() + " libras");
            System.out.printf("Indice de Massa Corporal (BMI): %.1f%n", profile.calculateBMI());
            System.out.println("Frequencia cardiaca maxima: " + profile.calculateMaxHeartRate() + " bpm");
            System.out.println("Faixa de frequencia cardiaca alvo: " + profile.calculateTargetHeartRate());

            System.out.println();
            System.out.println("Tabela BMI:");
            System.out.println("Menos de 18.5: Abaixo do peso");
            System.out.println("18.5 - 24.9: Peso normal");
            System.out.println("25.0 - 29.9: Sobrepeso");
            System.out.println("30.0 ou mais: Obesidade");
        }
    }
}
