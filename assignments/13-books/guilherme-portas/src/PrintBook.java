public class PrintBook extends Book {
    String publisher;
    String isbn;

    public PrintBook(String title, int year, String author, String publisher, String isbn) {
        super(title, year, author);
        this.publisher = publisher;
        this.isbn = isbn;
    }
    
    @Override
    public String toString() {
        return  "Título: " + this.title +
                "\nAutor: " + this.author +
                "\nAno de publicação: " + this.year +
                "\nEditora: " + this.publisher + 
                "\nCódigo ISBN: " + this.isbn;
    }
}
