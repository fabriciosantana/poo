public class PrintBook extends Book{
    
    protected String publisher;
    protected String isbn;

    public PrintBook(String title, int year, String author, String publisher, String isbn){
        super(title, year, author);
        this.publisher = publisher;
        this.isbn = isbn;
    }

    @Override
    public String toString(){
        String string = super.toString();
        return(string + " - Publicador: " + this.publisher + " - ISBN: " + this.isbn);
    }
}
