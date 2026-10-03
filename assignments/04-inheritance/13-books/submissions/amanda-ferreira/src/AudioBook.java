public class AudioBook extends Book{
    private double fileSizeInMB;
    private int playLengthInMinutes;
    private String narrator;

    public AudioBook(String title, int year, String author, double fileSizeInMB, int playLengthInMinutes, String narrator){
        super(title, year, author);
        this.fileSizeInMB = fileSizeInMB;
        this.playLengthInMinutes = playLengthInMinutes;
        this.narrator = narrator;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tamanho do arquivo em megabytes: " + fileSizeInMB + ", Duração em minutos do aúdio: " + playLengthInMinutes + ", Narrador: " + narrator;
    }

}