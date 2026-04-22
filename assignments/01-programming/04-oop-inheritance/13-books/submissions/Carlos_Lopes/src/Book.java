public class Book{

    private String title;
    private int year;
    private String author;

    public Book(String title, int year, String author) {
    this.title = title;
    this.year = year;
    this.author = author;
    }

    public String getTitle() {return title;}
    public int getYear() {return year;}
    public String getAuthor() {return author;}

    public void setTitle(String title) {this.title = title; }
    public void setYear(int year) {this.year = year; }
    public void setAuthor(String author) {this.author = author; }

    public String toString(){
        return ("Título: " + title + "\nAno: " + year + "\nAutor: " + author);
    }

}