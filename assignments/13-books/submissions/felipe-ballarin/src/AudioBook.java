public class AudioBook extends Book {
    public double fileSizeInMB;
    public int playLengthInMinutes;
    public String narrator;

    public AudioBook(String title, int year, String author, double fileSizeInMB, int playLengthInMinutes, String narrator) {
        super(title, year, author); 
        this.fileSizeInMB = fileSizeInMB;
        this.playLengthInMinutes = playLengthInMinutes;
        this.narrator = narrator;
    }

    @Override
    public String toString() {
        return super.toString() + "AudioBook -> o tamanho do arquivo em MB é: " + fileSizeInMB + ", O tempo de execução em minutos é: " + playLengthInMinutes + "min, O narrador é: " + narrator + "\n";
    }

}