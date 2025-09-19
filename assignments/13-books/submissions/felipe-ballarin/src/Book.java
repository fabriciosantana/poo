public class Book {
    public String title;
    public int year;
    public  String author;

    public Book (String title, int year, String author){
        this.title = title;
        this.year = year;
        this.author = author;
    }

    @Override 
    public String toString(){
        return "Book -> O título é: " + title + ", O autor é: " + author + ", O ano é: " + year + " \n";
    }
}
