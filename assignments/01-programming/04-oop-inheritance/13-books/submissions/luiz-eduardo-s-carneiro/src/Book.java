public class Book{
    
    private String title;
    private int year;
    private String author;

    public Book(String title, int year, String author){
        this.title = title;
        this.year = year;
        this.author = author;
    }
    
    public void setTitle(String title){ this.title = title; }
    public String getTitle(){ return title; }
    
    public void setYear(int year){ this.year = year; } 
    public int getYear(){ return year; }
    
    public void setAuthor(String author){ this.author = author; }
    public String getAuthor(){ return author; }

    @Override
    public String toString(){
        return String.format("Título: %s\nAno: %d\nAutor: %s\n",
                            getTitle(), getYear(), getAuthor());
    }
       
}