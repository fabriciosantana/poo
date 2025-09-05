import java.util.Scanner;
import java.time.LocalDate;

public class HealthProfile{
    private String firstName;
    private String lastName;
    private char gender;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private double heightInInches;
    private double weightInPounds;

    public HealthProfile(String firstName, String lastName, char gender, int dayOfBirth, int monthOfBirth, int yearOfBirth, double heightInInches, double weightInPounds){
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
    public String getLastName() { return lastName; }
    public char getGender() { return gender; }
    public int getDayOfBirth() { return dayOfBirth; }
    public int getMonthOfBirth() { return monthOfBirth; }
    public int getYearOfBirth() { return yearOfBirth; }
    public double getHeightInInches() { return heightInInches; }
    public double getWeightInPounds() { return weightInPounds; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setGender(char gender) { this.gender = gender; }
    public void setDayOfBirth(int dayOfBirth) { this.dayOfBirth = dayOfBirth; }
    public void setMonthOfBirth(int monthOfBirth) { this.monthOfBirth = monthOfBirth; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }
    public void setHeightInInches(double heightInInches) { this.heightInInches = heightInInches; }
    public void setWeightInPounds(double weightInPounds) { this.weightInPounds = weightInPounds; }

    public int calculateAge(int currentYear){
        int age = currentYear - yearOfBirth;
        if (currentYear == LocalDate.now().getYear()) {
            LocalDate today = LocalDate.now();
            LocalDate birthdayThisYear = LocalDate.of(currentYear, monthOfBirth, dayOfBirth);
            if (today.isBefore(birthdayThisYear)) {
                age--;
            }
        }
        return age;
    }

    public int calculateMaxHeartRate() {
        int age2025 = calculateAge(2025);
        return 220 - age2025;
    }

    public String calculateTargetHeartRate() {
        int max = calculateMaxHeartRate();
        int minTarget = Math.round(max * 0.50f);
        int maxTarget = Math.round(max * 0.85f);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }

    public double calculateBMI() {
        if (heightInInches <= 0) return 0.0;
        return (weightInPounds * 703.0) / (heightInInches * heightInInches);
    }

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
        double heightIn = sc.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weightLb = sc.nextDouble();

        HealthProfile p = new HealthProfile(firstName, lastName, gender, day, month, year, heightIn, weightLb);

        int idade = p.calculateAge(LocalDate.now().getYear());
        int maxHR = p.calculateMaxHeartRate();
        String alvo = p.calculateTargetHeartRate();
        double bmi = p.calculateBMI();

        String generoTxt = (p.getGender() == 'M') ? "Masculino" : (p.getGender() == 'F' ? "Feminino" : "Não informado");

        System.out.println("\nNome: " + p.getFirstName() + " " + p.getLastName());
        System.out.println("Gênero: " + generoTxt);
        System.out.printf("Data de nascimento: %02d/%02d/%04d%n", p.getDayOfBirth(), p.getMonthOfBirth(), p.getYearOfBirth());
        System.out.println("Idade: " + idade + " anos");
        System.out.println("Altura: " + String.format("%.0f", p.getHeightInInches()) + " polegadas");
        System.out.println("Peso: " + String.format("%.0f", p.getWeightInPounds()) + " libras");
        System.out.println("Índice de Massa Corporal (BMI): " + String.format("%.1f", bmi));
        System.out.println("Frequência cardíaca máxima: " + maxHR + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + alvo);

        System.out.println("\n- Tabela de Referência do BMI -");
        System.out.println("BMI\t\tClassificação");
        System.out.println("Menos de 18.5\tAbaixo do peso");
        System.out.println("18.5 – 24.9\tPeso normal");
        System.out.println("25.0 – 29.9\tSobrepeso");
        System.out.println("30.0 ou mais\tObesidade");

        sc.close();
    }
}