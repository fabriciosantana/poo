public class AudioBook extends Book {
    private final double fileSizeInMB;
    private final int playLengthInMinutes;
    private final String narrator;

    public AudioBook(String title, int year, String author,
                     double fileSizeInMB, int playLengthInMinutes, String narrator) {
        super(title, year, author);
        this.fileSizeInMB = fileSizeInMB;
        this.playLengthInMinutes = playLengthInMinutes;
        this.narrator = narrator;
    }

    // concatenacao usa Double.toString, entao o decimal sai com ponto em qualquer locale
    @Override
    public String toString() {
        return super.toString() + " | Tamanho do arquivo: " + fileSizeInMB + " MB"
                + " | Duração: " + playLengthInMinutes + " min"
                + " | Narrador: " + narrator;
    }
}
