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
        this.gender = gender;
        this.dayOfBirth =  dayOfBirth;
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
        int currentYear = Year.now().getValue();
        return 220 - calculateAge(currentYear);
    }

    public double[] calculateTargetHeartRate() {
        int maxRate = calculateMaxHeartRate();
        return new double[]{maxRate * 0.50, maxRate * 0.85};
    }

    public double calculateBMI() {
        return (weightInPounds * 703) / (heightInInches * heightInInches);
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite seu primeiro nome: ");
        String firstName = leitor.nextLine();

        System.out.println("Digite seu sobrenome: ");
        String lastName = leitor.nextLine();

        System.out.print("Digite seu gênero (M/F): ");
        char gender = leitor.next().charAt(0);

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = leitor.nextInt();
        int month = leitor.nextInt();
        int year = leitor.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double height = leitor.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weight = leitor.nextDouble();

        HealthProfile profile = new HealthProfile(firstName, lastName, gender, day, month, year, height, weight);

        int currentYear = Year.now().getValue();
        int age = profile.calculateAge(currentYear);
        double bmi = profile.calculateBMI();
        int maxHR = profile.calculateMaxHeartRate();
        double[] targetHR = profile.calculateTargetHeartRate();

        System.out.println("\nNome: " + profile.getFirstName() + " " + profile.getLastName());
        System.out.println("Gênero: " + (gender == 'M' ? "Masculino" : "Feminino"));
        System.out.printf("Data de nascimento: %02d/%02d/%d%n", day, month, year);
        System.out.println("Idade: " + age + " anos");
        System.out.println("Altura: " + height + " polegadas");
        System.out.println("Peso: " + weight + " libras");
        System.out.printf("Índice de Massa Corporal (BMI): %.1f%n", bmi);
        System.out.println("Frequência cardíaca máxima: " + maxHR + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " +
                Math.round(targetHR[0]) + " bpm - " + Math.round(targetHR[1]) + " bpm");

                System.out.println("\nBMI\t\tClassificação");
                System.out.println("Menos de 18.5\tAbaixo do peso");
                System.out.println("18.5 – 24.9\tPeso normal");
                System.out.println("25.0 – 29.9\tSobrepeso");
                System.out.println("30.0 ou mais\tObesidade");
        
                leitor.close();
    }


}

