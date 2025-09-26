public class BookApp {
    public static void main(String[] args){
        Book genericBook = new Book("A Metamorfose", 1915, "Franz Kafka");
        
        PrintBook printBook = new PrintBook("Meridiano de Sangue", 1985, "Cormac McCarthy", "Alfaguara", "8556521096");
        
        AudioBook audioBook = new AudioBook("Duna", 1965, "Frank Herbert", 1225.72, 1262, "Regis");

        System.out.println("Livro Genérico: ");
        System.out.println(genericBook);
        System.out.println();

        System.out.println("Livro Impresso: ");
        System.out.println(printBook);
        System.out.println();

        System.out.println("Livro em Áudio: ");
        System.out.println(audioBook);
        System.out.println();


    }
}
