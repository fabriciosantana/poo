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
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
    }

    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getGenderDescription() {
        return (gender == 'M' || gender == 'm') ? "Masculino" : "Feminino";
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public void setMonthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public double getHeightInInches() {
        return heightInInches;
    }

    public void setHeightInInches(double heightInInches) {
        this.heightInInches = heightInInches;
    }

    public double getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(double weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    
    public int calculateAge(int currentYear) {
        return currentYear - yearOfBirth;
    }

    public int calculateMaxHeartRate() {
        int age = calculateAge(java.time.Year.now().getValue());
        return 220 - age;
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

    public String getBMICategory() {
        double bmi = calculateBMI();
        if (bmi < 18.5) {
            return "Abaixo do peso";
        } else if (bmi < 25.0) {
            return "Peso normal";
        } else if (bmi < 30.0) {
            return "Sobrepeso";
        } else {
            return "Obesidade";
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            
            System.out.print("Digite seu primeiro nome: ");
            String firstName = scanner.nextLine();
            
            System.out.print("Digite seu sobrenome: ");
            String lastName = scanner.nextLine();
            
            System.out.print("Digite seu gênero (M/F): ");
            char gender = scanner.next().charAt(0);
            
            System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
            int day = scanner.nextInt();
            int month = scanner.nextInt();
            int year = scanner.nextInt();
            
            System.out.print("Digite sua altura em polegadas: ");
            double height = scanner.nextDouble();
            
            System.out.print("Digite seu peso em libras: ");
            double weight = scanner.nextDouble();

            
            HealthProfile patient = new HealthProfile(firstName, lastName, gender, 
                                                    day, month, year, height, weight);
            
            
            int currentYear = java.time.Year.now().getValue();
            
            
            int age = patient.calculateAge(currentYear);
            int maxHeartRate = patient.calculateMaxHeartRate();
            String targetHeartRate = patient.calculateTargetHeartRate();
            double bmi = patient.calculateBMI();
            String bmiCategory = patient.getBMICategory();
            
            
            System.out.println("\nNome: " + patient.getFirstName() + " " + patient.getLastName());
            System.out.println("Gênero: " + patient.getGenderDescription());
            System.out.printf("Data de nascimento: %02d/%02d/%d\n", 
                patient.getDayOfBirth(), patient.getMonthOfBirth(), patient.getYearOfBirth());
            System.out.println("Idade: " + age + " anos");
            System.out.println("Altura: " + patient.getHeightInInches() + " polegadas");
            System.out.println("Peso: " + patient.getWeightInPounds() + " libras");
            System.out.printf("Índice de Massa Corporal (BMI): %.1f\n", bmi);
            System.out.println("Frequência cardíaca máxima: " + maxHeartRate + " bpm");
            System.out.println("Faixa de frequência cardíaca alvo: " + targetHeartRate);
            System.out.println("\nTabela de referência do BMI:");
            System.out.println("BMI\t\tClassificação");
            System.out.println("Menos de 18.5\tAbaixo do peso");
            System.out.println("18.5 – 24.9\tPeso normal");
            System.out.println("25.0 – 29.9\tSobrepeso");
            System.out.println("30.0 ou mais\tObesidade");
            System.out.println("\nSua classificação BMI: " + bmiCategory);
        }
    }
}
