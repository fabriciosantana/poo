public class Book {
    
    private String title;
    private int year;
    private String author;

   
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    
    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    
    @Override
    public String toString() {
        return String.format("Título: %s\nAutor: %s\nAno: %d", title, author, year);
    }
}