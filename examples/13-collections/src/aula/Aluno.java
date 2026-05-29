public class Aluno implements Comparable<Aluno> {
  private String nome;
  private double nota;

  public Aluno (String s){
    this.nome = s;
    this.nota = 10.0D;
  }

  public double getNotaAluno(){
    return this.nota;
  }
  
  @Override
  public String toString(){
    return "Nome do meu aluno: " + this.nome + " | " + "Nota: " + this.nota;
  }

  @Override
  public int compareTo(Aluno outroAluno) {
    return this.nome.compareTo(outroAluno.nome);
  }
}