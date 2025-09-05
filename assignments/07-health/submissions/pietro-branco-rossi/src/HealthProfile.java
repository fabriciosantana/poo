import java.util.Scanner;
import java.time.Year;
import java.time.LocalDate;
import java.time.Period;

class App{
        public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = input.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = input.nextLine();

        System.out.print("Digite seu gênero (M/F): ");
        char gender = input.next().charAt(0);

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double height = input.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weight = input.nextDouble();

        input.close();

        //---- Criar um objeto HealthProfile  ----//
        HealthProfile pessoa = new HealthProfile(firstName, lastName, gender, day, month, year, height, weight);

        //---- Pega o ano atual para usar no cálculo da idade ----//
        int currentYear = Year.now().getValue();

        //---- Exibir as informações do usuário e os cálculos ----//
        System.out.println("\n--- Resultados ---");
        System.out.printf("Nome: %s %s%n", pessoa.getFirstName(), pessoa.getLastName());
        String genderString = (pessoa.getGender() == 'M' || pessoa.getGender() == 'F') ? "Masculino" : "Feminino";
        System.out.printf("Gênero: %s%n", genderString);
        System.out.printf("Data de nascimento: %d/%d/%d%n", pessoa.getDayOfBirth(), pessoa.getMonthOfBirth(), pessoa.getYearOfBirth());
        
        //----  Calcular e exibir a idade, a frequência cardíaca máxima e a faixa alvo ----//
        System.out.printf("Idade: %d anos%n", pessoa.calculateAge(currentYear));
        System.out.printf("Altura: %.0f polegada%n", pessoa.getHeightInInches());
        System.out.printf("Peso: %.0f libras%n", pessoa.getWeightInPounds());
        System.out.printf("Índice de Massa Corporal (BMI): %.1f%n", pessoa.calculateBMI());
        System.out.printf("Frequência cardíaca máxima: %d bpm%n", pessoa.calculateMaxHeartRate());
        System.out.printf("Faixa de frequência cardíaca alvo: %s%n", pessoa.calculateTargetHeartRate());

        // ---- Tabela BMI ----//
        System.out.println("\n| BMI           | Classificação            |");
        System.out.println("|---------------|--------------------------|");
        System.out.println("| Menos de 18.5 | Abaixo do peso           |");
        System.out.println("| 18.5 – 24.9   | Peso normal              |");
        System.out.println("| 25.0 – 29.9   | Sobrepeso                |");
        System.out.println("| 30.0 ou mais  | Obesidade                |");
    }
}


public class HealthProfile{
    private String firstName;
    private String lastName;
    private char gender;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private double heightInInches;
    private double weightInPounds;

    // ---- Construtor ---- //
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

        // ---- Métodos de Acesso (Get e Set) ---- //
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

        // ---- Métodos Públicos de Cálculo  ---- //

    public int calculateAge(int currentYear) {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(this.yearOfBirth, this.monthOfBirth, this.dayOfBirth);
        Period period = Period.between(birthday, today);
        return period.getYears();
    }

        public int calculateMaxHeartRate() {
        return 220 - calculateAge(Year.now().getValue());
    }

    public String calculateTargetHeartRate() {
        int maxRate = calculateMaxHeartRate();
        
        int lowerBound = (int) (maxRate * 0.50);
        int upperBound = (int) (maxRate * 0.85);
        
        return String.format("%d bpm - %d bpm", lowerBound, upperBound);
    }

    public double calculateBMI() {
        double BMI = (703 * (getWeightInPounds() / (getHeightInInches() * getHeightInInches())));
        return BMI;
    }
}