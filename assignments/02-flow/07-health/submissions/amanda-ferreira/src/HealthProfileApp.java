import java.time.LocalDate;
import java.util.Scanner;

public class HealthProfileApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu primeiro nome: ");
        String name = scanner.next();
        System.out.print("Digite seu sobrenome: ");
        String lastName = scanner.next();
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
        System.out.println();

        HealthProfile person = new HealthProfile(name, lastName, gender, day, month, year, height, weight);
        int age = person.calculateAge(LocalDate.now().getYear());
        int max = person.calculateMaxHeartRate();
        int[] target = person.calculateTargetHeartRate();
        double bmi = person.calculateBMI();

        System.out.println("Nome: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Gênero: " + (person.getGender() == 'M' ? "Masculino" : "Feminino"));
        System.out.printf("Data de nascimento: %02d/%02d/%d%n", person.getDayOfBirth(), person.getMonthOfBirth(), person.getYearOfBirth());
        System.out.println("Idade: " + age + " anos");
        System.out.printf("Altura: %.0f polegadas%n", person.getHeightInInches());
        System.out.printf("Peso: %.0f libras%n", person.getWeightInPounds());
        System.out.printf("Índice de Massa Corporal (BMI): %.1f%n", bmi);
        System.out.println("Frequência cardíaca máxima: " + max + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + target[0] + " bpm - " + target[1] + " bpm");
        System.out.println();
        System.out.println("      BMI          Classificação  ");
        System.out.println(" ---------------------------------");
        System.out.println(" Menos de 18.5     Abaixo do peso  ");
        System.out.println(" 18.5 - 24.9       Peso normal     ");
        System.out.println(" 25.0 - 29.9       Sobrepeso       ");
        System.out.println(" 30.0 ou mais      Obesidade       ");
        System.out.println();
        scanner.close();
    }
}