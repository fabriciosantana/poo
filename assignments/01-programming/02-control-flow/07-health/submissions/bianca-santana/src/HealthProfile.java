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

    public String getFirstName(){
        return this.firstName;
    } 

    public String getLastName() {
        return this.lastName; 
    }

    public char getGender() { 
        return this.gender; 
    }

    public int getDayOfBirth() { 
        return this.dayOfBirth; 
    }

    public int getMonthOfBirth() { 
        return this.monthOfBirth; 
    }

    public int getYearOfBirth() {
        return this.yearOfBirth;
    }

    public double getHeightInInches() { 
        return this.heightInInches; 
    }

    public double getWeightInPounds() { 
        return this.weightInPounds; 
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setDayOfBirth(int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public void setMonthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setHeightInInches(double heightInInches) {
        this.heightInInches = heightInInches;
    }

    public void setWeightInPounds(double weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    public int calculateAge(int currentYear){
        int idade = currentYear - this.yearOfBirth;
        return idade;
    }

    public int calculateMaxHeartRate(){
        int FCmax = 220 - calculateAge(2026);

        return FCmax;
    }

    public String calculateTargetHeartRate(){
        int max = (int) (calculateMaxHeartRate() * 0.85);
        int min = (int) (calculateMaxHeartRate() * 0.5);

        return min + " bpm - " + max + " bpm";
    }

    public double calculateBMI() {
        double IMC = (this.weightInPounds * 703) / (this.heightInInches * this.heightInInches);
        
        return IMC;
}

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        System.out.printf("Digite seu primeiro nome: ");
        String nome = ler.nextLine();
        System.out.printf("Digite seu sobrenome: ");
        String sobrenome = ler.nextLine();
        System.out.printf("Digite seu gênero (M/F): ");
        char genero = ler.next().charAt(0);
        System.out.printf("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int dia = ler.nextInt();
        int mes = ler.nextInt();
        int ano = ler.nextInt();
        System.out.printf("Digite sua altura em polegadas: ");
        double altura = ler.nextDouble();
        System.out.printf("Digite seu peso em libras: ");
        double peso = ler.nextDouble();

        HealthProfile pessoa_1 = new HealthProfile(nome, sobrenome, genero, dia, mes, ano, altura, peso);

        String gener = (genero == 'M') ? "Masculino" : "Feminino";

        System.out.printf("Nome: %s %s%n", nome, sobrenome);
        System.out.printf("Gênero: %s%n", gener);
        System.out.printf("Data de nascimento: %02d/%02d/%d%n", dia, mes, ano );
        System.out.printf("Idade: %d%n", pessoa_1.calculateAge(2026));
        System.out.printf("Altura: %.2f polegadas%n", altura);
        System.out.printf("Peso: %.2f libras%n", peso);
        System.out.printf("Índice de Massa Corporal (BMI): %.2f%n", pessoa_1.calculateBMI());
        System.out.printf("Frequência cardíaca máxima: %d bpm%n", pessoa_1.calculateMaxHeartRate());
        System.out.printf("Faixa de frequência cardíaca alvo: %s%n", pessoa_1.calculateTargetHeartRate());

        System.out.println("\nVALORES DE IMC");
        System.out.println("Abaixo do peso: menos de 18.5");
        System.out.println("Normal:         entre 18.5 e 24.9");
        System.out.println("Sobrepeso:      entre 25 e 29.9");
        System.out.println("Obeso:          30 ou mais");
    }

}       
