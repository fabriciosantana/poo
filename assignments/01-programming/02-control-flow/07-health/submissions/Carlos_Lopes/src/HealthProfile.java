import java.util.Scanner;
//02-02
public class HealthProfile {
    //Atributos da Classe
    private String firstName;
    private String lastName;
    private char gender;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private double heightInInches;
    private double weightInPounds;
    public int currentYear = 2024;

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

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int currentYear =  2026;

        //Inserção de Dados do Individuo
        System.out.println("Digite seu Primeiro Nome: ");
        String firstName = scanner.nextLine();

        System.out.println("Digite seu Sobrenome: ");
        String lastName = scanner.nextLine();

        System.out.println("Digite seu Gênero (M/F): ");
        char gender = scanner.nextLine().charAt(0);

        System.out.print("Digite sua data de Nascimento (dia, mês e ano separados por espaço):  ");
        int dayOfBirth = scanner.nextInt();
        int monthOfBirth = scanner.nextInt();
        int yearOfBirth = scanner.nextInt();

        System.out.println("Digite sua altura em polegadas: ");
        double heightInInches = scanner.nextInt();

        System.out.println("Digite seu peso em libras: ");
        double weightInPounds = scanner.nextInt();

        //Criando Objeto Pessoa
        HealthProfile pessoa = new HealthProfile(firstName, lastName, gender, dayOfBirth, monthOfBirth, yearOfBirth, heightInInches, weightInPounds);

        //Utilização dos métodos
        int Idade = pessoa.calculateAge(currentYear);
        int MaxRate = pessoa.calculateMaxHeartRate(Idade);
        double BMI = pessoa.calculateBMI(weightInPounds, heightInInches);

        //Apresentação dos Resultados para o usuário
        System.out.println("Nome: "+ pessoa.getFirstName()+" "+pessoa.getLastName());
        if (pessoa.getGender() == 'M' || pessoa.getGender() == 'm') {
            System.out.println("Gênero: Masculino");
        }else if (pessoa.getGender() == 'F' || pessoa.getGender() == 'f') {
            System.out.println("Gênero: Feminino");
        } else {
            System.out.println("Gênero: Não informado");
        }

        System.out.printf("Data de nascimento: %d/%02d/%d \n", pessoa.getDayOfBirth(), pessoa.getMonthOfBirth(), pessoa.getYearOfBirth());
        System.out.println("Idade: "+Idade);
        System.out.println("Altura: "+pessoa.getHeightInInches());
        System.out.println("Peso: "+pessoa.getWeightInPounds());
        System.out.printf("Índice de massa corporal (BMI): %.1f \n", BMI);
        System.out.println("Frequência cardíaca máxima: "+MaxRate+" bpm");
        pessoa.calculateTargetHeartRate(MaxRate);

        // Tabela de BMI
        System.out.println("--------------------");
        System.out.println("Classificação de BMI");
        System.out.println(" <18.5 = Abaixo do peso");
        System.out.println(" 18.5 - 24.9 = Peso normal");
        System.out.println(" 25.0 - 29.9 = Sobrepeso");
        System.out.println(" >30.0 = Obesidade");
        System.out.println("--------------------");

    }

    //Métodos Essenciais
    public int calculateAge(int currentYear){
        int Idade = currentYear -  yearOfBirth;
        return Idade;
    }

    public int calculateMaxHeartRate(int Idade){
        int MaxRate = 220 - Idade; 
        return MaxRate;
    }

    public void calculateTargetHeartRate(int MaxRate){
        double MaxFrequence = MaxRate * 0.85;
        double MinFrequence = MaxRate * 0.50;
        System.out.println("Faixa de frequência cardíaca alvo: " + MinFrequence + " bpm - " + MaxFrequence + " bpm");
    }

     public double calculateBMI(double weightInPounds, double heightInInches){
        double BMI = (weightInPounds * 703)/(heightInInches * heightInInches);
        return BMI;
    }

    //Getters e Setters
    public String getFirstName() {return firstName; }
    public String getLastName() {return lastName; }
    public char getGender() {return gender; }
    public int getDayOfBirth() {return dayOfBirth; }
    public int getMonthOfBirth() {return monthOfBirth; }
    public int getYearOfBirth() {return yearOfBirth; }
    public double getHeightInInches() {return heightInInches; }
    public double getWeightInPounds() {return weightInPounds; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setGender(char gender) { this.gender = gender; }
    public void setDayOfBirth(int dayOfBirth) { this.dayOfBirth = dayOfBirth; }
    public void setMonthOfBirth(int monthOfBirth) { this.monthOfBirth = monthOfBirth; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }
    public void setHeightInInches(double heightInInches) { this.heightInInches = heightInInches; }
    public void setWeightInPounds(double weightInPounds) { this.weightInPounds = weightInPounds; }


}