import java.util.Locale;

public class ExpositorRefrigeradoApp {
    public static void main(String[] args) {
        ExpositorRefrigerado expositor1 = new ExpositorRefrigerado(5.0);
        exibir("Expositor 1 (Leitura segura)", expositor1);

        System.out.println();

        ExpositorRefrigerado expositor2 = new ExpositorRefrigerado(12.0);
        exibir("Expositor 2 (Fora da faixa)", expositor2);

        System.out.println();

        expositor2.definirTemperatura(3.5);
        exibir("Expositor 2 (Apos ajuste válido)", expositor2);

        System.out.println();

        expositor2.definirTemperatura(-300.0);
        exibir("Expositor 2 (Apos tentativa com valor inválido)", expositor2);
    }

    private static void exibir(String nome, ExpositorRefrigerado expositor) {
        System.out.println("--- " + nome + " ---");
        System.out.printf(Locale.US, "Temperatura: %.2f °C%n", expositor.obterTemperatura());
        System.out.println("Na faixa segura: " + (expositor.estaNaFaixaSegura() ? "Sim" : "Não"));
    }
}