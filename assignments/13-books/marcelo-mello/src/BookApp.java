public class BookApp {
    public static void main(String[] args) {
        Book livro1 = new Book("O Hobbit", 1937, "J.R.R. Tolkien");
        PrintBook livroImpresso = new PrintBook(
            "Java: Como Programar", 2017, "Deitel & Deitel", "Pearson", "978-0-13-474335-6"
        );
        AudioBook audioLivro = new AudioBook(
            "A Arte da Guerra", 2020, "Sun Tzu", 120.5, 90, "Carlos Silveira"
        );

        System.out.println("Informações dos livros:\n");
        System.out.println(livro1);
        System.out.println(livroImpresso);
        System.out.println(audioLivro);
    }
}
