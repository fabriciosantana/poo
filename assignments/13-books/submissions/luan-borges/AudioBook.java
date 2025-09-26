public class AudioBook extends Book {
    private double fileSizeInMB;
    private int playLengthInMinutes;
    private String narrator;

    public AudioBook(String title, int year, String author, double fileSizeInMB, int playLengthInMinutes, String narrator) {
        super(title, year, author);
        this.fileSizeInMB = fileSizeInMB;
        this.playLengthInMinutes = playLengthInMinutes;
        this.narrator = narrator;
    }

    public double getFileSizeInMB() {
        return fileSizeInMB;
    }

    public int getPlayLengthInMinutes() {
        return playLengthInMinutes;
    }

    public String getNarrator() {
        return narrator;
    }

    @Override
    public String toString() {
        return String.format("%s\nTamanho do Arquivo: %.2f MB\nDuração: %d minutos\nNarrador: %s",
                super.toString(), fileSizeInMB, playLengthInMinutes, narrator);
    }
}