public class ConteudosApp {
    public static void main(String[] argumentos) {
        ConteudoDigital livro = new LivroDigital("Java Orientado a Objetos", 39.90, 5.0);
        ConteudoDigital curso = new CursoOnline("POO na Prática", 99.90, 8.0, 20.0);

        exibir(livro);
        exibir(curso);
    }

    private static void exibir(ConteudoDigital conteudo) {
        System.out.printf("%s | Preço: R$ %.2f%n",
                conteudo.obterTitulo(),
                conteudo.calcularPreco());
    }
}
