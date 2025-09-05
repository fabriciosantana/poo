import java.util.Scanner;

public class HealthProfileApp {
    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Digite seu primeiro nome: ");
        String firstName = input.next();

        System.out.println("Digite seu sobrenome: ");
        String lastName = input.next();

        System.out.println("Digite seu gênero (M/F): ");
        char genero = input.next().charAt(0);

        System.out.println("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();

        System.out.println("Digite sua altura em polegadas: ");
        double height = input.nextDouble();

        System.out.println("Digite seu peso em libras: ");
        double weight = input.nextDouble();

        input.close();

        HealthProfile pessoa = new HealthProfile(firstName, lastName, genero, day, month, year, height, weight);
        
        int age = pessoa.calculateAge();
        int maxHeartRate = pessoa.calculateMaxHeartRate();
        int[] targetHeartRate = pessoa.calculateTargetHeartRate();
        double BMI = pessoa.calculateBMI();

        System.out.printf("Nome %s %s\n", pessoa.getFirstName(), pessoa.getLastName());
        if(genero == 'M' || genero == 'm'){
            System.out.println("Gênero: Masculino");
        }
        else{
            System.out.println("Gênero: Feminino");
        }
        System.out.printf("Data de nascimento: %d/%d/%d\n", pessoa.getDayOfBirth(), pessoa.getMonthOfBirth(), pessoa.getYearOfBirth());
        System.out.printf("Idade: %d anos\n", pessoa.calculateAge());
        System.out.printf("Altura: %.0f polegadas\n", pessoa.getHeightInInches());
        System.out.printf("Peso: %.0f libras\n", pessoa.getWeightInPounds());
        System.out.printf("Índice de Massa Corporal(BMI): %.1f\n", pessoa.calculateBMI());
        System.out.printf("Frequência cardíaca máxima: %d bpm\n", pessoa.calculateMaxHeartRate());
        System.out.printf("Faixa de frequência cardíaca máxima: %d bpm - %d bpm", pessoa.calculateTargetHeartRate()[0], pessoa.calculateTargetHeartRate()[1]);

        System.out.println("\n\nBMI\t\tClassificação");
        System.out.println("Menos de 18.5\tAbaixo do peso");
        System.out.println("18.5 – 24.9\tPeso normal");
        System.out.println("25.0 – 29.9\tSobrepeso");
        System.out.println("30.0 ou mais\tObesidade");
    }
}