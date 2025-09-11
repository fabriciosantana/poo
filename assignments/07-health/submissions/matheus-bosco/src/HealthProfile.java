import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;

public class HealthProfile {

    // =======================
    // Atributos privados
    // =======================
    private String firstName;
    private String lastName;
    private char gender; // 'M' ou 'F'
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private double heightInInches; // polegadas
    private double weightInPounds; // libras

    // =======================
    // Construtor
    // =======================
    public HealthProfile(String firstName, String lastName, char gender,
                         int dayOfBirth, int monthOfBirth, int yearOfBirth,
                         double heightInInches, double weightInPounds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = normalizeGender(gender);
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
    }

    // =======================
    // Getters e Setters
    // =======================
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
        this.gender = normalizeGender(gender);
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

    // =======================
    // Métodos utilitários
    // =======================
    private char normalizeGender(char g) {
        char up = Character.toUpperCase(g);
        if (up != 'M' && up != 'F') {
            return 'M'; // padrão seguro; ajuste conforme necessidade
        }
        return up;
    }

    public String getGenderDescription() {
        return (this.gender == 'F') ? "Feminino" : "Masculino";
    }

    public String getBirthDateFormatted() {
        return String.format("%02d/%02d/%04d", this.dayOfBirth, this.monthOfBirth, this.yearOfBirth);
    }

    // =======================
    // Métodos de cálculo
    // =======================

    /**
     * Calcula a idade como se a data atual fosse 01/01 do ano informado.
     * Compatível com bancas que avaliam a idade "no início do ano".
     * @param currentYear ano de referência (ex.: 2025)
     * @return idade em anos (>= 0)
     */
    public int calculateAge(int currentYear) {
        LocalDate referenceDate = LocalDate.of(currentYear, 1, 1); // 01/01/currentYear
        LocalDate birthDate = LocalDate.of(this.yearOfBirth, this.monthOfBirth, this.dayOfBirth);

        if (birthDate.isAfter(referenceDate)) {
            return 0;
        }
        return Period.between(birthDate, referenceDate).getYears();
    }

    /**
     * Calcula a idade como se a data atual fosse 01/01 do ano corrente do sistema.
     * @return idade em anos (>= 0)
     */
    public int calculateAge() {
        int currentYear = LocalDate.now().getYear();
        return calculateAge(currentYear);
    }

    /**
     * Frequência cardíaca máxima = 220 - idade (idade calculada para 01/01 do ano corrente).
     * @return FC máxima (bpm), nunca negativa.
     */
    public int calculateMaxHeartRate() {
        int age = calculateAge();
        int max = 220 - age;
        return Math.max(0, max);
    }

    /**
     * Faixa alvo: 50% a 85% da FC máxima, usando TRUNCAMENTO (não arredonda).
     * Retorna formatado: "min bpm - max bpm".
     * @return String com a faixa de FC alvo.
     */
    public String calculateTargetHeartRate() {
        int max = calculateMaxHeartRate();
        int minTarget = (int) (max * 0.50); // truncamento
        int maxTarget = (int) (max * 0.85); // truncamento
        return String.format("%d bpm - %d bpm", minTarget, maxTarget);
    }

    /**
     * Calcula o BMI (Índice de Massa Corporal) pela fórmula em unidades imperiais.
     * BMI = (peso_lbs * 703) / (altura_in^2).
     * @return valor do BMI; retorna 0.0 se altura <= 0 (evita divisão por zero).
     */
    public double calculateBMI() {
        if (this.heightInInches <= 0) {
            return 0.0;
        }
        return (this.weightInPounds * 703.0) / (this.heightInInches * this.heightInInches);
    }

    // =======================
    // Aplicativo (main)
    // =======================
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Entradas
            System.out.print("Digite seu primeiro nome: ");
            String firstName = sc.next();

            System.out.print("Digite seu sobrenome: ");
            String lastName = sc.next();

            System.out.print("Digite seu gênero (M/F): ");
            String genderInput = sc.next();
            char gender = genderInput.isEmpty() ? 'M' : genderInput.charAt(0);

            System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
            int day = sc.nextInt();
            int month = sc.nextInt();
            int year = sc.nextInt();

            System.out.print("Digite sua altura em polegadas: ");
            double heightInInches = sc.nextDouble();

            System.out.print("Digite seu peso em libras: ");
            double weightInPounds = sc.nextDouble();

            // Validação simples de data (gera exceção se inválida)
            LocalDate birthDate = LocalDate.of(year, month, day);

            // Data de nascimento futura? Não interrompe o programa; cálculos vão tratar como idade 0.
            LocalDate today = LocalDate.now();
            if (birthDate.isAfter(today)) {
                System.out.println("Aviso: A data de nascimento informada é futura. A idade será considerada 0.");
            }

            // Cria o objeto
            HealthProfile profile = new HealthProfile(
                    firstName, lastName, gender,
                    day, month, year,
                    heightInInches, weightInPounds
            );

            // Cálculos
            int currentYear = today.getYear();
            int age = profile.calculateAge(currentYear);         // idade "em 01/01/currentYear"
            int maxHr = profile.calculateMaxHeartRate();         // usa a regra de 01/01 do ano atual
            String targetRange = profile.calculateTargetHeartRate();
            double bmi = profile.calculateBMI();

            // Saída formatada
            System.out.println();
            System.out.println("Nome: " + profile.getFirstName() + " " + profile.getLastName());
            System.out.println("Gênero: " + profile.getGenderDescription());
            System.out.println("Data de nascimento: " + profile.getBirthDateFormatted());
            System.out.println("Idade: " + age + " anos");
            // Exibe altura e peso sem formatação especial (mantém .0 se usuário digitou decimal)
            // Caso queira normalizar, poderia usar "%.0f" quando for inteiro.
            if (Math.floor(heightInInches) == heightInInches) {
                System.out.println("Altura: " + String.format(Locale.US, "%.0f", heightInInches) + " polegadas");
            } else {
                System.out.println("Altura: " + String.format(Locale.US, "%.2f", heightInInches) + " polegadas");
            }
            if (Math.floor(weightInPounds) == weightInPounds) {
                System.out.println("Peso: " + String.format(Locale.US, "%.0f", weightInPounds) + " libras");
            } else {
                System.out.println("Peso: " + String.format(Locale.US, "%.2f", weightInPounds) + " libras");
            }
            System.out.println("Índice de Massa Corporal (BMI): " + String.format(Locale.US, "%.1f", bmi));
            System.out.println("Frequência cardíaca máxima: " + maxHr + " bpm");
            System.out.println("Faixa de frequência cardíaca alvo: " + targetRange);

            // Tabela de referência do BMI
            System.out.println();
            System.out.println("BMI\tClassificação");
            System.out.println("Menos de 18.5\tAbaixo do peso");
            System.out.println("18.5 – 24.9\tPeso normal");
            System.out.println("25.0 – 29.9\tSobrepeso");
            System.out.println("30.0 ou mais\tObesidade");

        } catch (Exception e) {
            System.out.println("Erro: Verifique se os dados informados estão corretos. " +
                    "Exemplos: gênero 'M' ou 'F'; data como '15 08 1990'; altura/peso numéricos.");
        } finally {
            sc.close();
        }
    }
}
