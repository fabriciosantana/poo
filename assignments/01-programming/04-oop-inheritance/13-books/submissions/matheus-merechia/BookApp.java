public class BookApp {

    public static void main(String[] args) {

        Book livro = new Book("Dom Casmurro", 1899, "Machado de Assis");

        PrintBook livroImpresso = new PrintBook(
                "Clean Code", 2008, "Robert C. Martin",
                "Prentice Hall", "978-0132350884"
        );

        AudioBook audioLivro = new AudioBook(
                "1984", 1949, "George Orwell",
                500.5, 680, "Simon Prebble"
        );

        System.out.println(" Livro Genérico ");
        System.out.println(livro);

        System.out.println("\n Livro Impresso ");
        System.out.println(livroImpresso);

        System.out.println("\n Audiolivro ");
        System.out.println(audioLivro);
    }
}
