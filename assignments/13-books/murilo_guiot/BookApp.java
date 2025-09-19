public class BookApp {
    public static void main(String[] args) {
        Book genericBook = new Book("A Origem das Espécies", 1859, "Charles Darwin");
        System.out.println("Livro genérico:");
        System.out.println(genericBook);
        System.out.println();

        PrintBook printBook = new PrintBook(
            "Java: Como Programar",
            2017,
            "Paul Deitel e Harvey Deitel",
            "Pearson",
            "978-0-13-474335-6"
        );
        System.out.println("Livro impresso:");
        System.out.println(printBook);
        System.out.println();

        AudioBook audioBook = new AudioBook(
            "O Hobbit",
            1937,
            "J.R.R. Tolkien",
            150.5,
            670,
            "Andy Serkis"
        );
        System.out.println("Audiolivro:");
        System.out.println(audioBook);
        System.out.println();
    }
}