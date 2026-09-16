public class CarteiraApp {
    public static void main(String[] args) {
        Carteira c1 = new Carteira("Ana", 500);
        Carteira c2 = new Carteira("Beto", 200);

        boolean t1 = c1.transferir(c2, 150);
        System.out.println("Transferência válida (150 de Ana para Beto): " + t1);
        System.out.println("Saldo Ana: " + c1.getSaldo());
        System.out.println("Saldo Beto: " + c2.getSaldo());

        boolean t2 = c1.transferir(c2, 1000);
        System.out.println("Transferência sem saldo (1000 de Ana para Beto): " + t2);
        System.out.println("Saldo Ana: " + c1.getSaldo());
        System.out.println("Saldo Beto: " + c2.getSaldo());

        boolean t3 = c1.transferir(null, 50);
        System.out.println("Transferência sem destino: " + t3);
        System.out.println("Saldo Ana: " + c1.getSaldo());
    }
}