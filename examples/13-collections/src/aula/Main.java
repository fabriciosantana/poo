import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args) {

      ArrayList<Aluno> alunos = new ArrayList<>();
      Aluno aluno1 = new Aluno("Fabricio");
      Aluno aluno2 = new Aluno("Bianca");
      Aluno aluno3 = new Aluno("Elane");
      
      alunos.add(new Aluno("Fabricio"));
      alunos.add(aluno1);
      alunos.add(aluno2);
      alunos.add(aluno3);

      for (int i = 0; i < alunos.size(); i++) {
        Aluno alunoAtual = alunos.get(i);
        System.out.println(alunoAtual);
        System.out.println(alunoAtual.getNotaAluno());
      }

      Map<String, Aluno> mapaAlunos = new HashMap<>();
      
      mapaAlunos.put("001", aluno1);
      mapaAlunos.put("002", aluno2);
      mapaAlunos.put("003", aluno3);

      if (mapaAlunos.containsKey("004")){
        Aluno alunoEncontrado = mapaAlunos.get("004");
        System.out.println("Aluno encontrado: " + alunoEncontrado);
      } else {
        System.out.println("Aluno não encontrado");
      }

      for (String chave : mapaAlunos.keySet()) {
        Aluno alunoAtual = mapaAlunos.get(chave);
        System.out.println("Chave: " + chave + " | " + alunoAtual);
      }

      Map<String, List<Aluno>> mapaAlunos2 = new LinkedHashMap<>();
      mapaAlunos2.put("Turma B", alunos);
      mapaAlunos2.put("Turma A", alunos);
      
      for(String chave : mapaAlunos2.keySet()){
        List<Aluno> alunosDaTurma = mapaAlunos2.get(chave);
        System.out.println("Turma: " + chave);
        for (Aluno aluno : alunosDaTurma) {
          System.out.println(aluno);
        }
      } 
  }
}