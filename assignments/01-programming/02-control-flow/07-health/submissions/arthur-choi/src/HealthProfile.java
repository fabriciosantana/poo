import java.util.Scanner;

public class HealthProfile {
    private String firstName;
    private String lastName;
    private char gender;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private float heightInInches;
    private float weightInPounds;

    // construtor
    HealthProfile(String firstName, String lastName, char gender, int dayOfBirth, int monthOfBirth, int yearOfBirth, float heightInInches, float weightInPounds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
    }

    // getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    // setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDayOfBirth(int dayOfBirth) {
        if (dayOfBirth > 0) {
            this.dayOfBirth = dayOfBirth;
        } else {
            System.out.println("Dia Inválido!");
        }
    }

    public void setMonthOfBirth(int monthOfBirth) {
        if (monthOfBirth > 0) {
            this.monthOfBirth = monthOfBirth;
        } else {
            System.out.println("Mês Inválido!");
        }
    }

    public void setYearOfBirth(int yearOfBirth) {
        if (yearOfBirth > 0) {
            this.yearOfBirth = yearOfBirth;
        } else {
            System.out.println("Ano Inválido!");
        }
    }

    // funcionalidades:
    // calcular idade
    public int calcularIdade(int anoAtual) {
        return anoAtual - this.yearOfBirth;
    }

    // calcular frequência cardíaca máxima
    public int calcularFrequenciaCardiacaMaxima(int anoAtual) {
        return 220 - calcularIdade(anoAtual);
    }

    // calcular frequência cardíaca alvo
    public String calcularFrequenciaCardiacaAlvo(int anoAtual) {
        double frequenciaCardiacaAlvoMin = (calcularFrequenciaCardiacaMaxima(anoAtual) * 0.5);
        double frequenciaCardiacaAlvoMax = (calcularFrequenciaCardiacaMaxima(anoAtual) * 0.85);
        return String.format("Frequência Cardíaca Alvo: %.2f - %.2f bpm", frequenciaCardiacaAlvoMin,
                frequenciaCardiacaAlvoMax);
    }

    //calcular BMI
    public float calcularBMI() {
        float heightInMeters = this.heightInInches * 0.0254f;
        return this.weightInPounds * 0.453592f / (heightInMeters * heightInMeters);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String primeiroNome = scanner.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String ultimoNome = scanner.nextLine();

        System.out.print("Digite seu gênero (M/F): ");
        char genero = scanner.nextLine().charAt(0);

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int diaNascimento = scanner.nextInt();
        int mesNascimento = scanner.nextInt();
        int anoNascimento = scanner.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        float altura = scanner.nextFloat();

        System.out.print("Digite seu peso em libras: ");
        float peso = scanner.nextFloat();

        HealthProfile pessoa = new HealthProfile(primeiroNome, ultimoNome, genero, diaNascimento, mesNascimento, anoNascimento, altura, peso);
        System.out.printf("Nome: %s %s%n", pessoa.getFirstName(), pessoa.getLastName());
        System.out.printf("Gênero: %s%n", (genero == 'M' ? "Masculino" : "Feminino"));
        System.out.printf("Data de nascimento: %02d/%02d/%d%n", pessoa.getDayOfBirth(), pessoa.getMonthOfBirth(), pessoa.getYearOfBirth());
        System.out.printf("Idade: %d anos%n", pessoa.calcularIdade(2026));
        System.out.printf("Altura: %.2f polegadas%n", pessoa.heightInInches);
        System.out.printf("Peso: %.2f libras%n", pessoa.weightInPounds);
        System.out.printf("Índice de Massa Corporal (BMI): %.2f%n", pessoa.calcularBMI());
        System.out.printf("Frequência cardíaca máxima: %d bpm%n", pessoa.calcularFrequenciaCardiacaMaxima(2026));
        System.out.println(pessoa.calcularFrequenciaCardiacaAlvo(2026));
    }
}