import java.util.Scanner;

public class GradeAnalyzer{

    public static double calculateAverage(int[]notasAlunos){

        int qtdsEstudantes = notasAlunos.length;
        float soma = 0;
        for(int i =0; i< notasAlunos.length; i++){
            soma = soma+ notasAlunos[i];
        }
        double mediaNotas = soma/qtdsEstudantes;

        return mediaNotas;
    }

    public static int findHighestGrade(int[]notasAlunos){

        int notaMaior=0;

        for(int i =0; i< notasAlunos.length; i++){
            if(notaMaior<notasAlunos[i]){
                notaMaior = notasAlunos[i];
            }else{

            }
        }

        return notaMaior;
    }

        public static int findLowestGrade(int[]notasAlunos){

        int notaMenor=notasAlunos[0] ;

        for(int i = 1; i< notasAlunos.length; i++){
            if(notaMenor>notasAlunos[i]){
                notaMenor = notasAlunos[i];
            }else{

            }
        }

        return notaMenor;

    }


    public static int countGradesAtOrAboveAverage(int[]notasAlunos){

        double media= calculateAverage(notasAlunos);
        int contador = 0;

        for(int i = 0; i< notasAlunos.length; i++){
            if(media<=notasAlunos[i]){
                contador++;
            }else{

            }
        }

        return contador;
    }

    public static int[] calculateFrequency (int[]notasAlunos){
        int[] frequency = new int[11];
             for(int i = 0; i< notasAlunos.length; i++){

            if (notasAlunos[i] >= 0 && notasAlunos[i] <= 100) {
                int indice = notasAlunos[i] / 10;
                frequency[indice]++;
        }
            }
             

        return frequency;
    }

    public static String formatFrequencyLine(int index, int frequency){

        if (index < 10) {
        int inicioFaixa = index * 10;
        int fimFaixa = inicioFaixa + 9;
            return String.format("%02d-%02d: %d", inicioFaixa, fimFaixa, frequency);
        } else {
            return String.format("100: %d", frequency);
            }

    }




    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de estudantes:");
        int qtdsEstudantes;
        do { 
            qtdsEstudantes = scanner.nextInt();
            if(qtdsEstudantes<=0){
                System.out.print("Digite uma quantidade de estudantes maior do que zero:");
            } 

        } while (qtdsEstudantes<=0);
        

        int[] notaAlunos = new int[qtdsEstudantes];

        for(int i = 0; i < qtdsEstudantes; i++){

            System.out.print("Digite a nota do estudante "+ (i+1)+": ");
            
            int nota;

            do { 
                nota =scanner.nextInt();        
            if(0>=nota && nota<=100){
                System.out.print("Digite uma nota entre 0 e 100:");
            } 

            } while (0>=nota && nota<=100);
            
            notaAlunos[i] = nota;

        }

        double media= calculateAverage(notaAlunos);
        System.out.printf("Média da turma: %.2f %n", media);

        int notaMaior = findHighestGrade(notaAlunos);
        System.out.printf("Maior nota: %d %n", notaMaior);

        int notaMenor = findLowestGrade(notaAlunos);
        System.out.printf("Menor nota: %d %n", notaMenor);

        int contador = countGradesAtOrAboveAverage(notaAlunos);
        System.out.printf("Notas acima ou iguais à média: %d %n", contador);

        int[] frequency =calculateFrequency(notaAlunos);

        for (int i = 0; i < frequency.length; i++) {

            String linhaFormatada = formatFrequencyLine(i, frequency[i]);
            System.out.println(linhaFormatada);
        }
        
    };
}