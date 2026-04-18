public class PrintBook extends Book{
    
    private String publisher;
    private String isbn;

    public PrintBook(String title, int year, String author, String publisher, String isbn){
        super(title, year, author);
        this.publisher = publisher;
        this.isbn = isbn;
    }

    public void setPublisher(String publisher){ this.publisher = publisher; }
    public String getPublisher(){ return publisher; }

    public void setISBN(String isbn){ this.isbn = isbn; }
    public String getISBN(){ return isbn; }

    @Override
    public String toString(){
        return String.format("%sEditora: %s\nCódigo ISBN: %s\n",
                            super.toString(), getPublisher(), getISBN());
    }
}