public class Book {
    public static String title;
    public static String author;
    public static int year;

    //construtor
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Título='" + title + '\'' +
                ", Autor='" + author + '\'' +
                ", Ano=" + year +
                '}';
    }
}
