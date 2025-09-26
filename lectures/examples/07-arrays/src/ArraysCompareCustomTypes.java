import java.util.Arrays;
import java.util.Comparator;

public class ArraysCompareCustomTypes {
    public static void main(String[] args) {

        Student[] alunos = {new Student(4, "Fabricio"), new Student(2, "Yuri")};
        
        Arrays.sort(alunos, new StudentComparator());
        System.out.println(Arrays.toString(alunos));
    }   
}

class Student {

    private final int matricula;
    private final String nome;

    public int getMatricula() {return this.matricula;}
    public String getNome() {return this.nome;}

    public Student(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.matricula + " - " + this.nome; 
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student other = (Student) obj;
        return this.matricula == other.matricula && this.nome.equals(other.nome);
    }
}

class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student e1, Student e2) {
        if (e1.getMatricula() > e2.getMatricula())
            return 1;
        else if (e1.getMatricula() == e2.getMatricula())
            return 0;
        else 
            return -1;
    }
}
