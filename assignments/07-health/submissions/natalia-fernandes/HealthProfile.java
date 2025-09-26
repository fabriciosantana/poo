import java.util.Scanner;
import java.time.LocalDate;

public class HealthProfile {
    // Atributos privados
    private String firstName;
    private String lastName;
    private char gender;              // 'M' ou 'F'
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private double heightInInches;    // altura em polegadas
    private double weightInPounds;    // peso em libras

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

    // ======= Métodos solicitados =======

    /**
     * Calcula a idade com base no ano corrente passado e ajusta
     * considerando mês/dia usando a data atual do sistema.
     */
    public int calculateAge(int currentYear) {
        // Idade base apenas com o ano
        int age = currentYear - yearOfBirth;

        // Ajuste com mês/dia (usa data atual para virar o ano corretamente)
        LocalDate today = LocalDate.now();
        boolean birthdayYet =
            (today.getMonthValue() > monthOfBirth) ||
            (today.getMonthValue() == monthOfBirth && today.getDayOfMonth() >= dayOfBirth);

        if (!birthdayYet) {
            age--;
        }
        return age;
    }

    /** Frequência Cardíaca Máxima = 220 - idade */
    public int calculateMaxHeartRate(int currentYear) {
        return 220 - calculateAge(currentYear);
    }

    /** Retorna a faixa alvo "min bpm - max bpm" (50% a 85% do máximo) */
    public String calculateTargetHeartRate(int currentYear) {
        int max = calculateMaxHeartRate(currentYear);
        int minTarget = (int)Math.round(max * 0.50);
        int maxTarget = (int)Math.round(max * 0.85);
        return minTarget + " bpm - " + maxTarget + " bpm";
    }

    /** BMI = (peso(lbs) * 703) / (altura(in)^2) */
    public double calculateBMI() {
        if (heightInInches <= 0) return 0.0;
        return (weightInPounds * 703.0) / (heightInInches * heightInInches);
    }

    // ======= Programa principal dentro da própria classe =======
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String first = sc.nextLine().trim();

        System.out.print("Digite seu sobrenome: ");
        String last = sc.nextLine().trim();

        System.out.print("Digite seu gênero (M/F): ");
        char gen = sc.nextLine().trim().isEmpty() ? 'M' : sc.nextLine().trim().charAt(0); // fallback
        // Correção: se a leitura acima pegou vazio, peça novamente
        if (gen != 'M' && gen != 'm' && gen != 'F' && gen != 'f') {
            // Se a primeira leitura veio vazia, leia de novo corretamente
            String gline = ("" + gen).trim();
            if (gline.isEmpty()) {
                System.out.print("Digite seu gênero (M/F): ");
                gline = sc.nextLine().trim();
            }
            gen = gline.isEmpty() ? 'M' : gline.charAt(0);
        }

        System.out.print("Digite sua data de nascimento (dia mês ano): ");
        int day = sc.nextInt();
        int month = sc.nextInt();
        int year = sc.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double height = sc.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weight = sc.nextDouble();

        HealthProfile hp = new HealthProfile(first, last, gen, day, month, year, height, weight);

        int currentYear = LocalDate.now().getYear();
        int age = hp.calculateAge(currentYear);
        int maxHR = hp.calculateMaxHeartRate(currentYear);
        String targetRange = hp.calculateTargetHeartRate(currentYear);
        double bmi = hp.calculateBMI();

        String genderStr = (Character.toUpperCase(hp.getGender()) == 'F') ? "Feminino" : "Masculino";

        System.out.println("\n--- Perfil de Saúde ---");
        System.out.println("Nome: " + hp.getFirstName() + " " + hp.getLastName());
        System.out.printf("Gênero: %s%n", genderStr);
        System.out.printf("Data de nascimento: %02d/%02d/%d%n", hp.getDayOfBirth(), hp.getMonthOfBirth(), hp.getYearOfBirth());
        System.out.printf("Idade: %d anos%n", age);
        System.out.printf("Altura: %.0f polegadas%n", hp.getHeightInInches());
        System.out.printf("Peso: %.0f libras%n", hp.getWeightInPounds());
        System.out.printf("Índice de Massa Corporal (BMI): %.1f%n", bmi);
        System.out.printf("Frequência cardíaca máxima: %d bpm%n", maxHR);
        System.out.printf("Faixa de frequência cardíaca alvo: %s%n", targetRange);

        // Tabela de referência do BMI
        System.out.println("\n--- Tabela de Referência do BMI ---");
        System.out.println("BMI\t\tClassificação");
        System.out.println("Menos de 18.5\tAbaixo do peso");
        System.out.println("18.5 – 24.9\tPeso normal");
        System.out.println("25.0 – 29.9\tSobrepeso");
        System.out.println("30.0 ou mais\tObesidade");

        sc.close();
    }
}
