public import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

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

    public int calculateAge() {
        LocalDate birthDate = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public int calculateMaxHeartRate() {
        return 220 - calculateAge();
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

    public static void printBMITable() {
        System.out.println("\nTabela de Referência do BMI:");
        System.out.println("Menos de 18.5 - Abaixo do peso");
        System.out.println("18.5 - 24.9 - Peso normal");
        System.out.println("25.0 - 29.9 - Sobrepeso");
        System.out.println("30.0 ou mais - Obesidade");
    }

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

        HealthProfile person = new HealthProfile(firstName, lastName, gender, day, month, year, height, weight);

        System.out.println("\nNome: " + firstName + " " + lastName);
        System.out.println("Gênero: " + (gender == 'M' ? "Masculino" : "Feminino"));
        System.out.println("Data de nascimento: " + day + "/" + month + "/" + year);
        System.out.println("Idade: " + person.calculateAge() + " anos");
        System.out.println("Altura: " + height + " polegadas");
        System.out.println("Peso: " + weight + " libras");
        System.out.printf("Índice de Massa Corporal (BMI): %.1f\n", person.calculateBMI());
        System.out.println("Frequência cardíaca máxima: " + person.calculateMaxHeartRate() + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + person.calculateTargetHeartRate());

        printBMITable();
        scanner.close();
    }
}
 {
    
}
