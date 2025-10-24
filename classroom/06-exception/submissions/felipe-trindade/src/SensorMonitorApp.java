import java.util.Scanner;

public class SensorMonitorApp{
    public static void main(String[] args){
        SensorMonitor monitor = new SensorMonitor();
        int erros = 0;

        System.out.println("Digite as leituras no formato SENSOR_ID;TEMPERATURA");
        System.out.println("Escreva FIM quando quiser parar.");

        try(Scanner sc = new Scanner(System.in)){
            while(true){
                System.out.print("> ");
                String entrada = sc.nextLine();

                if(entrada.equalsIgnoreCase("FIM")){
                    break;
                }

                try{
                    monitor.addReading(entrada);
                    System.out.println("Leitura registrada.");
                }catch(InvalidReadingException e){
                    System.out.println("Erro: " + e.getMessage());
                    erros++;
                }
            }

            System.out.println("\n----- Resultado -----");
            System.out.println("Leituras válidas: " + monitor.totalReadings());
            System.out.println("Leituras com erro: " + erros);
            System.out.println("---------------------\n");

            System.out.print("Digite o ID do sensor para ver a média: ");
            String id = sc.nextLine();

            try{
                double media = monitor.averageFor(id);
                System.out.printf("Média do sensor %s: %.2f°C%n", id, media);
            }catch(SensorNotFoundException e){
                System.out.println("Erro: " + e.getMessage());
            }

        }finally{
            System.out.println("Programa encerrado.");
        }
    }
}