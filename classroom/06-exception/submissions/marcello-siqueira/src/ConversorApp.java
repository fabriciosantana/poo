public class ConversorApp {

    public static void main(String[] argumentos) {
        try {
            System.out.println("Convertido: " + converter("123"));
            System.out.println("Convertido: " + converter("12a3"));
        } catch (NumberFormatException erro) {
            System.out.println("NUMERO INVALIDO");
        }
    }

    // throw lanca a excecao no momento em que o erro acontece, dentro do corpo do metodo.
    // throws apenas declara na assinatura que a chamada pode falhar, transferindo ao chamador
    // a decisao de tratar. Aqui quem lanca e o Integer.parseInt; o metodo so declara e propaga.
    static int converter(String texto) throws NumberFormatException {
        return Integer.parseInt(texto);
    }
}
