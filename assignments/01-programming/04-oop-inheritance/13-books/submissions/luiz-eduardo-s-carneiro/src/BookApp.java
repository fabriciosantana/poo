public class BookApp{
    public static void main(String[] Args){
        Book book = new Book("Harry Potter e as Relíquias da Morte", 2007, "J.K. Rowling");
        AudioBook audioBook = new AudioBook("Percy Jackson e o Ladrão de Raios", 2005, "Rick Riordan", 12.5, 377, "Intrínseca");
        PrintBook printBook = new PrintBook("Cinquenta Tons de Cinza", 2011, "E. L. James", "Intrínseca", "9788584391169");

        System.out.print(book.toString());
        System.out.print("----------------------------------------\n");
        System.out.print(audioBook.toString());
        System.out.print("----------------------------------------\n");
        System.out.print(printBook.toString());
        System.out.print("----------------------------------------\n");
    }
}