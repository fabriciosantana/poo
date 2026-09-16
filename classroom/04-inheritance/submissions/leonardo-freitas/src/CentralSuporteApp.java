public class CentralSuporteApp {
    public static void main(String[] argumentos) {
        SolicitacaoAtendimento incidente =
                new Incidente("INC-001", "Sistema indisponível", 5, 4);
        SolicitacaoAtendimento servico =
                new SolicitacaoServico("SRV-001", "Criar novos acessos", 35);

        CentralSuporte central = new CentralSuporte();
        central.processar(incidente);
        central.processar(servico);
    }
}
