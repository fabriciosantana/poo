public class BookApp {
    public static void main(String[] args) {
        PrintBook printBook = new PrintBook("O Senhor dos Anéis", "J.R.R. Tolkien", 1954, "Allen & Unwin", "978-0544003415");
        AudioBook audioBook = new AudioBook("Harry Potter e a Pedra Filosofal", "J.K. Rowling", 1997, 500.0, 480, "Stephen Fry");
        Book book = new Book("1984", "George Orwell", 1949);

        System.out.println(printBook.toString());
        System.out.println(audioBook.toString());
        System.out.println(book.toString());
    }
}
