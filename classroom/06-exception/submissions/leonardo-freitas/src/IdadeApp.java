public class IdadeApp {
    static void validarIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("A idade não pode ser negativa.");
        }
    }

    public static void main(String[] args) {
        validarIdade(25);
        System.out.println("IDADE VALIDA");

        try {
            validarIdade(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("IDADE INVALIDA");
        }
    }
}
