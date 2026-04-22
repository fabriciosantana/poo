import java.util.Scanner;

public class HeartRates{
    private String primeiroNome;
    private String ultimoNome;
    private int diaNascimento;
    private int mesNascimento;
    private int anoNascimento;
    
    //construtor
    HeartRates(String primeiroNome, String ultimoNome, int diaNascimento, int mesNascimento, int anoNascimento) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.diaNascimento = diaNascimento;
        this.mesNascimento = mesNascimento;
        this.anoNascimento = anoNascimento;
    }

    //getters
    public String getPrimeiroNome() {
        return primeiroNome;
    }
    public String getUltimoNome() {
        return ultimoNome;
    }
    public int getDiaNascimento() {
        return diaNascimento;
    }
    public int getMesNascimento() {
        return mesNascimento;
    }
    public int getAnoNascimento() {
        return anoNascimento;
    }

    //setters
    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }
    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }
    public void setDiaNascimento(int diaNascimento) {
        if(diaNascimento > 0) {
            this.diaNascimento = diaNascimento;
        } else {
            System.out.println("Dia Inválido!");
        }
    }
    public void setMesNascimento(int mesNascimento) {
        if(mesNascimento > 0) {
            this.mesNascimento = mesNascimento;
        } else {
            System.out.println("Mês Inválido!");
        }
    }
    public void setAnoNascimento(int anoNascimento) {
        if(anoNascimento > 0) {
            this.anoNascimento = anoNascimento;
        } else {
            System.out.println("Ano Inválido!");
        }
    }

    //funcionalidades:
    //calcular idade
    public int calcularIdade(int anoAtual) {
        return anoAtual - this.anoNascimento;
    }

    //calcular frequência cardíaca máxima
    public int calcularFrequenciaCardiacaMaxima(int anoAtual) {
        return 220 - calcularIdade(anoAtual);
    }

    //calcular frequência cardíaca alvo
    public String calcularFrequenciaCardiacaAlvo(int anoAtual) {
        double frequenciaCardiacaAlvoMin = (calcularFrequenciaCardiacaMaxima(anoAtual) * 0.5);
        double frequenciaCardiacaAlvoMax = (calcularFrequenciaCardiacaMaxima(anoAtual) * 0.85);
        return String.format("Frequência Cardíaca Alvo: %.2f - %.2f bpm", frequenciaCardiacaAlvoMin, frequenciaCardiacaAlvoMax);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu primeiro nome: ");
        String primeiroNome = scanner.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String ultimoNome = scanner.nextLine();

        System.out.print("Digite sua data de nascimento (dia, mês e ano separados por espaço): ");
        int diaNascimento = scanner.nextInt();
        int mesNascimento = scanner.nextInt();
        int anoNascimento = scanner.nextInt();

        HeartRates pessoa = new HeartRates(primeiroNome, ultimoNome, diaNascimento, mesNascimento, anoNascimento);

        System.out.println("Nome: " + pessoa.getPrimeiroNome() + " " + pessoa.getUltimoNome());
        System.out.println("Data de nascimento: " + pessoa.getDiaNascimento() + "/" + pessoa.getMesNascimento() + "/" + pessoa.getAnoNascimento());
        System.out.println("Idade: " + pessoa.calcularIdade(2026) + " anos");
        System.out.println("Frequência Cardíaca Máxima: " + pessoa.calcularFrequenciaCardiacaMaxima(2026) + " bpm");
        System.out.println(pessoa.calcularFrequenciaCardiacaAlvo(2026));
    }
}