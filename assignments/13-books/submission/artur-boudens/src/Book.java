public class Book{
    protected String title;
    protected int year;
    protected String author;

    public Book(String title, int year, String author){
        this.title = title;
        this.year = year;
        this.author = author;
    }

    @Override
    public String toString(){
        return "Livro [Título: '" + this.title + "', Ano: '" + this.year + "', Autor: " + this.year + "]";
    }
}
