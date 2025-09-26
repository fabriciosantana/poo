public class BookApp{
    public static void main(String[] args){
        Book b1 = new Book("Fundamentos da Computação", "Mariana Alves", 2020);

        PrintBook b2 = new PrintBook(
            "Algoritmos em Java", "João Pereira", 2019,
            "TechBooks", "978-85-123456-7-8"
        );

        AudioBook b3 = new AudioBook(
            "História da Programação", "Carla Mendes", 2021,
            280.4, 600, "Pedro Oliveira"
        );

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }
}