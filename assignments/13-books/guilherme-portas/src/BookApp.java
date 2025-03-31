import java.util.Scanner;

public class BookApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insira o nome de um livro: ");
        String title = scanner.nextLine();

        System.out.print("Insira o ano de publicação desse livro: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Insira o autor do livro: ");
        String author = scanner.nextLine();

        Book livro = new Book(title, year, author);
        System.out.println("\n" + livro.toString());

        System.out.println("\n-------- PrintBook ----------\n");
        System.out.print("Digite a editora do livro: ");
        String publisher = scanner.nextLine();

        System.out.print("Digite o código ISBN: ");
        String isbn = scanner.nextLine();

        PrintBook printBook = new PrintBook(title, year, author, publisher, isbn);
        System.out.println("\n" + printBook.toString());
        
        System.out.println("\n-------- AudioBook ----------\n");
        System.out.print("Insira o tamanho do arquivo em MB: ");
        Double fileSizeInMB = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Insira o tempo do audiobook em minutos: ");
        int playLengthInMinutes = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Insira o nome do narrador: ");
        String narrator = scanner.nextLine();

        AudioBook audioBook = new AudioBook(title, year, author, fileSizeInMB, playLengthInMinutes, narrator);
        System.out.println("\n" + audioBook.toString());

        scanner.close();
    }
}
