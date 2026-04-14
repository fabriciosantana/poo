public class BookApp {
    public static void main(String[] args) {

        Book book = new Book("Java Basics", 2020, "John Doe");

        PrintBook printBook = new PrintBook(
                "Effective Java",
                2018,
                "Joshua Bloch",
                "Addison-Wesley",
                "978-0134685991"
        );

        AudioBook audioBook = new AudioBook(
                "Clean Code",
                2008,
                "Robert C. Martin",
                500.5,
                720,
                "Uncle Bob"
        );

        System.out.println(book);
        System.out.println(printBook);
        System.out.println(audioBook);
    }
}