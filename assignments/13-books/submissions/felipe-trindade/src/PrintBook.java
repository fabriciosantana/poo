public class PrintBook extends Book{
    private String publisher;
    private String isbnCode;

    public PrintBook(String title, String author, int year, String publisher, String isbnCode){
        super(title, author, year);
        this.publisher = publisher;
        this.isbnCode = isbnCode;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(" | Editora: ").append(publisher);
        sb.append(" | ISBN: ").append(isbnCode);
        return sb.toString();
    }
}
