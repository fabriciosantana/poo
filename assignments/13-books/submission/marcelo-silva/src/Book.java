
public class Book {
    
    private String title;
    private int year;
    private String author;

    
    public Book(String title, int year, String author) {
        this.title = title;
        this.year = year;
        this.author = author;
    }

    
    @Override
    public String toString() {
        return String.format("Título: %s, Autor: %s, Ano: %d", 
                             this.title, this.author, this.year);
    }
}
