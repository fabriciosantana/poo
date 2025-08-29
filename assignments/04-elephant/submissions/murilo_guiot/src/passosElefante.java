public class PassosElefante {

    public static int calcularPassosMinimos(int x) {
        if (x < 1 || x > 1_000_000) {
            throw new IllegalArgumentException("A posição deve estar entre 1 e 1.000.000.");
        }

        
        return (x + 4) / 5;
    }
    
    public static int calcularPassosMinimosAlternativo(int x) {
        if (x < 1 || x > 1_000_000) {
            throw new IllegalArgumentException("A posição deve estar entre 1 e 1.000.000.");
        }
        
        int passos = x / 5;
        if (x % 5 != 0) {
            passos++;
        }
        return passos;
    }

    public static void main(String[] args) {
        System.out.println("Calculando o número mínimo de passos para diferentes posições:");
        System.out.println("----------------------------------------------------------------");
        
        int x1 = 3;
        int passos1 = calcularPassosMinimos(x1);
        System.out.println("Posição: " + x1 + " -> Passos mínimos: " + passos1 + " (Esperado: 1)");

        int x2 = 15;
        int passos2 = calcularPassosMinimos(x2);
        System.out.println("Posição: " + x2 + " -> Passos mínimos: " + passos2 + " (Esperado: 2)");

        int x3 = 12;
        int passos3 = calcularPassosMinimos(x3);
        System.out.println("Posição: " + x3 + " -> Passos mínimos: " + passos3 + " (Esperado: 3)");

        int x4 = 999_999;
        int passos4 = calcularPassosMinimos(x4);
        System.out.println("Posição: " + x4 + " -> Passos mínimos: " + passos4 + " (Esperado: 200000)");

        System.out.println("\n----------------------------------------------------------------");
        System.out.println("Tentando calcular para uma posição inválida:");
        try {
            calcularPassosMinimos(0);
        } catch (IllegalArgumentException e) {
            System.err.println("Erro esperado: " + e.getMessage());
        }
    }
}