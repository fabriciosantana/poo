import java.util.Scanner;
import java.util.Calendar;

public class HealthProfileTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        System.out.print("Digite seu primeiro nome: ");
        String firstName = input.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String lastName = input.nextLine();

        System.out.print("Digite seu gênero (M/F): ");
        char gender = input.next().toUpperCase().charAt(0);

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();

        System.out.print("Digite sua altura em polegadas: ");
        double height = input.nextDouble();

        System.out.print("Digite seu peso em libras: ");
        double weight = input.nextDouble();

        HealthProfile profile = new HealthProfile(firstName, lastName, gender, day, month, year, height, weight);

        int age = profile.calculateAge(currentYear);
        int maxHR = profile.calculateMaxHeartRate(age);

        System.out.println("\n--- PERFIL DE SAÚDE ---");
        System.out.printf("Nome: %s %s%n", profile.getFirstName(), profile.getLastName());
        System.out.printf("Gênero: %s%n", (profile.getGender() == 'M' ? "Masculino" : "Feminino"));
        System.out.printf("Data de nascimento: %02d/%02d/%d%n",
                profile.getDayOfBirth(), profile.getMonthOfBirth(), profile.getYearOfBirth());
        System.out.printf("Idade: %d anos%n", age);
        System.out.printf("Altura: %.1f polegadas%n", profile.getHeightInInches());
        System.out.printf("Peso: %.1f libras%n", profile.getWeightInPounds());
        System.out.printf("Índice de Massa Corporal (BMI): %.1f%n", profile.calculateBMI());
        System.out.printf("Frequência cardíaca máxima: %d bpm%n", maxHR);
        System.out.printf("Faixa de frequência cardíaca alvo: %s%n", profile.calculateTargetHeartRate(maxHR));

        System.out.println("\nVALORES DE REFERÊNCIA DO BMI");
        System.out.println("Abaixo do peso:  menos de 18.5");
        System.out.println("Peso normal:     entre 18.5 e 24.9");
        System.out.println("Sobrepeso:       entre 25.0 e 29.9");
        System.out.println("Obesidade:       30.0 ou mais");

        input.close();
    }
}