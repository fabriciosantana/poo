public class AgenciaFlowApp {
    public static void main(String[] args) {
        System.out.println("=== AgenciaFlow - Demonstração ===\n");

        Cliente cliente = new Cliente("Cliente Demonstração", 15_000.00);
        Projeto projeto = new Projeto("Lançamento Digital", cliente);
        System.out.println(cliente);

        System.out.println("\nCASO DE USO 1 - Adicionar serviços ao projeto");
        Servico design = new ServicoDesign("Kit de identidade para campanha", 600, 4, true);
        Servico tecnologia = new ServicoTecnologia("Landing page de campanha", 900, 12, "MEDIA");
        System.out.println("Design adicionado: " + projeto.adicionarServico(design));
        System.out.println("Tecnologia adicionada: " + projeto.adicionarServico(tecnologia));

        System.out.println("\nCASO DE USO 2 - Orçamento polimórfico");
        Servico[] portfolio = projeto.listarServicos();
        for (Servico servico : portfolio) {
            System.out.printf("%s -> R$ %.2f%n", servico.getTipo(), servico.calcularValorFinal());
        }
        System.out.printf("Total consolidado: R$ %.2f%n", projeto.calcularTotal());

        System.out.println("\nCASO DE USO 3 - Buscar e concluir serviço");
        Servico encontrado = projeto.buscarServicoPorId(design.getId());
        System.out.println("Encontrado: " + encontrado);
        System.out.println("Conclusão do serviço: " + projeto.concluirServico(design.getId()));
        System.out.println("Tentar concluir o projeto antes de todos os serviços: " + projeto.concluirProjeto());

        System.out.println("\nCENÁRIO INVÁLIDO - criação de serviço com valor negativo");
        try {
            new ServicoDesign("Inválido", -10, 1, false);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro tratado: " + e.getMessage());
        }

        System.out.println("\nCASO DE FRONTEIRA - capacidade máxima de serviços");
        projeto.adicionarServico(new ServicoDesign("Posts sociais", 300, 3, false));
        projeto.adicionarServico(new ServicoTecnologia("Automação simples", 400, 3, "BASICA"));
        projeto.adicionarServico(new ServicoDesign("Banner adicional", 200, 1, false));
        boolean sextoServico = projeto.adicionarServico(new ServicoDesign("Serviço excedente", 100, 1, false));
        System.out.println("Quantidade atual: " + projeto.getQuantidadeServicos() + "/" + Projeto.CAPACIDADE_MAXIMA);
        System.out.println("Tentativa de adicionar sexto serviço: " + sextoServico);

        for (Servico servico : projeto.listarServicos()) {
            projeto.concluirServico(servico.getId());
        }
        System.out.println("Projeto concluído após finalizar todos os serviços: " + projeto.concluirProjeto());
        System.out.println(projeto);
    }
}
