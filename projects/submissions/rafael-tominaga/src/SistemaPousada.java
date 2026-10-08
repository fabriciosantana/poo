public class SistemaPousada {

    public static void main(String[] args) {
        Acomodacao[] catalogo = new Acomodacao[4];
        catalogo[0] = new QuartoStandard(101, 150.0, 2, false);
        catalogo[1] = new QuartoStandard(102, 180.0, 3, true);
        catalogo[2] = new SuitePresidencial(201, 500.0, 4, false);
        catalogo[3] = new SuitePresidencial(202, 750.0, 2, true);

        System.out.printf("Total de acomodações cadastradas via membro static: %d\n\n",
                Acomodacao.getTotalAcomodacoesCriadas());

        Hospede hospede1 = new Hospede("Ana Silva", "111.222.333-44");
        Hospede hospede2 = new Hospede("Carlos Eduardo", "555.666.777-88");
        Hospede hospede3 = new Hospede("Mariana Souza", "999.888.777-00");

        System.out.println("--- [1. CENÁRIO VÁLIDO: UC01 Check-in e UC03 Check-out] ---");
        try {
            // Check-in no quarto standard 102 para 2 pessoas e 3 diárias
            Hospedagem hospedagemValida = new Hospedagem(hospede1, catalogo[1], 2, 3);
            System.out.println("Check-in realizado com sucesso!");
            System.out.println("Detalhes: " + hospedagemValida);

            // Fechamento da estadia consumindo as 3 diárias
            double valorTotal = hospedagemValida.fecharHospedagem(3);
            System.out.printf("Check-out realizado. Total liquidado: R$ %.2f\n\n", valorTotal);
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        }

        System.out.println("--- [2. CENÁRIO INVÁLIDO: RN01 e RN04] ---");
        // Teste de capacidade excedida (RN04)
        try {
            System.out.println("Tentando alocar 3 pessoas no quarto 101 (capacidade máxima: 2)...");
            new Hospedagem(hospede2, catalogo[0], 3, 2);
        } catch (IllegalArgumentException e) {
            System.out.println("Validação capturada com sucesso: " + e.getMessage());
        }

        // Teste de quarto já ocupado (RN01)
        try {
            System.out.println("Realizando check-in no quarto 201...");
            new Hospedagem(hospede2, catalogo[2], 2, 2);

            System.out.println("Tentando realizar novo check-in simultâneo no mesmo quarto 201...");
            new Hospedagem(hospede3, catalogo[2], 1, 1);
        } catch (IllegalStateException e) {
            System.out.println("Validação capturada com sucesso: " + e.getMessage() + "\n");
        }

        System.out.println("--- [3. CENÁRIO DE FRONTEIRA: Capacidade Exata e RN05 Higienização] ---");
        try {
            // Caso de fronteira: limite exato da capacidade (4 pessoas no quarto 201)
            Hospedagem hospFronteira = new Hospedagem(hospede3, catalogo[3], 2, 1);
            System.out.println("Check-in de fronteira (capacidade exata de 2 pessoas): " + hospFronteira);

            // Fronteira de noites: 0 noites consumidas (cobrança de taxa mínima de higienização de R$ 80,00)
            double taxa = hospFronteira.fecharHospedagem(0);
            System.out.printf("Check-out com 0 noites consumidas: cobrança da taxa mínima R$ %.2f\n\n", taxa);
        } catch (Exception e) {
            System.out.println("Erro na fronteira: " + e.getMessage());
        }

        System.out.println("--- [4. UC02 - CONSOLIDAÇÃO E POLIMORFISMO COM ARRAY] ---");

        // Simulação: ocupando o quarto 101 para demonstrar filtros
        catalogo[0].ocupar();

        // 1ª Estrutura de repetição: for-each percorrendo o array tipado pela superclasse
        System.out.println("Percorrendo catálogo de acomodações:");
        int ocupadas = 0;
        int disponiveis = 0;

        for (Acomodacao acomodacao : catalogo) {
            if (acomodacao.isOcupada()) {
                ocupadas++;
            } else {
                disponiveis++;
            }
            System.out.println(" -> " + acomodacao.toString());
        }

        System.out.printf("\nResumo de Ocupação: %d Ocupada(s) | %d Disponível(is)\n", ocupadas, disponiveis);

        System.out.println("\nSimulação de faturamento para 5 diárias (Chamada Polimórfica):");
        double totalEstimado = 0.0;
        for (Acomodacao acomodacao : catalogo) {
            // Executa o calcularPrecoTotal específico de cada subclasse
            double subtotal = acomodacao.calcularPrecoTotal(5);
            totalEstimado += subtotal;
            System.out.printf(" Quarto %d: R$ %.2f\n", acomodacao.getNumero(), subtotal);
        }
        System.out.printf("Faturamento potencial consolidado: R$ %.2f\n\n", totalEstimado);

        // 2ª Estrutura de repetição: while para busca linear do primeiro quarto disponível
        System.out.println("Busca linear pelo primeiro quarto disponível:");
        int indice = 0;
        Acomodacao quartoEncontrado = null;

        while (indice < catalogo.length) {
            if (!catalogo[indice].isOcupada()) {
                quartoEncontrado = catalogo[indice];
                break;
            }
            indice++;
        }

        // Estrutura de seleção: switch moderno avaliando o tipo de quarto encontrado
        if (quartoEncontrado != null) {
            System.out.println("Quarto localizado para reserva imediata: Nº " + quartoEncontrado.getNumero());
            
            String categoria = switch (quartoEncontrado) {
                case QuartoStandard qs -> "Categoria Standard (Simplicidade e Conforto)";
                case SuitePresidencial sp -> "Categoria Presidencial (Alto Padrão e Exclusividade)";
                default -> "Categoria Genérica";
            };
            System.out.println("Classificação: " + categoria);
        } else {
            System.out.println("Nenhum quarto vago no momento.");
        }
    }
}
