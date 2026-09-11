public class BookApp {
    public static void main(String[] args) {
        Book book = new Book("Effective Java", 2018, "Joshua Bloch");
        Book printBook = new PrintBook(
                "Java: How to Program", 2017, "Paul Deitel e Harvey Deitel",
                "Pearson", "978-0-13-474335-6");
        Book audioBook = new AudioBook(
                "Clean Code", 2008, "Robert C. Martin",
                512.50, 960, "Narrador Exemplo");

        System.out.println(book);
        System.out.println(printBook);
        System.out.println(audioBook);
    }
}
