import java.util.Scanner;

class FrequenciaCardiaca {
    private String primeiroNome, sobrenome;
    private int dia, mes, ano;
    public FrequenciaCardiaca(String primeiroNome, String sobrenome, int dia, int mes, int ano) {
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

        public String getNome() {
        return primeiroNome + " " + sobrenome;
    }

        public String getDataNascimento() {
        return String.format("%02d/%02d/%d", dia, mes, ano);
    }

        public int getIdade() {
        return 2025 - ano;
    }

        public int getFrequenciaCardiacaMaxima() {
        return 220 - getIdade();
    }

        public String getFaixaFrequenciaCardiacaAlvo() {
        int freqMax = getFrequenciaCardiacaMaxima();
        return String.format("%d bpm - %d bpm", (int)(freqMax * 0.50), (int)(freqMax * 0.85));
    }
}

        public class MonitoramentoFrequenciaCardiaca {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String primeiroNome = scanner.nextLine();
        System.out.print("Sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Data de nascimento (dia mês ano): ");
        int dia = scanner.nextInt();
        int mes = scanner.nextInt();
        int ano = scanner.nextInt();

        FrequenciaCardiaca pessoa = new FrequenciaCardiaca(primeiroNome, sobrenome, dia, mes, ano);
        System.out.println("\nNome: " + pessoa.getNome());
        System.out.println("Data de nascimento: " + pessoa.getDataNascimento());
        System.out.println("Idade: " + pessoa.getIdade() + " anos");
        System.out.println("Frequência cardíaca máxima: " + pessoa.getFrequenciaCardiacaMaxima() + " bpm");
        System.out.println("Faixa de frequência cardíaca alvo: " + pessoa.getFaixaFrequenciaCardiacaAlvo());

        scanner.close();
    }
}
