public class BookApp {

    public static void main(String[] args) {
        Book book = new Book(
            "Dom Quixote",
            1605,
            "Miguel de Cervantes"
        );

        PrintBook printBook = new PrintBook(
            "O Senhor dos Anéis",
            1954,
            "J.R.R. Tolkien",
            "Allen & Unwin",
            "978-0-261-10235-4"
        );

        AudioBook audioBook = new AudioBook(
            "Harry Potter e a Pedra Filosofal",
            1997,
            "J.K. Rowling",
            312.5,
            498,
            "Jim Dale"
        );

        System.out.println("=== Book ===");
        System.out.println(book);

        System.out.println("\n=== PrintBook ===");
        System.out.println(printBook);

        System.out.println("\n=== AudioBook ===");
        System.out.println(audioBook);
    }
}