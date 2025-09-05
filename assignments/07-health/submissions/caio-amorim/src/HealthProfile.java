import java.util.Scanner;
import java.time.LocalDate;

public class HealthProfile {
    private String firstName;
    private String lastName;
    private char gender; // 'M' ou 'F'
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private double heightInInches; // polegadas
    private double weightInPounds; // libras

    // Construtor
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

    // Getters e Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public char getGender() { return gender; }
    public void setGender(char gender) { this.gender = Character.toUpperCase(gender); }

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

    // Idade
    public int calculateAge(int currentYear) {
        LocalDate hoje = LocalDate.now();
        int idade = currentYear - yearOfBirth;
        if (hoje.getMonthValue() < monthOfBirth ||
           (hoje.getMonthValue() == monthOfBirth && hoje.getDayOfMonth() < dayOfBirth)) {
            idade--;
        }
        return idade;
    }

    // Frequência máxima
    public int calculateMaxHeartRate() {
        int currentYear = LocalDate.now().getYear();
        return 220 - calculateAge(currentYear);
    }

    // Frequência alvo
    public int[] calculateTargetHeartRate() {
        int max = calculateMaxHeartRate();
        int minTarget = (int)(max * 0.50);
        int maxTarget = (int)(max * 0.85);
        return new int[]{minTarget, maxTarget};
    }

    // BMI
    public double calculateBMI() {
        return (weightInPounds * 703.0) / (heightInInches * heightInInches);
    }

    // Método main dentro da classe
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = sc.nextLine().trim();

        System.out.print("Digite seu sobrenome: ");
        String lastName = sc.nextLine().trim();

        System.out.print("Digite seu gênero (M/F): ");
        char gender = sc.nextLine().trim().toUpperCase().charAt(0);

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = sc.nextInt();
        int month = sc.nextInt();
        int year = sc.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double heightInInches = sc.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weightInPounds = sc.nextDouble();

        // Cria o objeto
        HealthProfile hp = new HealthProfile(
                firstName, lastName, gender,
                day, month, year,
                heightInInches, weightInPounds
        );

        int currentYear = LocalDate.now().getYear();
        int age = hp.calculateAge(currentYear);
        int maxHR = hp.calculateMaxHeartRate();
        int[] targetHR = hp.calculateTargetHeartRate();
        double bmi = hp.calculateBMI();

        // Saída
        System.out.println();
        System.out.println("Nome: " + hp.getFirstName() + " " + hp.getLastName());
        System.out.println("Gênero: " + (hp.getGender() == 'F' ? "Feminino" : "Masculino"));
        System.out.println("Data de nascimento: " + String.format("%02d/%02d/%04d",
                hp.getDayOfBirth(), hp.getMonthOfBirth(), hp.getYearOfBirth()));
        System.out.println("Idade: " + age + " anos");
        System.out.println("Altura: " + String.format("%.0f", hp.getHeightInInches()) + " polegadas");
        System.out.println("Peso: " + String.format("%.0f", hp.getWeightInPounds()) + " libras");
        System.out.println("Índice de Massa Corporal (BMI): " + String.format("%.1f", bmi));
        System.out.println("Frequência cardíaca máxima: " + maxHR + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + targetHR[0] + " bpm - " + targetHR[1] + " bpm");

        System.out.println();
        System.out.println("BMI\tClassificação");
        System.out.println("Menos de 18.5\tAbaixo do peso");
        System.out.println("18.5 – 24.9\tPeso normal");
        System.out.println("25.0 – 29.9\tSobrepeso");
        System.out.println("30.0 ou mais\tObesidade");

        sc.close();
    }
}
