import java.time.LocalDateTime;

public class BBsitinApp {

    public static void main(String[] args) {
        LocalDateTime agora = LocalDateTime.of(2026, 10, 7, 9, 0);
        Agenda agenda = new Agenda(10);

        Baba ana = new Baba("Ana", 30, true);
        Baba bia = new Baba("Bia", 25, false);
        Familia silva = new Familia("Silva");
        Familia costa = new Familia("Costa");
        Crianca joao = new Crianca("João", 4);
        Crianca maria = new Crianca("Maria", 7);
        Crianca pedro = new Crianca("Pedro", 2);
        Crianca lia = new Crianca("Lia", 9);

        titulo("CASO DE USO 1: criar reserva");
        executar("Diurna com Bia, 2 crianças, 4h", () ->
                agenda.adicionar(new ReservaDiurna(silva, bia, new Crianca[]{joao, maria}, dia(8, 14), dia(8, 18))));
        executar("Noturna com Ana, 1 criança, 5h", () ->
                agenda.adicionar(new ReservaNoturna(costa, ana, new Crianca[]{pedro}, dia(8, 19), dia(9, 0))));
        executar("Fronteira: exatamente 3h e 3 crianças", () ->
                agenda.adicionar(new ReservaDiurna(costa, ana, new Crianca[]{pedro, lia, joao}, dia(8, 8), dia(8, 11))));
        executar("Noturna com Bia, que não faz pernoite", () ->
                agenda.adicionar(new ReservaNoturna(silva, bia, new Crianca[]{joao}, dia(9, 19), dia(9, 23))));
        executar("Bia em horário sobreposto", () ->
                agenda.adicionar(new ReservaDiurna(costa, bia, new Crianca[]{lia}, dia(8, 16), dia(8, 20))));
        executar("Reserva de 2h", () ->
                agenda.adicionar(new ReservaDiurna(costa, ana, new Crianca[]{lia}, dia(10, 8), dia(10, 10))));
        executar("4 crianças", () ->
                agenda.adicionar(new ReservaDiurna(silva, ana, new Crianca[]{joao, maria, pedro, lia}, dia(10, 14), dia(10, 18))));
        executar("Criança de 13 anos", () -> new Crianca("Rafa", 13));

        titulo("CASO DE USO 2: cancelar reserva");
        executar("Cancelar #3 com 23h de antecedência (cobra 50%)", () -> cancelar(agenda, 3, agora));
        executar("Fronteira: cancelar #1 com exatamente 24h de antecedência (sem multa)", () -> cancelar(agenda, 1, dia(7, 14)));
        executar("Cancelar #1 de novo", () -> cancelar(agenda, 1, agora));
        executar("Cancelar #99", () -> cancelar(agenda, 99, agora));

        titulo("CASO DE USO 3: consultar agenda e faturamento");
        for (Reserva r : agenda.todas()) {
            System.out.println(r);
        }
        Baba[] babas = {ana, bia};
        for (Baba b : babas) {
            System.out.println(b + ": " + agenda.daBaba(b).length + " reserva(s)");
        }
        System.out.printf("Faturamento total (valores + multas): R$ %.2f%n", agenda.faturamentoTotal());
        System.out.println("Objetos de reserva criados: " + Reserva.getTotalCriadas());
    }

    private static LocalDateTime dia(int dia, int hora) {
        return LocalDateTime.of(2026, 10, dia, hora, 0);
    }

    private static void cancelar(Agenda agenda, int id, LocalDateTime agora) {
        double multa = agenda.buscar(id).cancelar(agora);
        System.out.printf("   multa: R$ %.2f%n", multa);
    }

    private static void titulo(String texto) {
        System.out.println();
        System.out.println("=== " + texto + " ===");
    }

    private static void executar(String descricao, Runnable acao) {
        System.out.println("-> " + descricao);
        try {
            acao.run();
            System.out.println("   OK");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("   ERRO: " + e.getMessage());
        }
    }
}
