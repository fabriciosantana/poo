public class ConteudosApp {

    public static void main(String[] argumentos) {
        ConteudoDigital livro = new LivroDigital("Java: How to Program", 180.00, 25.00);
        ConteudoDigital curso = new CursoOnline("Orientação a Objetos", 100.00, 12.0, 40.00);

        exibir(livro);
        exibir(curso);

        exibir(new LivroDigital("Taxas inválidas", -10.0, -5.0));
        exibir(new CursoOnline("Curso de fronteira", 0.0, 0.0, 0.0));
    }

    private static void exibir(ConteudoDigital conteudo) {
        System.out.printf("%s: base R$ %.2f, preço R$ %.2f%n",
                conteudo.obterTitulo(), conteudo.obterPrecoBase(), conteudo.calcularPreco());
    }
}
