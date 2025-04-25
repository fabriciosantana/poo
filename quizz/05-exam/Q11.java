import java.util.ArrayList;

class Aluno {
    private String nome;

    public Aluno(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Turma {
    private ArrayList<Aluno> alunos = new ArrayList<>();

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void listarAlunos() {
        for (Aluno a : alunos) {
            System.out.println(a.getNome());
        }
    }
}

public class Q11{
    public static void main(String[] args){
        Turma t = new Turma();
        t.adicionarAluno(new Aluno("João da Silva"));
        t.adicionarAluno(new Aluno("Maria Rita"));
        t.listarAlunos();
    }
}

