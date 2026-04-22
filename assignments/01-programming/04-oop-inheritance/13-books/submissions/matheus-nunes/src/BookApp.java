public class BookApp{
    public static class Book{
        public String title;
        public int year;
        public String author;

        public Book(String title, int year, String author){
            this.title = title;
            this.year = year;
            this.author = author;
        }
        @Override
        public String toString(){
            return "Titulo " + this.title + ", Ano: " + this.year + ", Autor: " + this.author;
        }
     }
     public static class PrintBook extends Book{
        public String publisher;
        public String isbn;

        public PrintBook(String title, int year, String author, String publisher, String isbn){
            super(title, year, author);
            this.publisher = publisher;
            this.isbn = isbn;
        }

        @Override
        public String toString(){
            return super.toString() + ", Editora: " + this.publisher + ", ISBN: " + this.isbn;
        }
     }

     public static class AudioBook extends Book{
        public double fileSizeInMB;
        public int playLengthInMinutes;
        public String narrator;

        public AudioBook(String title, int year, String author, double fileSizeInMB, int playLengthInMinutes, String narrator){
            super(title, year, author);
            this.fileSizeInMB = fileSizeInMB;
            this.playLengthInMinutes = playLengthInMinutes;
            this.narrator = narrator;
        }

        @Override
        public String toString(){
            return super.toString() + ", Tamanho do Arquivo: " + this.fileSizeInMB + " MB, Duração: " + this.playLengthInMinutes + " minutos, Narrador: " + this.narrator;
        }
     }
     public static void main(String[] args){

        Book livro1 = new Book("A revolução dos bichos", 1945, "George Orwell");
        PrintBook livro2 = new PrintBook("Memórias do Subsolo", 1864,"Fiódor Dostoiévski","Editora 34","978-8573266467");
        AudioBook livro3 = new AudioBook("O Pequeno Príncipe", 1943, "Antoine de Saint-Exupéry", 150.5, 120, "Matheus Nunes");
        System.out.println(livro1);
        System.out.println(livro2);
        System.out.println(livro3);
      }
}