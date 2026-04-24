public class BookApp {

    public static void main(String[] args) {
        Book book = new Book("Clean Code", 2008, "Robert C. Martin");

        PrintBook printBook = new PrintBook("Effective Java", 2018, "Joshua Bloch",
                "Addison-Wesley", "978-0134685991");

        AudioBook audioBook = new AudioBook("The Pragmatic Programmer", 2019, "David Thomas",
                320.5, 630, "Anna Katarina");

        System.out.println(book);
        System.out.println(printBook);
        System.out.println(audioBook);
    }
}