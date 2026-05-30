import java.util.Arrays;

public class GradeAnalyzer{

    public static double calculateAverage(int[] grades){
        int sum = 0;
        
        for(int grade : grades){
            sum += grade;
        }

        return (double) sum / grades.length;
    }

    public static int findHighestGrade(int[] grades){
        if(grades.length == 0){
            throw new IllegalArgumentException("O array não pode estar vazio.");
        }

        int highestGrade = 0;
        
        for(int grade : grades){
            if(grade > highestGrade){
                highestGrade = grade;
            }
        }

        return highestGrade;
    }

    public static int findLowestGrade(int[] grades){
        if(grades.length == 0){
            throw new IllegalArgumentException("O array não pode estar vazio.");
        }

        int lowestGrade = grades[0];
        
        for(int grade : grades){
            if(grade < lowestGrade){
                lowestGrade = grade;
            }
        }

        return lowestGrade;
    }

    public static int countGradesAtOrAboveAverage(int[] grades){
        if(grades.length == 0){
            throw new IllegalArgumentException("O array não pode estar vazio.");
        }

        double average = calculateAverage(grades);
        int qnd = 0;

        for(int grade : grades){
            if(grade >= average){
                qnd++;
            }
        }
        
        return qnd;
    }

    public static int[] calculateFrequency(int[] grades){
        int[] qnd = new int[11];

        for(int i = 0; i < grades.length; i++){
            int idx = grades[i] / 10;
            qnd[idx]+=1;
        }

        return qnd;
    }
}