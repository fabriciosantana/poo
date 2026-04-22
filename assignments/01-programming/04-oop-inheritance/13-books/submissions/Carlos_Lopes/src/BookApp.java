public class BookApp {
    public static void main(String[] args){

        Book meuBook  = new Book("Os Miseráveis" , 1862, "Victor Hugo");
        System.out.println("Book.java saída");
        System.out.println(meuBook.toString());

        PrintBook meuPrintBook = new PrintBook("Os Miseráveis" , 1862, "Victor Hugo", "Martin Claret", "978-8544000007");
        System.out.println("\nPrintBook.java saída");
        System.out.println(meuPrintBook.toString());

        AudioBook meuAudioBook = new AudioBook("Os Miseráveis", 1862, "Victor Hugo", 172, 492, "Monica Leite");
        System.out.println("\nAudioBook.java saída");
        System.out.println(meuAudioBook.toString());


    }

    
}
