import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = sc.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = sc.nextLine();

        System.out.print("Digite seu gênero (M/F): ");
        char gender = sc.nextLine().toUpperCase().charAt(0);

        System.out.print("Digite sua data de nascimento (dia mês ano): ");
        int day = sc.nextInt();
        int month = sc.nextInt();
        int year = sc.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double height = sc.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weight = sc.nextDouble();

        HealthProfile person = new HealthProfile(firstName, lastName, gender, day, month, year, height, weight);

        System.out.println("\n--- Informações do Paciente ---");
        System.out.println("Nome: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Gênero: " + (person.getGender() == 'M' ? "Masculino" : "Feminino"));
        System.out.println("Data de nascimento: " + person.getDayOfBirth() + "/" + person.getMonthOfBirth() + "/" + person.getYearOfBirth());
        System.out.println("Idade: " + person.calculateAge(2025) + " anos");
        System.out.println("Altura: " + person.getHeightInInches() + " polegadas");
        System.out.println("Peso: " + person.getWeightInPounds() + " libras");
        System.out.println("Índice de Massa Corporal (BMI): " + person.calculateBMI());
        System.out.println("Frequência cardíaca máxima: " + person.calculateMaxHeartRate() + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + person.calculateTargetHeartRate());

        System.out.println("\n--- Tabela de Referência do BMI ---");
        System.out.println("| BMI           | Classificação         |");
        System.out.println("|---------------|----------------------|");
        System.out.println("| Menos de 18.5 | Abaixo do peso       |");
        System.out.println("| 18.5 – 24.9   | Peso normal          |");
        System.out.println("| 25.0 – 29.9   | Sobrepeso            |");
        System.out.println("| 30.0 ou mais  | Obesidade            |");
    }
}