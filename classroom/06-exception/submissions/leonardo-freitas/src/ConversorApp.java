public class ConversorApp {
    static int converter(String texto) throws NumberFormatException {
        return Integer.parseInt(texto);
    }

    public static void main(String[] args) {
        System.out.println("Valor convertido: " + converter("42"));

        try {
            System.out.println(converter("quarenta e dois"));
        } catch (NumberFormatException e) {
            System.out.println("NUMERO INVALIDO");
        }

        // throw lança uma exceção; throws declara na assinatura que o método pode propagá-la.
    }
}
