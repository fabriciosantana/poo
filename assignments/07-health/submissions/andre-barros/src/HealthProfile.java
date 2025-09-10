import java.time.LocalDate;
import java.util.Scanner;

public class HealthProfile {
    // Atributos privados
    private String firstName;
    private String lastName;
    private char gender;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private double heightInInches;
    private double weightInPounds;

    // Construtor
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

    // Getters e Setters
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

    // Métodos de cálculo
    public int calculateAge(int currentYear) {
        int age = currentYear - this.yearOfBirth;

        LocalDate today = LocalDate.now();
        if (today.getYear() == currentYear) {
            if (today.getMonthValue() < this.monthOfBirth ||
                (today.getMonthValue() == this.monthOfBirth && today.getDayOfMonth() < this.dayOfBirth)) {
                age--;
            }
        }
        return age;
    }

    public int calculateMaxHeartRate() {
        int currentYear = LocalDate.now().getYear();
        return 220 - calculateAge(currentYear);
    }

    public String calculateTargetHeartRate() {
        int maxRate = calculateMaxHeartRate();
        int minTarget = (int) Math.round(maxRate * 0.50);
        int maxTarget = (int) Math.round(maxRate * 0.85);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }

    public double calculateBMI() {
        return (this.weightInPounds * 703) / (this.heightInInches * this.heightInInches);
    }

    // Programa principal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = sc.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = sc.nextLine();

        System.out.print("Digite seu gênero (M/F): ");
        char gender = sc.nextLine().toUpperCase().charAt(0);

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = sc.nextInt();
        int month = sc.nextInt();
        int year = sc.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double height = sc.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weight = sc.nextDouble();

        HealthProfile hp = new HealthProfile(firstName, lastName, gender, day, month, year, height, weight);

        int currentYear = LocalDate.now().getYear();

        System.out.println("\n--- Perfil de Saúde ---");
        System.out.println("Nome: " + hp.getFirstName() + " " + hp.getLastName());
        System.out.println("Gênero: " + (hp.getGender() == 'M' ? "Masculino" : "Feminino"));
        System.out.println("Data de nascimento: " + hp.getDayOfBirth() + "/" + hp.getMonthOfBirth() + "/" + hp.getYearOfBirth());
        System.out.println("Idade: " + hp.calculateAge(currentYear) + " anos");
        System.out.println("Altura: " + hp.getHeightInInches() + " polegadas");
        System.out.println("Peso: " + hp.getWeightInPounds() + " libras");
        System.out.printf("Índice de Massa Corporal (BMI): %.1f\n", hp.calculateBMI());
        System.out.println("Frequência cardíaca máxima: " + hp.calculateMaxHeartRate() + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + hp.calculateTargetHeartRate());

        System.out.println("\n--- Tabela de Referência do BMI ---");
        System.out.println("Menos de 18.5\tAbaixo do peso");
        System.out.println("18.5 – 24.9\tPeso normal");
        System.out.println("25.0 – 29.9\tSobrepeso");
        System.out.println("30.0 ou mais\tObesidade");

        sc.close();
    }
}
