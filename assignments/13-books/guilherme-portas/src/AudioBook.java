public class AudioBook extends Book{
    double fileSizeInMB;
    int playLengthInMinutes;
    String narrator;

    public AudioBook(String title, int year, String author, Double fileSizeInMB, int playLengthInMinutes, String narrator) {
        super(title, year, author);
        this.fileSizeInMB = fileSizeInMB;
        this.playLengthInMinutes = playLengthInMinutes;
        this.narrator = narrator;
    }

    @Override
    public String toString() {
        return  "Título: " + this.title +
                "\nAutor: " + this.author +
                "\nAno de publicação: " + this.year +"Tempo em minutos: " + this.playLengthInMinutes +
                "\nTamanho do arquivo: " + this.fileSizeInMB + " MB " + 
                "\nNarrador: " + this.narrator + "\n"; 
    }
}
