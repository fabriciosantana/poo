public class PrintBook extends Book{
    private String publisher;
    private String isbn;

    public PrintBook(String title, int year, String author, String publisher, String isbn){
        super(title, year, author);

        this.publisher = publisher;
        this.isbn = isbn;

    }

    @Override
    public String toString(){
        return "Livro Impresso [Título: '" + super.title + "', Ano: '" + super.year + "', Autor: '" + super.author + "', Editora: '" + this.publisher + "', ISBN: '" + this.isbn + "']";
        }

    public String getPublisher(){
        return this.publisher;
    }
    public String getIsbn(){
        return this.isbn;
    }
    
    }

