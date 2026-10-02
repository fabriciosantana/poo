public class PrintBook extends Book {
    private final String publisher;
    private final String isbn;

    public PrintBook(String title, int year, String author, String publisher, String isbn) {
        super(title, year, author);
        this.publisher = publisher;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return super.toString() + " | Editora: " + publisher + " | ISBN: " + isbn;
    }
}
