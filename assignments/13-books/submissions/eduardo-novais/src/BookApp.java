public class BookApp {
    public static void main(String[] args) {
        Book book = new Book ("O Hobbit", 1937, "J.R.R Tolkien");

        PrintBook printBook = new PrintBook("HarperCollins Brasil", "978-8595084742");

        AudioBook audioBook = new AudioBook(305.8, 665, "Rob Inglis");

        System.out.println(book);
        System.out.println(printBook);
        System.out.println(audioBook);
    }
}