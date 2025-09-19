public class BookApp {
    public static void main(String[] args) {
    Book genericBook = new Book("Fundamentos da Computação", 2020, "Mariana Alves");

    PrintBook printBook = new PrintBook(
            "Algoritmos em Java", 2019, "João Pereira",
            "TechBooks", "978-85-123456-7-8"
    );

    AudioBook audioBook = new AudioBook(
            "História da Programação", 2021, "Carla Mendes",
            280.40, 600, "Pedro Oliveira"
    );

    System.out.println(genericBook);
    System.out.println(printBook);
    System.out.println(audioBook);
}

}