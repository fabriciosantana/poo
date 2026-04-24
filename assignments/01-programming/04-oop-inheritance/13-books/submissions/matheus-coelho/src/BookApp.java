public class BookApp {
    public static void main(String[] args) {
        Book book = new Book("Clean Code", 2008, "Robert C. Martin");
        PrintBook printBook = new PrintBook("Java: How to Program", 2017, "Paul Deitel", "Pearson", "978-0-13-474335-6");
        AudioBook audioBook = new AudioBook("The Pragmatic Programmer", 2019, "David Thomas", 320.5, 630, "Anna Smith");

        System.out.println(book);
        System.out.println(printBook);
        System.out.println(audioBook);
    }
}
