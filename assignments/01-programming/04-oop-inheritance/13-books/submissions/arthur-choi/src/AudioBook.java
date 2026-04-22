public class AudioBook extends Book {
    public static double fileSizeInMB;
    public static int playLengthInMinutes;
    public static String narrator;
    
    public AudioBook(String title, String author, int year, double fileSizeInMB, int playLengthInMinutes, String narrator) {
        super(title, author, year);
        this.fileSizeInMB = fileSizeInMB;
        this.playLengthInMinutes = playLengthInMinutes;
        this.narrator = narrator;
    }

    @Override
    public String toString() {
        return "AudioBook{" +
                "Título='" + title + '\'' +
                ", Autor='" + author + '\'' +
                ", Ano=" + year +
                ", Tamanho do Arquivo=" + fileSizeInMB + " MB" +
                ", Duração=" + playLengthInMinutes + " minutos" +
                ", Narrador='" + narrator + '\'' +
                '}';
    }
    
}
