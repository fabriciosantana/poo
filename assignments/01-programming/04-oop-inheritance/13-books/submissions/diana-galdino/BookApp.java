public class BookApp {

    // Classe base
    static class Book {
        protected String title;
        protected int year;
        protected String author;

        public Book(String title, int year, String author) {
            this.title = title;
            this.year = year;
            this.author = author;
        }

        @Override
        public String toString() {
            return "Title: " + title +
                   ", Author: " + author +
                   ", Year: " + year;
        }
    }

    // Subclasse PrintBook
    static class PrintBook extends Book {
        private String publisher;
        private String isbn;

        public PrintBook(String title, int year, String author,
                         String publisher, String isbn) {
            super(title, year, author);
            this.publisher = publisher;
            this.isbn = isbn;
        }

        @Override
        public String toString() {
            return super.toString() +
                   ", Publisher: " + publisher +
                   ", ISBN: " + isbn;
        }
    }

    // Subclasse AudioBook
    static class AudioBook extends Book {
        private double fileSizeInMB;
        private int playLengthInMinutes;
        private String narrator;

        public AudioBook(String title, int year, String author,
                         double fileSizeInMB, int playLengthInMinutes, String narrator) {
            super(title, year, author);
            this.fileSizeInMB = fileSizeInMB;
            this.playLengthInMinutes = playLengthInMinutes;
            this.narrator = narrator;
        }

        @Override
        public String toString() {
            return super.toString() +
                   ", File Size: " + fileSizeInMB + "MB" +
                   ", Length: " + playLengthInMinutes + " min" +
                   ", Narrator: " + narrator;
        }
    }

    // Método principal
    public static void main(String[] args) {

        Book book = new Book("Java Programming", 2017, "Deitel");

        PrintBook printBook = new PrintBook(
                "Clean Code",
                2008,
                "Robert C. Martin",
                "Prentice Hall",
                "978-0132350884"
        );

        AudioBook audioBook = new AudioBook(
                "Atomic Habits",
                2018,
                "James Clear",
                350.5,
                320,
                "James Clear"
        );

        System.out.println(book);
        System.out.println(printBook);
        System.out.println(audioBook);
    }
}