
import java.util.Arrays;

public class Atendimento{

    private static int contadorAtendimento;

    private int idAtendimento;

    private Paciente paciente;
    private Procedimento[] procedimentos;
    private int idProcedimentoAdicionado;

    private Pagamento[] pagamento;
    private double percentualTotalPagamento = 0.0D;
    private double valorTotalPagamento = 0.0D;

    public Atendimento(){
        contadorAtendimento++;
        idAtendimento = contadorAtendimento;
    }

    public Atendimento(int qtdProcedimentos){
        this();
        this.procedimentos = new Procedimento[qtdProcedimentos];
        this.idProcedimentoAdicionado = 0;
    }

    public Paciente getPaciente(){
        return this.paciente;
    }

    public void setPaciente(Paciente p){
        this.paciente = p;
    }

    public void faturarAtendimento(){
        
        double valorFatura = calcularValorTotalProcedimentos();

        if (this.percentualTotalPagamento == 100.0D)
            for (Pagamento p: this.pagamento)
                valorTotalPagamento += p.pagar(valorFatura);
    }

    public void adicionarProcedimento(Procedimento p){
        this.procedimentos[this.idProcedimentoAdicionado] = p;
        this.idProcedimentoAdicionado++;
    }

    public void adicionarPagamento(Pagamento... pagamento) throws Exception {

        if (pagamento != null){
            for (Pagamento p: pagamento){
                this.percentualTotalPagamento += p.percentualPagamento;
            }

            if (this.percentualTotalPagamento != 100.0D)
                throw new Exception("Os meios de pagamento devem totalizar 100%");
            else
                this.pagamento = pagamento;                
        }
    }

    private double calcularValorTotalProcedimentos(){
        
        double valorTotal = 0.0D;        

        for (Procedimento procedimentoAtual : this.procedimentos) 
            valorTotal += procedimentoAtual.getValor();

        return valorTotal;
    }

    @Override
    public String toString(){

        return "ID Atendimento: " + this.idAtendimento + "\n" +
                "Paciente: " + this.paciente.nome + "\n" + 
                "Procedimentos: " + Arrays.toString(this.procedimentos) + "\n" +
                "Valor dos Procedimentos: R$ " + calcularValorTotalProcedimentos() + "\n" +
                "Pagamento: R$ " + this.valorTotalPagamento + " " + Arrays.toString(this.pagamento) + "\n";
    }
}