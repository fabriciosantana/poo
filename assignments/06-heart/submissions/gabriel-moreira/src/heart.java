import java.util.Scanner;

public class HeartRates {
    
    private String nome;
    private String sobrenome;
    private int diaNasc;
    private int mesNasc;
    private int anoNasc;

    
    public HeartRates(String nome, String sobrenome, int diaNasc, int mesNasc, int anoNasc) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.diaNasc = diaNasc;
        this.mesNasc = mesNasc;
        this.anoNasc = anoNasc;
    }

    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSobrenome() { return sobrenome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }

    public int getDiaNasc() { return diaNasc; }
    public void setDiaNasc(int diaNasc) { this.diaNasc = diaNasc; }

    public int getMesNasc() { return mesNasc; }
    public void setMesNasc(int mesNasc) { this.mesNasc = mesNasc; }

    public int getAnoNasc() { return anoNasc; }
    public void setAnoNasc(int anoNasc) { this.anoNasc = anoNasc; }

    
    public int calcularIdade(int anoAtual) {
        return anoAtual - anoNasc;
    }

    
    public int frequenciaMaxima(int anoAtual) {
        return 220 - calcularIdade(anoAtual);
    }

    
    public String frequenciaAlvo(int anoAtual) {
        int max = frequenciaMaxima(anoAtual);
        int minAlvo = (int) (max * 0.50);
        int maxAlvo = (int) (max * 0.85);
        return minAlvo + " - " + maxAlvo + " bpm";
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String nome = sc.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String sobrenome = sc.nextLine();

        System.out.print("Digite o dia de nascimento: ");
        int dia = sc.nextInt();

        System.out.print("Digite o mês de nascimento: ");
        int mes = sc.nextInt();

        System.out.print("Digite o ano de nascimento: ");
        int ano = sc.nextInt();

        System.out.print("Digite o ano atual: ");
        int anoAtual = sc.nextInt();

        HeartRates pessoa = new HeartRates(nome, sobrenome, dia, mes, ano);

        System.out.println("\n--- Dados do usuário ---");
        System.out.println("Nome: " + pessoa.getNome() + " " + pessoa.getSobrenome());
