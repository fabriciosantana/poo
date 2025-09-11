import java.util.Scanner;
import java.time.LocalDate;

class HealthProfile {
    private String firstName, lastName;
    private char gender;
    private int day, month, year;
    private double heightInInches, weightInPounds;

    public HealthProfile(String firstName, String lastName, char gender, 
                         int day, int month, int year, 
                         double heightInInches, double weightInPounds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.day = day;
        this.month = month;
        this.year = year;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        int age = today.getYear() - year;
        if (today.getMonthValue() < month || 
            (today.getMonthValue() == month && today.getDayOfMonth() < day)) {
            age--;
        }
        return age;
    }

    public int getMaxHeartRate() {
        return 220 - getAge();
    }

    public int[] getTargetHeartRate() {
        int max = getMaxHeartRate();
        return new int[]{(int)(max * 0.5), (int)(max * 0.85)};
    }

    public double calculateBMI() {
        return (weightInPounds * 703) / (heightInInches * heightInInches);
    }

    public String getGenderFull() {
        return (gender == 'M' || gender == 'm') ? "Masculino" : "Feminino";
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getBirthDate() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }

    public double getHeight() {
        return heightInInches;
    }

    public double getWeight() {
        return weightInPounds;
    }
}

public class HealthProfileApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = sc.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = sc.nextLine();

        System.out.print("Digite seu gênero (M/F): ");
        char gender = sc.next().charAt(0);

        System.out.print("Digite sua data de nascimento (dia mês ano): ");
        int day = sc.nextInt();
        int month = sc.nextInt();
        int year = sc.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double height = sc.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weight = sc.nextDouble();

        HealthProfile patient = new HealthProfile(firstName, lastName, gender, day, month, year, height, weight);

        int age = patient.getAge();
        int maxRate = patient.getMaxHeartRate();
        int[] targetRate = patient.getTargetHeartRate();
        double bmi = patient.calculateBMI();

        System.out.println("\n=== Dados do Paciente ===");
        System.out.println("Nome: " + patient.getFullName());
        System.out.println("Gênero: " + patient.getGenderFull());
        System.out.println("Data de nascimento: " + patient.getBirthDate());
        System.out.println("Idade: " + age + " anos");
        System.out.println("Altura: " + patient.getHeight() + " polegadas");
        System.out.println("Peso: " + patient.getWeight() + " libras");
        System.out.printf("Índice de Massa Corporal (BMI): %.1f\n", bmi);
        System.out.println("Frequência cardíaca máxima: " + maxRate + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + targetRate[0] + " bpm - " + targetRate[1] + " bpm");

        System.out.println("\n=== Tabela de Referência do BMI ===");
        System.out.println("Menos de 18.5\tAbaixo do peso");
        System.out.println("18.5 – 24.9\tPeso normal");
        System.out.println("25.0 – 29.9\tSobrepeso");
        System.out.println("30.0 ou mais\tObesidade");
    }
}
