public class BookApp {
    public static void main(String[] args) {
        Book book = new Book("The Great Gatsby", 1925, "F. Scott Fitzgerald");
        System.out.println(book);

        PrintBook printBook = new PrintBook("The Great Gatsby", 1925, "F. Scott Fitzgerald", "Scribner", "978-0743273565");
        System.out.println(printBook);

        AudioBook audioBook = new AudioBook("The Great Gatsby", 1925, "F. Scott Fitzgerald", 150.5, 300, "Jake Gyllenhaal");
        System.out.println(audioBook);
    }
}