public class PrintBook extends Book{

    private String publisher;
    private String isbn;

    public PrintBook(String title, int year, String author, String publisher, String isbn) {
   
    super(title, year, author);

    this.publisher = publisher;
    this.isbn = isbn;

    }

    public String getPublisher() {return publisher;}
    public String getIsbn() {return isbn;}

    public void setPublisher(String publisher) {this.publisher = publisher;}
    public void setIsbn(String isbn) {this.isbn = isbn;}

    @Override
    public String toString(){
        return 
        ("Título: " + getTitle()
        + "\nAno: " + getYear()
        + "\nAutor: " + getAuthor()
        + "\nPublicadora: " +publisher
        + "\nIsbn: " +isbn);
    }


}
