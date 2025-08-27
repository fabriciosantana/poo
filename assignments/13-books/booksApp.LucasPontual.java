public class BookApp {
    public static void main(String[] args) {
        Book genericBook = new Book("The Hitchhiker's Guide to the Galaxy", 1979, "Douglas Adams");
        PrintBook printBook = new PrintBook("Clean Code", 2008, "Robert C. Martin", "Prentice Hall", "978-0132350884");
        AudioBook audioBook = new AudioBook("The Lord of the Rings", 1954, "J.R.R. Tolkien", 750.5, 3300, "Andy Serkis");

        System.out.println("Livro Genérico: " + genericBook.toString());
        System.out.println("Livro Impresso: " + printBook.toString());
        System.out.println("Audiolivro: " + audioBook.toString());
    }
}


