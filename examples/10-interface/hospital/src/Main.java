public class Main{
    public static void main(String[] args){
        
        Procedimento[] procedimentos = new Procedimento[3];

        procedimentos[0] = new Procedimento("Consulta", 100.0D);
        procedimentos[1] = new Procedimento("Exame de Imagem", 200.0D);
        procedimentos[2] = new Procedimento("Exame de Sangue", 150.0D);
        
        Paciente paciente = new Paciente("Fabricio");

        Atendimento atendimento = new Atendimento(3);

        atendimento.setPaciente(paciente);
        atendimento.adicionarProcedimento(procedimentos[0]);
        atendimento.adicionarProcedimento(procedimentos[1]);
        atendimento.adicionarProcedimento(procedimentos[2]);


        Atendimento atendimento2 = new Atendimento(2);

        atendimento2.setPaciente(paciente);
        atendimento2.adicionarProcedimento(procedimentos[2]);
        atendimento2.adicionarProcedimento(procedimentos[1]);


        Atendimento atendimento3 = new Atendimento(2);

        atendimento3.setPaciente(paciente);
        atendimento3.adicionarProcedimento(procedimentos[2]);
        atendimento3.adicionarProcedimento(procedimentos[1]);
        

        try{
            atendimento.adicionarPagamento(new PagamentoCartao(35.0D),
                                           new PagamentoPix(15.0D),
                                           new PagamentoDinheiro(50.0D)
                                        );

            atendimento.faturarAtendimento();

            atendimento2.adicionarPagamento(new PagamentoCartao(50.0D),
                                           new PagamentoPix(50.0D)
                                        );

            atendimento2.faturarAtendimento();

            atendimento3.adicionarPagamento(new PagamentoCartao(50.0D),
                                           new PagamentoPix(50.0D)
                                        );

            atendimento3.faturarAtendimento();
            
        } catch (Exception ex){
            System.out.println(ex);
        }
        
        System.out.println(atendimento);
        System.out.println(atendimento2);
        System.out.println(atendimento3);
    }
}