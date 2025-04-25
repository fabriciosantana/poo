public class Book {
    String title;
    int year;
    String author;

    public Book(String title, int year, String author) {
        this.title = title;
        this.year = year;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Título: " + this.title +
                "\nAutor: " + this.author +
                "\nAno de publicação: " + this.year;
    }
}