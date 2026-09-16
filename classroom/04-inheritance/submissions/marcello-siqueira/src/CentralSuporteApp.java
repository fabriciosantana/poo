public class CentralSuporteApp {

    public static void main(String[] argumentos) {
        CentralSuporte central = new CentralSuporte();

        SolicitacaoAtendimento incidente = new Incidente("INC-01", "Sistema fora do ar", 4, 5);
        SolicitacaoAtendimento servico = new SolicitacaoServico("SVC-01", "Novo acesso", 80);

        central.processar(incidente);
        central.processar(servico);

        central.processar(new Incidente("INC-02", "Níveis inválidos", -3, 9));
        central.processar(new SolicitacaoServico("SVC-02", "Teto da prioridade", 5000));
    }
}
