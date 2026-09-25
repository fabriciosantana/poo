public class IdadeApp {

    public static void main(String[] argumentos) {
        try {
            validarIdade(30);
            System.out.println("Idade 30 aceita.");

            validarIdade(-5);
            System.out.println("Idade -5 aceita.");
        } catch (IllegalArgumentException erro) {
            // so a mensagem chega ao usuario; o stack trace ficaria ilegivel para quem nao programa
            System.out.println("IDADE INVALIDA");
            System.out.println("Motivo: " + erro.getMessage());
        }
    }

    static void validarIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("a idade não pode ser negativa, recebido " + idade);
        }
    }
}
