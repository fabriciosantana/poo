public class PrintBook extends Book {
    public static String publisher;
    public static String isbn;

    public PrintBook(String title, String author, int year, String publisher, String isbn) {
        super(title, author, year);
        this.publisher = publisher;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "PrintBook{" +
                "Título='" + title + '\'' +
                ", Autor='" + author + '\'' +
                ", Ano=" + year +
                ", Editora='" + publisher + '\'' +
                ", ISBN='" + isbn + '\'' +
                '}';
    }
}
