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

    public HealthProfile(String firstName, String lastName, char gender, int day, int month, int year, double height, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dayOfBirth = day;
        this.monthOfBirth = month;
        this.yearOfBirth = year;
        this.heightInInches = height;
        this.weightInPounds = weight;
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
        int age = currentYear - yearOfBirth;

        return age;
    }

    public int calculateMaxHeartRate() {
        int age = calculateAge(2025);

        return 220 - age;
    }

    public String calculateTargetHeartRate() {
        int maxHeartRate = calculateMaxHeartRate();

        int min = (int) (maxHeartRate * 0.50);
        int max = (int) (maxHeartRate * 0.85);
        
        return String.format("%d bpm - %d bpm", min, max);
    } 

    public double calculateBMI() {
        return (weightInPounds * 703) / (heightInInches * heightInInches);
    }

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);

             System.out.println("Digite seu primeiro nome: ");
            String firstName = input.nextLine();

            System.out.println("Digite seu sobrenome: ");
            String lastName = input.nextLine();

            System.out.println("Digite seu gênero (M/F): ");
            char gender = input.nextLine().charAt(0);

            System.out.println("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
            int day = input.nextInt();
            int month = input.nextInt();
            int year = input.nextInt();

            System.out.println("Digite sua altura em polegadas: ");
            double height = input.nextDouble();

            System.out.println("Digite seu peso em libras: ");
            double weight = input.nextDouble();

            HealthProfile person = new HealthProfile(firstName, lastName, gender, day, month, year, height, weight);

            System.out.printf("Nome: %s %s%n", person.getFirstName(), person.getLastName());
            
            String genderText = (person.getGender() == 'M') ? "Masculino" : "Feminino";
            System.out.printf("Gênero: %s%n", genderText);

            System.out.printf("Data de nascimento: %d/%d/%d%n", person.getDayOfBirth(), person.getMonthOfBirth(), person.getYearOfBirth());

            System.out.printf("Idade: %d anos%n", person.calculateAge(2025));

            System.out.printf("Altura: %.0f polegadas%n", person.getHeightInInches());

            System.out.printf("Peso: %.0f libras%n", person.getWeightInPounds());

            System.out.printf("Índice de Massa Corporal (BMI): %.1f%n", person.calculateBMI());

            System.out.printf("Frequência cardíaca máxima: %d bpm%n", person.calculateMaxHeartRate());

            System.out.printf("Faixa de frequência cardíaca alvo: %s%n", person.calculateTargetHeartRate());
            
            // Exibir tabela de referência do BMI
            System.out.println("\nTabela de referência do BMI:");
            System.out.println("| BMI           | Classificação    |");
            System.out.println("|---------------|------------------|");
            System.out.println("| Menos de 18.5 | Abaixo do peso   |");
            System.out.println("| 18.5 – 24.9   | Peso normal      |");
            System.out.println("| 25.0 – 29.9   | Sobrepeso        |");
            System.out.println("| 30.0 ou mais  | Obesidade        |");
            
            input.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}