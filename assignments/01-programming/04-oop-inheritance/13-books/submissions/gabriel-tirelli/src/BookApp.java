import java.util.ArrayList;

public class BookApp {
 
    public static void main(String[] args){
       
        ArrayList<Book> books = new ArrayList<Book>();

        books.add(new AudioBook("The Hobbit", 1937, "J.R.R. Tolkien", 680, 550, "Andy Serkis"));
        books.add(new AudioBook("1984", 1949, "George Orwell", 660, 500, "Simon Prebble"));

        books.add(new PrintBook("Clean Code", 2008, "Robert C. Martin", "Prentice Hall", "9780132350884"));
        books.add(new PrintBook("The Pragmatic Programmer", 1999, "Andrew Hunt", "Addison-Wesley", "9780201616224"));

        books.add(new Book("Dom Casmurro", 1899, "Machado de Assis"));
        books.add(new Book("The Alchemist", 1988, "Paulo Coelho"));

        for (int i = 0; i < 6; i++){
            System.out.println(books.get(i).toString());
            System.out.println("");
        }

    }

}
