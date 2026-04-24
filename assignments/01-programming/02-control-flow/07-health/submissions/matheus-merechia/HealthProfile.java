import java.util.Scanner;
import java.time.LocalDate;

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
        int idade = calculateAge(LocalDate.now().getYear());
        return 220 - idade;
    }

    public String calculateTargetHeartRate() {
        int max = calculateMaxHeartRate();
        int min = (int)(max * 0.50);
        int maxTarget = (int)(max * 0.85);

        return min + " bpm - " + maxTarget + " bpm";
    }

    public double calculateBMI() {
        return (weightInPounds * 703) / (heightInInches * heightInInches);
    }

    public String getGenderFormatted() {
        return (gender == 'M' || gender == 'm') ? "Masculino" : "Feminino";
    }
}


public class Main extends HealthProfile {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = scanner.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.nextLine();

        System.out.print("Digite seu gênero (M/F): ");
        char gender = scanner.next().charAt(0);

        System.out.print("Digite sua data de nascimento (dia mês ano): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double height = scanner.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weight = scanner.nextDouble();

        HealthProfile pessoa = new HealthProfile(
                firstName, lastName, gender,
                day, month, year,
                height, weight
        );

        int idade = pessoa.calculateAge(LocalDate.now().getYear());
        int maxHR = pessoa.calculateMaxHeartRate();
        String faixa = pessoa.calculateTargetHeartRate();
        double bmi = pessoa.calculateBMI();

        System.out.println("\nNome: " + pessoa.getFirstName() + " " + pessoa.getLastName());
        System.out.println("Gênero: " + pessoa.getGenderFormatted());
        System.out.printf("Data de nascimento: %02d/%02d/%d\n", day, month, year);
        System.out.println("Idade: " + idade + " anos");
        System.out.println("Altura: " + height + " polegadas");
        System.out.println("Peso: " + weight + " libras");
        System.out.printf("Índice de Massa Corporal (BMI): %.1f\n", bmi);
        System.out.println("Frequência cardíaca máxima: " + maxHR + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + faixa);

        System.out.println("\nTabela BMI:");
        System.out.println("Menos de 18.5\tAbaixo do peso");
        System.out.println("18.5 – 24.9\tPeso normal");
        System.out.println("25.0 – 29.9\tSobrepeso");
        System.out.println("30.0 ou mais\tObesidade");

        scanner.close();
    }
}