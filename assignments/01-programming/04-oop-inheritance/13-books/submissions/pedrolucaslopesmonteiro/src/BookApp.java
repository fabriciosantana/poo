public class BookApp {
    public static void main(String[] args) {
        Book book = new Book("Dom Casmurro", 1899, "Machado de Assis");

        PrintBook printBook = new PrintBook("O Senhor dos Anéis", 1954, "J.R.R. Tolkien", "Allen & Unwin", "978-0261102354");

        AudioBook audioBook = new AudioBook("Harry Potter e a Pedra Filosofal", 1997, "J.K. Rowling", 320.5, 498, "Jim Dale");

        System.out.println(book);
        System.out.println();
        System.out.println(printBook);
        System.out.println();
        System.out.println(audioBook);
    }
}