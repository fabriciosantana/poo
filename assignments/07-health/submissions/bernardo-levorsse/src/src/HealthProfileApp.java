import java.util.Scanner;
import java.time.LocalDate;

class HealthProfile {
    // ===== Atributos privados =====
    private String firstName;
    private String lastName;
    private char gender;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private double heightInInches;
    private double weightInPounds;

    // ===== Construtor =====
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

    // ===== Getters e Setters =====
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

    // ===== Métodos de cálculo =====
    public int calculateAge() {
        LocalDate hoje = LocalDate.now();
        int idade = hoje.getYear() - yearOfBirth;

        // Ajusta se ainda não fez aniversário este ano
        if (hoje.getMonthValue() < monthOfBirth || 
            (hoje.getMonthValue() == monthOfBirth && hoje.getDayOfMonth() < dayOfBirth)) {
            idade--;
        }
        return idade;
    }

    public int calculateMaxHeartRate() {
        return 220 - calculateAge();
    }

    public String calculateTargetHeartRate() {
        int maxHR = calculateMaxHeartRate();
        int minTarget = (int)(maxHR * 0.50);
        int maxTarget = (int)(maxHR * 0.85);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }

    public double calculateBMI() {
        return (weightInPounds * 703) / (heightInInches * heightInInches);
    }
}

public class HealthProfileApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ===== Entrada de dados =====
        System.out.print("Digite seu primeiro nome: ");
        String firstName = sc.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = sc.nextLine();

        System.out.print("Digite seu gênero (M/F): ");
        char gender = sc.nextLine().toUpperCase().charAt(0);

        System.out.print("Digite sua data de nascimento (dia mês ano separados por espaço): ");
        int day = sc.nextInt();
        int month = sc.nextInt();
        int year = sc.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double height = sc.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weight = sc.nextDouble();

        // ===== Cria objeto =====
        HealthProfile perfil = new HealthProfile(firstName, lastName, gender,
                                                 day, month, year, height, weight);

        // ===== Saída =====
        System.out.println("\n=== Perfil de Saúde ===");
        System.out.println("Nome: " + perfil.getFirstName() + " " + perfil.getLastName());
        System.out.println("Gênero: " + (perfil.getGender() == 'M' ? "Masculino" : "Feminino"));
        System.out.printf("Data de nascimento: %02d/%02d/%d%n", 
                          perfil.getDayOfBirth(), perfil.getMonthOfBirth(), perfil.getYearOfBirth());
        System.out.println("Idade: " + perfil.calculateAge() + " anos");
        System.out.println("Altura: " + perfil.getHeightInInches() + " polegadas");
        System.out.println("Peso: " + perfil.getWeightInPounds() + " libras");
        System.out.printf("Índice de Massa Corporal (BMI): %.1f%n", perfil.calculateBMI());
        System.out.println("Frequência cardíaca máxima: " + perfil.calculateMaxHeartRate() + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + perfil.calculateTargetHeartRate());

        // ===== Tabela BMI =====
        System.out.println("\n=== Tabela de Referência do BMI ===");
        System.out.println("Menos de 18.5  : Abaixo do peso");
        System.out.println("18.5 – 24.9    : Peso normal");
        System.out.println("25.0 – 29.9    : Sobrepeso");
        System.out.println("30.0 ou mais   : Obesidade");

        sc.close();
    }
}
